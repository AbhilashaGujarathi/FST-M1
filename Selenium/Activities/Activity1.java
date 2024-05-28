package Activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {
        // Installing firefox driver
        WebDriverManager.firefoxdriver().setup();
        // web driver object
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/");
        System.out.println("Page Title : " + driver.getTitle());

        String heading = driver.findElement(By.cssSelector("h1.ui.header")).getText();
        System.out.println("Page heading : " + heading);

        // About Us link using id and click it
        driver.findElement(By.id("about-link")).click();
        // Print the title of the new page
        System.out.println("About page title: " + driver.getTitle());

        // Close the browser
        driver.close();

    }
}
