package Utils;

import com.codeborne.selenide.SelenideElement;

public class WatchElement {
    private final SelenideElement watch;

    public WatchElement(SelenideElement watch) {
        this.watch = watch;
    }

    public void hoverMouse(){
        watch.scrollTo().hover();
    }

    public void clickSubmitButton(){

        watch.$x(".//button").click();
    }

    public void clickDeleteButton(){
        watch.$x(".//a[@title='Remove item']").click();
    }

}
