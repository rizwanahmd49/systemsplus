package solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Utilities;

import java.time.Duration;

public class DynamicElement {

    @Test
    private void handleDynamicElement() {
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("window-size=1920x1080");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.worldometers.info/world-population/");
        String wordPopulation = driver.findElement(By.xpath("//span[@class='rts-counter']"))
                .getText();
        System.out.println("Word Population:"+wordPopulation);
        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
        ((JavascriptExecutor) driver).executeScript("window.open('','');");
        driver.quit();


    }


}
