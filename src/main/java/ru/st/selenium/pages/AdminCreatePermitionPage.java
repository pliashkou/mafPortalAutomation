package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Permission;

import static org.testng.AssertJUnit.assertEquals;

public class AdminCreatePermitionPage extends AdminCreateItemPage {
    public AdminCreatePermitionPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Permission permission = (Permission) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAGE_NAME_FIELD_LOCATOR)));
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(permission.getName());
        log("Permission name '" + permission.getName() + "' was typed to name field");
        if (!permission.getName().equals("")) {
            putThreeRandomCheckboxes();
        }
    }

    public void checkRequiredFieldsMessages() {
        String message1 = driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//ul//li")).getText();
        log("Message 1 is '" + message1 + "'");
        assertEquals(message1, "The name field is required.");
        String message2 = driver.findElement(By.xpath("//div[@class = 'form-group col-md-12 has-error']/label[contains(text(), 'Name')]/../div[@class = 'help-block']")).getText();
        log("Message 2 is '" + message2 + "'");
        assertEquals(message2, "The name field is required.");

    }
}
