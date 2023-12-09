import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationExercise_SignUp {
    WebDriver driver;
    @Test
    public void signUpTest(){
        navigateToSignupPage();
        newUserSignup("name","Email");
        enterAccountInformation("Mrs.","password","year","month","day");
        enterAddressInformation("First name","Last name","company","Address","Address2","country","state","city","Zipcode","Mobile number");
        clickOnCreateAccount();
        validateOnSignupMessage("message");
    }
    private void newUserSignup(String name, String email) {
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("AyaGamal");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aya100@teml.net");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }
    private void enterAccountInformation(String s, String password, String year, String month, String day) {
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("D987654");
        driver.findElement(By.id("years")).sendKeys("2000");
        driver.findElement(By.id("months")).sendKeys("July");
        driver.findElement(By.id("days")).sendKeys("7");
    }
    private void enterAddressInformation(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(By.id("first_name")).sendKeys("Aya");
        driver.findElement(By.id("last_name")).sendKeys("Gamal");
        driver.findElement(By.id("company")).sendKeys("Giza");
        driver.findElement(By.id("address1")).sendKeys("Address1");
        driver.findElement(By.id("address2")).sendKeys("Address2");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("State");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("05555");
        driver.findElement(By.id("mobile_number")).sendKeys("01156924567");
    }
    private void clickOnCreateAccount() {
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }

    private void validateOnSignupMessage(String message) {
        String SignupMessage= driver.findElement(By.tagName("b")).getText();
        Assert.assertEquals(SignupMessage,"ACCOUNT CREATED!");
    }
    private void navigateToSignupPage() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToHomePage();
    }

    private void navigateToHomePage() {
        driver.navigate().to("https://automationexercise.com/");
    }
    @AfterMethod
    public void  afterMethod(){driver.quit();}
}
