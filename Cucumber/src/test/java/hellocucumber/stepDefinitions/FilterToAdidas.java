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

public class FilterToAdidas {

    public static final String CUSTOMERLIRON_AND_OFIR_TEST_COM = "CustomerlironAndOfir@test.com";
    public static final String LIRON_OFIR_123 = "LironOfir123!";
    public static final String HTTPS_CI_SIMPLCOMMERCE_COM = "https://ci.simplcommerce.com/";
    WebDriver driver;

    @Given("open browser filter")
    public void OpenBrowser() {
        System.out.println("STEP:  browser is open");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","C:\\git\\school\\sqe-hw3\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @And("^customer log in$")
    public void LogInAsCustomer() {
        System.out.println("STEP: user is logged in");
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "login");
        driver.findElement(By.name("Email")).sendKeys(CUSTOMERLIRON_AND_OFIR_TEST_COM);
        driver.findElement(By.name("Password")).sendKeys(LIRON_OFIR_123);
        driver.findElement(By.name("Password")).sendKeys(Keys.ENTER);

    }

    @And("^user goes to women category$")
    public void UserIsInWomenCategory() {
        System.out.println("STEP: user is in women products path");
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "woman");
    }

    @When("user checks product")
    public void userChecksProduct() {
        System.out.println("STEP: check product is by adidas");
        driver.findElement(By.xpath("//h5[text()='Shirt']")).click();
    }

    @Then("product is from adidas brand")
    public void productIsFromAdidasBrand() {
//        driver.findElement(By.xpath("//a[()='Adidas']")).click();
        driver.findElement(By.linkText("Adidas")).click();
        System.out.println("STEP: the product choosen is by adidas");
        driver.close();
        driver.quit();
    }

    @And("^user filters to brand adidas$")
    public void UserFiltersToAdidas() {
        System.out.println("STEP: filter products for adidas");
        driver.navigate().to(HTTPS_CI_SIMPLCOMMERCE_COM + "woman?brand=adidas&page=1&pageSize=10");
    }

}

