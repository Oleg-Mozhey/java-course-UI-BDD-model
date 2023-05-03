package StepDefinitions;

import Utils.*;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.assertThat;


public class ButtonSteps {
    private final LocatorStorage _locatorStorage;

    private PageManager pageManager;

    public ButtonSteps(LocatorStorage locatorStorage, PageManager manager) {
        this.pageManager = manager;
        _locatorStorage = locatorStorage;
    }

    @When("user clicks on {string} button")
    public void buttonIsClicked(String buttonTitle){
        clickOnElement(buttonTitle + " button");
    }

    @When("user hovers a mouse over {string} element")
    public void hoverMouse(String elementTitle){
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementTitle);
        element.hover();
    }

    @When("user clicks on {string} dropdown item")
    public void dropdownIsClicked(String dropdownTitle){
        clickOnElement(dropdownTitle + " item");
    }

    @When("user clicks on {string} input")
    public void inputIsClicked(String inputTitle){
        clickOnElement(inputTitle + " input");
    }


    @When("user clicks on {string} radio button")
    public void radiobuttonIsClicked(String radiobuttonTitle){
        clickOnElement(radiobuttonTitle + " radiobutton");
    }

    @When("user clicks on {string} toggle")
    public void toggleIsClicked(String toggleTitle){
        clickOnElement(toggleTitle + " toggle");
    }

    @When("user clicks on {string} datepicker")
    public void datepickerIsClicked(String datepickerTitle){
        clickOnElement(datepickerTitle + " datepicker");
    }

    @When("user enters {string} in {string} datepicker")
    public void selectDate(String ddmmyyyy, String datepickerTitle){
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(datepickerTitle + " datepicker");
        element.sendKeys(ddmmyyyy);
    }

    @When("user enters next day in {string} datepicker")
    public void selectNextDate(String datepickerTitle){
        LocalDate currentDate = LocalDate.now();
        LocalDate result = currentDate.plusDays(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = result.format(dateTimeFormatter);
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(datepickerTitle + " datepicker");
        element.sendKeys(formattedDate);
    }

    public void clickOnElement(String elementTitle){
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementTitle);
        element.click();
        System.out.println("Clicked");
    }


    @When("user enters {string} in {string} input")
    public void enterText(String textToEnter, String inputTitle){
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(inputTitle + " input");
        element.sendKeys(textToEnter);
    }

    @Then("element {string} should become visible")
    public void checkVisibility(String elementTitle) throws InterruptedException {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementTitle);
        for (int i = 0; i < 6; i++){
            if (element.isDisplayed()) return;
            Thread.sleep(2000);
        }
        throw new RuntimeException();
    }

    @Then("element {string} should contain {string} text")
    public void checkElementText(String elementTitle, String expectedText) throws InterruptedException {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementTitle);
        for (int i = 0; i < 6; i++){
            if (element.getText().contains(expectedText)) return;
            Thread.sleep(2000);
        }
        throw new RuntimeException();
    }


    @And("user selected {string} color {string} size {string} shorts")
    public void userSelectedColorSizeShorts(String color, String size, String title) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElementsCollection("Shorts item")
                .filterBy(text(title)).get(0);

        ShortsElement shorts = new ShortsElement(element);
        shorts.selectSize(Integer.parseInt(size));
        shorts.selectColor(color);
        shorts.hoverMouseOverSize(Integer.parseInt(size));
        shorts.clickSubmitButton();
    }

    @And("user adds to cart watches with title {string}")
    public void userAddsToCartWatchesWithTitle(String title) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElementsCollection("Watch item")
                .filterBy(text(title)).get(0);

        WatchElement shorts = new WatchElement(element);
        shorts.hoverMouse();
        shorts.clickSubmitButton();
    }

    @When("user deletes {string} from minicart")
    public void userDeletesFromMinicart(String elementTitle) {
        SelenideElement minicart = pageManager
                .getCurrentPage()
                .getElement("Minicart");
        WebElementWrapper element2 = pageManager
                .getCurrentPage()
                .getElementWrapper("Product item");
        SelenideElement itemInMinicart = minicart.$$x("." + element2.selector()).filterBy(text(elementTitle)).get(0);
        WatchElement watchInMinicart = new WatchElement(itemInMinicart);
        watchInMinicart.clickDeleteButton();
    }
}
