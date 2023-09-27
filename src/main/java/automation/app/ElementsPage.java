package automation.app;

import automation.Config;
import automation.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementsPage extends BasePageObject
{
    {
        this.wd().get(String.format("http://%s/elements",
                Config.HTTP_BASE_URL.value));
    }
    WebElement buttonsItem = this.wd().findElement(By.id("item-4"));

    public ButtonsPage goToButtonsPage() {
        if (buttonsItem.isDisplayed())
            buttonsItem.click();

        return new ButtonsPage();
    }
}
