package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static activities.ActionBase.doSwipe;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the desired capabilities

        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();


        //Set the appium severURL
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        //Initialize the android driver
        driver = new AndroidDriver(serverUrl, caps);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test(priority = 1)
    public void loginValid() throws InterruptedException{
//        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int)(dims.getWidth()* 0.5), (int)(dims.getHeight()*0.8));
        Point end = new Point((int)(dims.getWidth()* 0.5), (int)(dims.getHeight()*0.6));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        doSwipe(driver, start, end, 50);

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[contains(@text,'Popups')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Sign In ']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Log in']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='action-confirmation']")));
        String message = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();

        Assert.assertEquals(message, "Welcome Back, admin");
    }

    @Test(priority = 2)
    public void loginInvalidCredentials(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Sign In ']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin2");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password1");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Log in']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='action-confirmation']")));
        String message1 = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();

        Assert.assertEquals(message1, "Invalid Credentials");
    }
}
