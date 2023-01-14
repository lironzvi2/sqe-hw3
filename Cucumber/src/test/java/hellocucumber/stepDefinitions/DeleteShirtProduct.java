package hellocucumber.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class DeleteShirtProduct {

    public static final String HTTPS_CI_SIMPLCOMMERCE_COM = "https://ci.simplcommerce.com/";
    public static final String ADMIN_SIMPLCOMMERCE_COM = "admin@simplcommerce.com";
    public static final String ADMIN_PAAWORD = "1qazZAQ!";
    WebDriver driver;

    @Given("open browser delete")
    public void OpenBrowser() {
        System.out.println("STEP:  browser is open");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","C:\\git\\school\\sqe-hw3\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Given("^admin log in$")
    public void AdminLogIn() {
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "login");
        driver.findElement(By.name("Email")).sendKeys(ADMIN_SIMPLCOMMERCE_COM);
        driver.findElement(By.name("Password")).sendKeys(ADMIN_PAAWORD);
        driver.findElement(By.name("Password")).sendKeys(Keys.ENTER);
    }

    @And("^admin goes to products$")
    public void GoToProducts() {
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "admin#!/product");
    }

    @And("^admin goes to dashboard control$")
    public void GoToDashboard() {
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "admin#!/dashboard");
    }

    @When("^admin deletes shirt product$")
    public void deleteProduct() {
        driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-remove'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

    }

    @Then("^the shirt product is deleted$")
    public void MakeSureProductIsDeleted() {
        driver.close();
        driver.quit();
    }

}
