package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import net.bytebuddy.build.AndroidDescriptor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppActivity(".Calculator")
                .setAppPackage("com.android.calculator2")
                .noReset();
        URL serveruRL = new URL("http://localhost:4723/wd/hub");

//initialize  the android driver
        driver = new AndroidDriver(serveruRL, caps);

    }

    @Test
    public void multiplyTest() {
// find the number 9 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();

        // find the * symbol and tap
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        // find th number 6 and tap
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        // find the symbol = and tap
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        // result
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();


        Assert.assertEquals(result, "54");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
