package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.google.android.apps.tasks")
                .setAppActivity(".ui.TaskListsActivity")
                .noReset();

        //Set the appium severURL
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        //Initialize the android driver
        driver = new AndroidDriver(serverUrl, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addTaskTest(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).
                sendKeys("Complete Activity with Google Tasks");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).
                sendKeys("Complete Activity with Google Keep");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).
                sendKeys("Complete the second Activity Google Keep");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        List<WebElement> taskItems = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));

        Assert.assertEquals(taskItems.size(), 3);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
