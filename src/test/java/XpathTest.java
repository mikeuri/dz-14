import automation.app.ButtonsPage;
import automation.app.ElementsPage;
import automation.app.WebTablesPage;
import automation.base.BaseGUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathTest extends BaseGUITest
{
    @Test
    public void checkMessage() throws Throwable {
        ElementsPage    elementsPage = new ElementsPage();
        ButtonsPage     buttonsPage = elementsPage.goToButtonsPage();

        buttonsPage.buttonClickMe.click();
        Assert.assertEquals(buttonsPage.getMessageText(), "You have done a dynamic click");
    }

    @Test
    public void checkTable() throws Throwable {
        WebTablesPage webTablesPage = new WebTablesPage();
        webTablesPage.addItem(
                "John",
                "Doe",
                "30",
                "name@example.com",
                "5000",
                "Accounting");

        int lineNumber = 4;
        Assert.assertEquals(webTablesPage.getItemData(lineNumber).toString(), "[John, Doe, 30, name@example.com, 5000, Accounting]");

        webTablesPage.editItemName(lineNumber, "Jonny");
        Assert.assertEquals(webTablesPage.getItemData(lineNumber).toString(), "[Jonny, Doe, 30, name@example.com, 5000, Accounting]");
    }
}
