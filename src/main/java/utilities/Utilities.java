package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Utilities {


    public WebDriver driver = new DriverManager().getDriver();


    public void click(By byLocatorToClick, String fieldName) {
        try {
            System.out.println("Trying to click on '" + fieldName + "'..... ");
            waitForElementToBeClickable(byLocatorToClick, 15).click();
            System.out.println("Clicked on '" + fieldName+"' Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public String getText(By by){
        WebElement element = driver.findElement(by);
        String text=element.getText();
        return text;
    }

    public WebElement waitForElementToBeClickable(By byLocator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(byLocator));
    }


    public WebElement scrollToViewElement(By byLocator) {
        WebElement element = driver.findElement(byLocator);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        System.out.println("Trying to scroll to view the element");
        if (driver.toString().contains("firefox")) {
            jse.executeScript("arguments[0].scrollIntoView();", element);
            System.out.println("scroll command executed in Firefox");
        } else {
            ((JavascriptExecutor) driver).
                    executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
            System.out.println("scroll command executed in Chrome");
        }
        return element;
    }

    public WebElement scrollToViewElement(WebElement element) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        System.out.println("Trying to scroll to view the element");
        if (driver.toString().contains("firefox")) {
            jse.executeScript("arguments[0].scrollIntoView();", element);
            System.out.println("scroll command executed in Firefox");
        } else {
            ((JavascriptExecutor) driver).
                    executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
            System.out.println("scroll command executed in Chrome");
        }
        return element;
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



   

   




}

