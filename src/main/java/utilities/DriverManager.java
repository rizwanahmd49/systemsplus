package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DriverManager {
    WebDriver driver = getDriver();
    public static ThreadLocal<WebDriver> thDriver = new ThreadLocal<>();

    public void launchChrome(String url) {
        System.out.println("Launching Chrome browser...");
        thDriver.set(new ChromeDriver());
        getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Chrome browser launched successfully!");
    }

    public void tearDown() {
        try {
            if (driver != null) {
                Thread.sleep(200);
                driver.quit();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() {
        this.driver = thDriver.get();
        return this.driver;
    }

}