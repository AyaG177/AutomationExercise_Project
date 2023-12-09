package Auto_Exercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class accountInformation {
    private WebDriver driver;
    private final By accountInfopageTitle = By.xpath("//b[contains(text(),\"Enter Account\")]");
    private final By Title= By.id("id_gender2");
    private final By Password= By.id("password");
    private final By Year_input= By.id("years");
    private final By Month_input= By.id("months");
    private final By Day_input= By.id("days");
    private final By newsLetter=By.id("newsletter");
    private final By option=By.id("optin");
    private final By FirstName= By.id("first_name");
    private final By LastName= By.id("last_name");
    private final By Company= By.id("company");
    private final By Address1= By.id("address1");
    private final By Address2= By.id("address2");
    private final By Country= By.id("country");
    private final By State= By.id("state");
    private final By City= By.id("city");
    private final By ZipCode= By.id("zipcode");
    private final By MobileNumber= By.id("mobile_number");
    private final By submitButton= By.xpath("//button[contains(text(),\"Create Account\")]");
    public accountInformation(WebDriver driver) {
        this.driver = driver;
    }
    public void enterAccountInfo(String password, String Day, String month, String year, String firstname,
                                    String lastname, String company, String address1, String address2,
                                    String country, String state, String city, String zipcode, String mobilenumber){
        driver.findElement(Title).click();
        driver.findElement(Password).sendKeys(password);
        Select daysList =new Select(driver.findElement(Day_input));
        daysList.selectByVisibleText(Day);
        Select monthList =new Select(driver.findElement(Month_input));
        monthList.selectByVisibleText(month);
        Select yearList =new Select(driver.findElement(Year_input));
        yearList.selectByVisibleText(year);
        driver.findElement(newsLetter).click();
        driver.findElement(option).click();
        driver.findElement(FirstName).sendKeys(firstname);
        driver.findElement(LastName).sendKeys(lastname);
        driver.findElement(Company).sendKeys(company);
        driver.findElement(Address1).sendKeys(address1);
        driver.findElement(Address2).sendKeys(address2);
        Select countrylist= new Select(driver.findElement(Country));
        countrylist.selectByVisibleText(country);
        driver.findElement(State).sendKeys(state);
        driver.findElement(City).sendKeys(city);
        driver.findElement(ZipCode).sendKeys(zipcode);
        driver.findElement(MobileNumber).sendKeys(mobilenumber);
        driver.findElement(submitButton).click();
    }
    public void assertEnterAccountInfoPage(String expectedResult){
        String actualAccountInfoTitle = driver.findElement(accountInfopageTitle).getText();
        Assert.assertEquals(actualAccountInfoTitle, expectedResult);
    }
}
