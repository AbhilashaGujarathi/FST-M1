package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.google.android.keep")
                .setAppActivity(".activities.BrowseActivity")
                .noReset();

        //Set the appium severURL
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        //Initialize the android driver
        driver = new AndroidDriver(serverUrl, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addNotesKeepTest(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/new_note_button")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).
                sendKeys("Google Keep Title");

        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).
                sendKeys("Google keep description is added");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up")));
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/index_note_title")));
        String titleText = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();

        Assert.assertEquals(titleText, "Google Keep Title");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
