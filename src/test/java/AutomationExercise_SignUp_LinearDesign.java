import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationExercise_SignUp_LinearDesign {
    private WebDriver driver;
    private final By NavigateToSignupPage_a =By.xpath("//a[@href=\"/login\"]");
    private final By Name_input= By.xpath("//input[@placeholder='Name']");
    private final By Email_input= By.xpath("//input[@data-qa='signup-email']");
    private final By ClickOnSignup_Button= By.xpath("//button[@data-qa='signup-button']");
    private final By Title= By.id("id_gender2");
    private final By Password= By.id("password");
    private final By Year= By.id("years");
    private final By Month= By.id("months");
    private final By Day= By.id("days");
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
    private final By ClickOnCreateAccountButton =By.xpath("//button[@data-qa='create-account']");
    private final By CreateAccountResult= By.tagName("b");

    @BeforeClass
    public void beforeMethod(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToHomePage();
    }
    @Test
    private void navigateToHomePage() {
        driver.navigate().to("https://automationexercise.com/");
    }
    @Test
    public void SignupPageTest(){
        navigateToSignupPage();
        newUserSignup("name","Email");
        enterAccountInformation("Mrs.","password","year","month","day");
        enterAddressInformation("First name","Last name","company","Address","Address2","country","state","city","Zipcode","Mobile number");
        clickOnCreateAccount();
        validateOnSignupMessage("message");
    }
    private void newUserSignup(String name, String email) {
        driver.findElement(Name_input).sendKeys("AyaGamal");
        driver.findElement(Email_input).sendKeys("aya200@teml.net");
        driver.findElement(ClickOnSignup_Button).click();
    }
    private void enterAccountInformation(String s, String password, String year, String month, String day) {
        driver.findElement(Title).click();
        driver.findElement(Password).sendKeys("D987654");
        driver.findElement(Year).sendKeys("2000");
        driver.findElement(Month).sendKeys("July");
        driver.findElement(Day).sendKeys("7");
    }
    private void enterAddressInformation(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(FirstName).sendKeys("Aya");
        driver.findElement(LastName).sendKeys("Gamal");
        driver.findElement(Company).sendKeys("AAAA");
        driver.findElement(Address1).sendKeys("Egypt-Giza");
        driver.findElement(Address2).sendKeys("Egypt-Giza0");
        driver.findElement(Country).sendKeys("India");
        driver.findElement(State).sendKeys("State");
        driver.findElement(City).sendKeys("Giza");
        driver.findElement(ZipCode).sendKeys("05555");
        driver.findElement(MobileNumber).sendKeys("01156924567");
    }
    private void clickOnCreateAccount() {
        driver.findElement(ClickOnCreateAccountButton).click();
    }

    private void validateOnSignupMessage(String message) {
        AssertOnCreateAccountResult("ACCOUNT CREATED!");
    }
    private void navigateToSignupPage() {
        GoToSignupPage();
    }
    ////////////////////////////////Actions////////////////////////////////
    private void GoToSignupPage() {
        driver.findElement(NavigateToSignupPage_a).click();
    }
    public void AssertOnCreateAccountResult(String expectedResult){
        String SignupMessage= driver.findElement(CreateAccountResult).getText();
        Assert.assertEquals(SignupMessage,expectedResult);
       // return driver.findElement(By.tagName("b")).getText();
    }
    //////////////////////////////Congigurations////////////////////////
    @AfterMethod
    public void  afterMethod(){driver.quit();}
}


