package Utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Environment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);
    private static final ThreadLocal<WebDriver> THREAD_DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return THREAD_DRIVER.get();
    }

    public static void setThreadDriver(WebDriver threadDriver) {
        THREAD_DRIVER.set(threadDriver);
    }

    /**
     * Список веб-страниц, заданных пользователем, доступных для использования в сценарии
     */
    private static PagesWithRegisteredElementsCache pages;

    /**
     * Метод ищет классы, аннотированные "ru.absolut.annotations.Name",
     * добавляя ссылки на эти классы в поле "pages"
     *
     * @param packageName наименование пакета где лежат файлы с описанием страниц
     */
    @SuppressWarnings("unchecked")
    public static void initPages(String packageName) {
        pages = new PagesWithRegisteredElementsCache();
        LocatorStorage
                .getPagesAnnotatedWith("Utils", Name.class)
                .stream()
                .map(it -> {
                    if (WebPage.class.isAssignableFrom(it)) {
                        return (Class<? extends WebPage>) it;
                    } else {
                        throw new IllegalStateException("Класс " + it.getName() + " должен наследоваться от WebPage");
                    }
                })
                .forEach(clazz -> pages.put(getClassAnnotationValue(clazz), clazz));
        if (pages.quantity() == 0){
            throw new RuntimeException("Found 0 pages with elements");
        }
    }

    /**
     * Вспомогательный метод, получает значение аннотации "ru.absolut.annotations.Name" для класса
     */
    private static String getClassAnnotationValue(Class<?> c) {
        return Arrays
                .stream(c.getAnnotationsByType(Name.class))
                .findFirst()
                .map(Name::value)
                .orElseThrow(() -> new AssertionError("Не найдены аннотации Page.Name в классe " + c.getName()));
    }

    public static WebPage getPage(String name) {
        return pages.get(name);
    }

    public static void demountDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        THREAD_DRIVER.set(null);
        LOGGER.info("close webdriver thread: {}", Thread.currentThread().getId());
    }
}