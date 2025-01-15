package stepDefs;

import baseEntities.BaseTestHook;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import services.BrowsersService;

public class Hook extends BaseTestHook {
    private BaseTestHook baseTestHook;
    public Hook(BaseTestHook baseTestHook){
        this.baseTestHook = baseTestHook;
    }

    @Before()
    public void initBrowser() {
        baseTestHook.driver = new BrowsersService().getDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
