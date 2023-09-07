package automation.base;

import automation.Config;
import automation.Session;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseGUITest extends BaseTestNG
{
    @BeforeMethod(alwaysRun = true)
    public void before() {
        this.wd().get(String.format("http://%s",
                Config.HTTP_BASE_URL.value));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        Session.get().close();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
