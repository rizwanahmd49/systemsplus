import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InterTest {

    WebDriver driver = new ChromeDriver();
    static By socialMediaLink = By.xpath("//div[contains(@class,'login-footer-sm')]/a");

    //div[contains(@class,'login-footer-sm')]//child::a
    public static void main(String[] args) {
        InterTest interTest = new InterTest();
        interTest.handleMultipleWindows();

    }

    protected void handleMultipleWindows() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        selectFromList(socialMediaLink, "linkedIn");
        selectFromList(socialMediaLink, "twitter");
        selectFromList(socialMediaLink, "facebook");
        selectFromList(socialMediaLink, "youtube");
        switchToWindow1("Facebook");
        closeWindow("Facebook");
        driver.quit();
    }

    private void switchToParentWindow() {

    }


    private void switchToWindow1(String windowTitle) {
        System.out.println("Trying to switch '"+windowTitle+"' Window");
        try {
            List<String> allWindows = driver.getWindowHandles().stream().toList();
            String parentWindow = driver.getWindowHandle();
            List<String>titles=new ArrayList<>();
            String text="";
            int size= allWindows.size();
            for (int i = 0; i <size; i++) {
                    String element=allWindows.get(i);
                    if (!element.equals(parentWindow)){
                        driver.switchTo().window(element);
                        String title=driver.getTitle();
                        titles.add(title);
                        text=text+title+"\n";
                        if (title.contains(windowTitle)){
                            System.out.println("Successfully switched to '"+windowTitle+"' Window");
                            break;
                        }
                    }
                    if (i==size-1) {
                        System.out.println("Unable to find the window  " + windowTitle + "'");
                        System.out.println("All open windows: \n"+titles);
                        System.out.println("All open windows: \n"+text);
                        driver.switchTo().window(parentWindow);
                    }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private void closeWindow(String windowTitle) {
        String title = driver.getTitle();
        if (title.contains(windowTitle)) {
            System.out.println("Trying to close Tab/Window " + title + "....");
            driver.close();
            System.out.println("Tab/Window " + title + " Closed Successfully!");
        }
    }

    private void selectFromList(By by, String itemNameToSelect) {
        List<WebElement> list = driver.findElements(by);
        for (int i = 0; i <= list.size(); i++) {
            WebElement element = list.get(i);
            String href = element.getAttribute("href");
            assert href != null;
            if (href.contains(itemNameToSelect.toLowerCase())) {
                scrollToViewElement(element).click();
                break;
            }

        }

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
}
