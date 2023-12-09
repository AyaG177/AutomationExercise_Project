package Auto_Exercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class signupPage {
    private WebDriver driver;
    private final By signupPageTitle = By.xpath("//h2[contains(text(),\"New User\")]");
    private final By Name_input= By.xpath("//input[@placeholder='Name']");
    private final By Email_input= By.xpath("//input[@data-qa='signup-email']");
    private final By ClickOnSignup_Button= By.xpath("//button[@data-qa='signup-button']");
    public signupPage(WebDriver driver) {
        this.driver = driver;
    }
    public void newUserSignup(String Name, String Email){
        driver.findElement(Name_input).sendKeys(Name);
        driver.findElement(Email_input).sendKeys(Email);
        driver.findElement(ClickOnSignup_Button).click();
    }
    public void assertSignUppage(String expecteResult){
        String actualSignUpPageTitle = driver.findElement(signupPageTitle).getText();
        Assert.assertEquals(actualSignUpPageTitle,expecteResult);
    }
}
