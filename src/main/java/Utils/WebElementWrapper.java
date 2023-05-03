package Utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WebElementWrapper {
    private final String selector;

    public WebElementWrapper(String selector) {
        this.selector = selector;
    }

    public String selector(){
        return selector;
    }
    public SelenideElement locator(){
        return $(byXpath("//li[@class='item product product-item']"));
    }
}
