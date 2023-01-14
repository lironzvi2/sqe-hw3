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

import static hellocucumber.stepDefinitions.DeleteShirtProduct.ADMIN_PAAWORD;
import static hellocucumber.stepDefinitions.DeleteShirtProduct.ADMIN_SIMPLCOMMERCE_COM;
import static hellocucumber.stepDefinitions.DeleteShirtProduct.HTTPS_CI_SIMPLCOMMERCE_COM;


public class AddProductShirt {
    WebDriver driver;

    @Given("open browser add")
    public void OpenBrowser() {
        System.out.println("STEP:  browser is open");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","C:\\git\\school\\sqe-hw3\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Given("^admin log in - add$")
    public void AdminLogIn() {
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "login");
        driver.findElement(By.name("Email")).sendKeys(ADMIN_SIMPLCOMMERCE_COM);
        driver.findElement(By.name("Password")).sendKeys(ADMIN_PAAWORD);
        driver.findElement(By.name("Password")).sendKeys(Keys.ENTER);
    }

    @And("^admin goes to products - add$")
    public void GoToProducts() {
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "admin#!/product");
    }

    @And("^admin goes to dashboard control - add$")
    public void GoToDashboard() {
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "admin#!/dashboard");
    }

    @And("^admin clicks on create Product$")
    public void CreateNewProduct() {
        driver.findElement(By.xpath("(//a[normalize-space()='Create Product'])[1]")).click();
    }
    @And("^admin enters price and name$")
    public void GiveProductNameAndPrice() {
        driver.findElement(By.name("name")).sendKeys("Shirt");
        driver.findElement(By.name("price")).sendKeys("45");
    }
    @When("^admin put product to category$")
    public void putProductToCategory() {
        driver.findElement(By.xpath("(//li[normalize-space()='Category Mapping'])")).click();
        driver.findElement(By.xpath("(//md-checkbox[normalize-space()='Woman'])")).click();
    }

    @When("^admin clicks save$")
    public void SaveProduct() {
        driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
    }

    @Then("product is added")
    public void CheckProductIsAdded() {
        driver.close();
        driver.quit();
    }
}
