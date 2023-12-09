package Auto_Exercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class validationPage {
    private WebDriver driver;
    private final By accountInformationTitle= By.xpath("//b[contains(text(),\"Account Created\")]");
    public validationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void assertAccountCreated(String expectedResult){
        String actualAccountCreated = driver.findElement(accountInformationTitle).getText();
        Assert.assertEquals(actualAccountCreated, expectedResult);
    }
}
