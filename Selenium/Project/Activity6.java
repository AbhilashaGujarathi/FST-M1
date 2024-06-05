package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        //--------- Login
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 2)
    public void directory() {
        WebElement directory = driver.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']"));
        // Perform actions on the element
        if (directory.isDisplayed() && directory.isEnabled()) {
            // Click on the element
            directory.click();
            directory.click();
            System.out.println("Element is visible and clickable. Clicked on the element.");
        } else {
            System.out.println("Element is either not visible or not clickable.");
        }
    }

    @Test(priority = 3)
    public void verifyHeading() {
        WebElement heading = driver.findElement
                (By.xpath("//*[@id='content']/div[1]/div[1]/h1"));   //*[@id="content"]/div[1]/div[1]/h1

         //Assertion for page title
        Assert.assertEquals("Search Directory", heading.getText());
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
