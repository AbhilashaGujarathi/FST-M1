package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Project.ActionBase.doSwipe;

public class Activity4 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium");
    }


    @Test
    public void appTest() {
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));
        Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));

        wait.until(ExpectedConditions.elementToBeClickable
                (AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        doSwipe(driver, start, end, 50);

        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]")).click();
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Task 1 added");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
