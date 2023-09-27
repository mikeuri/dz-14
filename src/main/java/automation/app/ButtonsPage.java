package automation.app;

import automation.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends BasePageObject
{
    final public WebElement buttonClickMe = this.wd().findElement(By.xpath("//div[@class=\"mt-4\"][2]/button"));

    public String getMessageText(){
        return this.wd().findElement(By.xpath("//*[@id=\"dynamicClickMessage\"]")).getText();
    }
}
