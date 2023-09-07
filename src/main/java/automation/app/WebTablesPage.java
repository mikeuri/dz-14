package automation.app;

import automation.Config;
import automation.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePageObject
{
    {
        this.wd().get(String.format("http://%s/webtables",
                Config.HTTP_BASE_URL.value));
    }

    public void addItem(   String firstName,
                           String lastName,
                           String age,
                           String email,
                           String salary,
                           String department){
        WebElement buttonAdd = this.wd().findElement(By.id("addNewRecordButton"));
        buttonAdd.click();

        WebElement registrationForm = this.wd().findElement(By.xpath("//div[@class=\"modal-content\"]"));
        if (registrationForm.isDisplayed()){
            WebElement firstNameField = registrationForm.findElement(By.xpath("//div[@id=\"firstName-wrapper\"]//input"));
            WebElement lastNameField = registrationForm.findElement(By.xpath("//div[@id=\"lastName-wrapper\"]//input"));
            WebElement emailField = registrationForm.findElement(By.xpath("//div[@id=\"userEmail-wrapper\"]//input"));
            WebElement ageField = registrationForm.findElement(By.xpath("//div[@id=\"age-wrapper\"]//input"));
            WebElement salaryField = registrationForm.findElement(By.xpath("//div[@id=\"salary-wrapper\"]//input"));
            WebElement departmentField = registrationForm.findElement(By.xpath("//div[@id=\"department-wrapper\"]//input"));
            WebElement submitButton = registrationForm.findElement(By.id("submit"));

            firstNameField.sendKeys(firstName);
            lastNameField.sendKeys(lastName);
            emailField.sendKeys(email);
            ageField.sendKeys(age);
            salaryField.sendKeys(salary);
            departmentField.sendKeys(department);

            submitButton.click();
        }
    }

    public List<String> getItemData(int lineNumber){
        List<String> lastItemData = new ArrayList<String>();

        for (int i = 1; i <= 6; i++ ){
            String xpath = String.format("//div[@class=\"rt-tr-group\"][%s]//div[@class=\"rt-td\"][%s]", lineNumber, i);
            WebElement item = this.wd().findElement(By.xpath(xpath));
            lastItemData.add(item.getText());
        }

        return lastItemData;
    }

    public void editItemName(int lineNumber, String newName){
        String xpath = String.format("//span[@id=\"edit-record-%s\"]", lineNumber);
        WebElement editButton = this.wd().findElement(By.xpath(xpath));

        editButton.click();
        WebElement registrationForm = this.wd().findElement(By.xpath("//div[@class=\"modal-content\"]"));

        if (registrationForm.isDisplayed()){
            WebElement firstNameField = registrationForm.findElement(By.xpath("//div[@id=\"firstName-wrapper\"]//input"));
            firstNameField.clear();
            firstNameField.sendKeys(newName);

            WebElement submitButton = registrationForm.findElement(By.id("submit"));
            submitButton.click();
        }
    }
}
