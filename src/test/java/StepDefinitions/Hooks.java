package StepDefinitions;

import Utils.Environment;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();

        Environment.initPages("PackageName");
    }

    @After
    public void close() {
        WebDriverRunner.closeWebDriver();
        Environment.demountDriver();
    }
}
