package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

import java.util.List;

public class FlipkartPage extends Utilities {
    protected By txtSearch = By.name("q");
    protected By btnSearch = By.className("MJG8Up");
    protected By logo = By.xpath("//img[@title='Flipkart' ]");
    protected By firstSearchResult = By.xpath("//div[@class='DOjaWF YJG4Cf']/div[2]/div[2]/div/div/div[1]//div[@class='KzDlHZ']");
    protected By autoSuggestions = By.xpath("//form[@action='/search']//ul/li//a/div[2]/span");


    protected String getLogoTitle() {
        String txt = driver.findElement(logo).getDomProperty("src");
        txt = txt.split("_")[1].split("-")[0];
        return txt;
    }


    protected void enterTextInSearchField(String string) {
        System.out.println("Trying to enter text '" + string + "' in search field");
        driver.findElement(txtSearch).sendKeys(string );
        System.out.println("Text '" + string + "' entered in search field Successfully!");
    }

    protected void selectItemFromSuggestion(String containsString) {
        System.out.println("Trying to select item '" + containsString + "' from suggestion");
        List<WebElement> elements = driver.findElements(autoSuggestions);
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println("Item from suggestion: " + text);
            if (text.contains(containsString)) {
                element.click();
                break;
            }
        }
        System.out.println("Item selected from suggestion Successfully!");
    }
}
