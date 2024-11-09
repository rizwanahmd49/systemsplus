package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverManager;
import utilities.Utilities;

public class HomePage extends Utilities {
    By srvPopCloseButton = By.id("closeSurveyPopup");
    By acceptCookies = By.id("onetrust-accept-btn-handler");
    By searchIcon = By.xpath("//a[contains(@aria-controls,'search-desktop-top')]");
    By searchField = By.xpath("//nav[@id='subnav-search-desktop-top']//input[@id='search-field']");
    By btnSearch = By.xpath("//nav[@id='subnav-search-desktop-top']//button");
    By searchResult = By.xpath("//div[@class='results container']/a[1]//h3");
    By btnFindCenter = By.cssSelector("nav[class='nav-shared txt-nav-hierarchy nav-top js-nav-shared js-nav-top'] li[class='nav-item displayed-desktop'] a[class='btn-nav btn btn-large btn-hollow color-nileblue global_header_findcenter track_cta_click']");
    By inputAddressSearch = By.id("addressInput");
    By txtNumOfFoundCenters = By.xpath("//span[@class='resultsNumber']");
    By addressList = By.xpath("//div[@id='center-results-container']//div[@class='heading-section']//h3");
    By txtSelectedCenter = By.xpath("//span[@class='mapTooltip__headline']");


    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    public void closeServeyPopup() {
        driver.findElement(srvPopCloseButton).click();
    }

    public void acceptCookies() {
        driver.findElement(acceptCookies).click();
    }

    public void clickOnSearchIcon() {
        driver.findElement(searchIcon).click();
    }

    public boolean isSearchFieldVisible() {
        return driver.findElement(searchField).isEnabled();
    }

    public void enterTextSearchField(String textToEnter) {
        driver.findElement(searchField).sendKeys(textToEnter);
    }

    public void clickOnSearchButton() {
        driver.findElement(btnSearch).click();
    }

    public String getSearchResult() {
        System.out.println("Trying to get Search Result");
        scrollToViewElement(searchResult);
        String  Result = getText(searchResult);
        System.out.println("Retrieved Search Result Successfully!");
        return Result;
    }

    public void clickOnFindCenter() {
        click(btnFindCenter, "Find a Center");
        waitForElementToBeClickable(inputAddressSearch,15);
    }

    public String getUrl() {
        System.out.println("Trying to get Current Url");

        String url = driver.getCurrentUrl();
        System.out.println("Current Url: " + url);
        return url;
    }

    public void typeTextAndPressEnter(String stringToEnter) {
        char[] charr = stringToEnter.toCharArray();
        WebElement element = driver.findElement(inputAddressSearch);
        element.sendKeys(Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        for (char c : charr) {
            element.sendKeys(String.valueOf(c));
        }
        hardWait(2);
        element.sendKeys(Keys.ENTER);

    }

    public int getNumOfFoundCenters() {
        System.out.println("Trying to get number of centers found...");
        String foundCenters = getText(txtNumOfFoundCenters);
        int centers = Integer.parseInt(foundCenters);
        System.out.println("Number of centers found: " + centers);
        return centers;
    }

    public int getAddressListCount() {
        System.out.println("Trying to get number of address list...");
        int actualAddressListCount = driver.findElements(addressList).size();
        System.out.println("Number of address list found: " + actualAddressListCount);
        return actualAddressListCount;
    }

    public String clickOnFirstAddressFromResult() {
        System.out.println("Trying to click on first address from result");
        scrollToViewElement(addressList);
        waitForElementToBeClickable(addressList, 10);
        WebElement element = driver.findElements(addressList).get(0);
        String text = element.getText();
        element.click();
        System.out.println("Selected Center '"+text+"' from result successfully");
        return text;

    }

    public String getSelectedCenterName() {
        System.out.println("Retrieving Selected Center Name..");
        waitForElementToBeClickable(txtSelectedCenter, 10);
        String selectedCenter = getText(txtSelectedCenter);
        System.out.println("Selected Center Name: " + selectedCenter);
        return selectedCenter;


    }


}
