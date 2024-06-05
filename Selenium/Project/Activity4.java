package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity4 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void verify() {

        WebElement userName = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        //--------- Login
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        loginBtn.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //---------- CLick PIM
        WebElement PIM = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));

        PIM.click();
        //---------Add new
        WebElement addBtn = driver.findElement(By.xpath("//*[@id='btnAdd']"));
        addBtn.click();
        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
        firstName.sendKeys("Orange");
        lastName.sendKeys("OrangeHRM");
        // Save new
        WebElement btnSave = driver.findElement(By.xpath("//*[@id='btnSave']"));
        btnSave.click();
        //-------- view employee
        WebElement viewEmployee = driver.findElement(By.xpath("//*[@id='menu_pim_viewEmployeeList']"));
        viewEmployee.click();

        //------- search by Name
        WebElement searchName = driver.findElement(By.xpath("//*[@id='empsearch_employee_name_empName']"));
        searchName.sendKeys("Orange");
        //WebDriverWait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id='searchBtn']"));
        searchBtn.click();

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
