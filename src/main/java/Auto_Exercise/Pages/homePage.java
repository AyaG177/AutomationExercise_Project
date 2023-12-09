package Auto_Exercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class homePage {
    private WebDriver driver;

    String homePageURL= "https://automationexercise.com/";

    // Locators
    private final By signupButton = By.xpath("//i[@class=\"fa fa-lock\"]");

    public homePage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public void navigateTohomePage() {
        driver.navigate().to(homePageURL);
    }
    public void clickonSignup() {
        driver.findElement(signupButton).click();
    }
    public void asserthomepage(String expecteResult){
        String actualHomePageTitle = driver.getCurrentUrl();
        Assert.assertEquals(actualHomePageTitle,expecteResult);
    }

}
