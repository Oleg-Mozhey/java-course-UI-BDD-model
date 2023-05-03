package Utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public abstract class WebPage {

    private Map<String, Object> namedElements;

    public SelenideElement getElement(String name) {
        Object instance = namedElements.get(name);
        return (SelenideElement) Optional.ofNullable(namedElements.get(name))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Element [%s] not found in class [%s]", name, this.getClass().getName())));
    }

    public WebElementWrapper getElementWrapper(String name) {
        Object instance = namedElements.get(name);
        return (WebElementWrapper) Optional.ofNullable(namedElements.get(name))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Element [%s] not found in class [%s]", name, this.getClass().getName())));
    }

    public ElementsCollection getElementsCollection(String name) {
        Object instance = namedElements.get(name);
        return (ElementsCollection) Optional.ofNullable(namedElements.get(name))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Element [%s] not found in class [%s]", name, this.getClass().getName())));
    }

    public String name() {
        return this
                .getClass()
                .getAnnotation(Name.class)
                .value();
    }

    public WebPage initialize() {
        namedElements = readNamedElements();
        return this;
    }

    private Map<String, Object> readNamedElements() {
        checkNamedAnnotations();
        return Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Name.class) != null)
                .peek(this::checkFieldType)
                .collect(toMap(f -> f.getDeclaredAnnotation(Name.class).value(), this::extractFieldValueViaReflection));
    }

    private void checkFieldType(Field f) {
        if (!SelenideElement.class.isAssignableFrom(f.getType())
                && !WebPage.class.isAssignableFrom(f.getType())
        ) {
            this.checkCollectionFieldType(f);
        }
    }

    private void checkCollectionFieldType(Field f) {
        if (ElementsCollection.class.isAssignableFrom(f.getType())) {
            return;
        } else if (List.class.isAssignableFrom(f.getType())) {
            ParameterizedType listType = (ParameterizedType) f.getGenericType();
            Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
            if (SelenideElement.class.isAssignableFrom(listClass) || WebPage.class.isAssignableFrom(listClass)) {
                return;
            }
        }
    }


    private void checkNamedAnnotations() {
        List<String> list = Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Name.class) != null)
                .map(f -> f.getDeclaredAnnotation(Name.class).value())
                .collect(toList());
    }

    private Object extractFieldValueViaReflection(Field field) {
        return LocatorStorage.extractFieldValue(field, this);
    }
}