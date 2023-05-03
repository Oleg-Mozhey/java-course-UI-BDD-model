package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

public class LocatorStorage {
    Logger LOGGER = LogManager.getLogger();

    public static Set<Class<?>> getPagesAnnotatedWith(String packageName, Class<? extends Annotation> annotation) {
        return new Reflections(packageName).getTypesAnnotatedWith(annotation);
    }

    public static Object extractFieldValue(Field field, Object owner) {
        field.setAccessible(true);
        try {
            return field.get(owner);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            field.setAccessible(false);
        }
    }
}
