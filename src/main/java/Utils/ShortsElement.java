package Utils;

import com.codeborne.selenide.SelenideElement;

import java.lang.constant.Constable;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byXpath;

public class ShortsElement {
    private final SelenideElement shorts;

    public ShortsElement(SelenideElement shorts) {
        this.shorts = shorts;
    }

    public void selectSize(int size){
        shorts.scrollTo();
        SelenideElement sizeButton = shorts.$x(".//div[text() = '" + size + "']");
        sizeButton.click();
    }

    public void selectColor(String color){
        shorts.scrollTo();
        String formattedColor = (color.charAt(0) + "").toUpperCase() + color.substring(1);
        shorts.$(byXpath(".//div[@option-label='" + formattedColor + "']")).click();
    }

    public void hoverMouseOverSize(int size){
        shorts.scrollTo();
        shorts.$(byXpath(".//div[contains(string(), '" + size + "')]")).hover();
    }

    public void clickSubmitButton(){
        shorts.$(byXpath(".//button")).click();
    }
}
