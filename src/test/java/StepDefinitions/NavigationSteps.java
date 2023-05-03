package StepDefinitions;

import Utils.Environment;
import Utils.LocatorStorage;
import Utils.PageManager;
import Utils.WebPage;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {
    private final LocatorStorage _locatorStorage;
    Logger LOGGER = LogManager.getLogger();
    private PageManager pageManager;

    public NavigationSteps(LocatorStorage locatorStorage, PageManager manager) {
        this.pageManager = manager;
        _locatorStorage = locatorStorage;
    }

    @Given("url {string} is opened")
    public void urlIsOpened(String url) {
        open(url);
        WebPage page = Environment.getPage(url);
        pageManager.setCurrentPage(page);
    }
}
