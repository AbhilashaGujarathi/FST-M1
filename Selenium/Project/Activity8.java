package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
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
    }

    @Test(priority = 2)
    public void clickApplyLeave() {

        WebElement applyLeave = driver.findElement(By.xpath(
                "//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a/img"));

        applyLeave.click();

    }

    @Test(priority = 3)
    public void applyLeave() {


        WebElement selectLeaveType = driver.findElement(By.xpath("//*[@id='applyleave_txtLeaveType']"));

        Select dropdown = new Select(selectLeaveType);

        dropdown.selectByIndex(1);
        WebElement fromDate = driver.findElement(By.xpath("//*[@id='applyleave_txtFromDate']"));
        WebElement toDate = driver.findElement(By.xpath("//*[@id='applyleave_txtToDate']"));
        fromDate.clear();


        fromDate.sendKeys("2024-06-04");
        toDate.clear();
        toDate.sendKeys("2024-06-06");

        WebElement applyBtn = driver.findElement(By.xpath("//*[@id='applyBtn']"));
        applyBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 4)
    public void myLeaves() {

        WebElement myLeave = driver.findElement(By.xpath("//*[@id='menu_leave_viewMyLeaveList']"));

        myLeave.click();



        WebElement leaveStatus = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[6]/a"));

        System.out.println("Leave Status : " + leaveStatus.getText());

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
