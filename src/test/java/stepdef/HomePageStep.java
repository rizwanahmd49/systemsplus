package stepdef;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;

public class HomePageStep extends HomePage {

    private String actualSearchText;
    private String centerNameFromSearchResult;

    @Given("Navigate to BH home page")
    public void navigate_to_bh_home_page() {
        System.out.println("Trying to Navigate to BH home page");
        acceptCookies();
        closeServeyPopup();

    }

    @Then("Verify if search field is visible on the page")
    public void verify_if_search_field_is_visible_on_the_page() {
        System.out.println("Verify if search field is visible on the page");
        Assert.assertEquals(isSearchFieldVisible(), true);
        System.out.println("The Search field is visible on the page");

    }


    @When("Click on search icon on top right corner")
    public void clickOnSearchIconOnTopRightCorner() {
        System.out.println("Trying to Click on search icon on top right corner");
        clickOnSearchIcon();
        System.out.println("Clicked on search icon on top right corner Successfully!");
    }

    @And("Enter {string} in search field")
    public void enterInSearchField(String searchText) {
        actualSearchText = searchText;
        System.out.println("Trying to enter " + searchText + " in search field");
        enterTextSearchField(searchText);
        System.out.println("Entered " + searchText + " in search field Successfully!");

    }

    @And("click on Search button under Search Bright Horizons")
    public void clickOnSearchButtonUnderSearchBrightHorizons() {
        System.out.println("Trying to click on Search button under Search Bright Horizons");
        clickOnSearchButton();
        System.out.println("Clicked on Search button under Search Bright Horizons Successfully!");
    }

    @Then("Verify if the first search result is exact match to provided search key")
    public void verifyIfTheFirstSearchResultIsExactMatchToProvidedSearchKey() {
        System.out.println("Verify if the first search result is exact match to provided search key");
        Assert.assertEquals(getSearchResult(), actualSearchText);
        System.out.println("The first search result is exact match to provided search key");
    }
//Scenario: Verify if center name and address


    @And("Verify page contains {string} as a part of its URL")
    public void verifyPageContainsAsAPartOfItsURL(String arg0) {
        System.out.println("Trying to Verify page contains " + arg0 + " as a part of its URL");
        String url = getUrl();
        Assert.assertTrue(url.contains(arg0));
        System.out.println("Verified page contains " + arg0 + " as a part of its URL");
    }

    @And("Type {string} into search box and press Enter")
    public void typeIntoSearchBoxAndPressEnter(String addressToSearch) {
        typeTextAndPressEnter(addressToSearch);
    }

    @And("verify if a number of found centers is the same as a number of centers displayed in list")
    public void verifyIfANumberOfFoundCentersIsTheSameAsANumberOfCentersDisplayedInList() {
        System.out.println("Verifying if a number of found centers is the same as a number of centers displayed in list");
        Assert.assertEquals(getAddressListCount(), getNumOfFoundCenters());
        System.out.println("Both the numbers are the same");
    }

    @And("Click on the first center on the list")
    public void clickOnTheFirstCenterOnTheList() {

        centerNameFromSearchResult = clickOnFirstAddressFromResult();

    }

    @Then("Verify if center name and address are the same \\(on the list and on the popup)")
    public void verifyIfCenterNameAndAddressAreTheSameOnTheListAndOnThePopup() {
        System.out.println("Verifying if center name and address are the same (on the list and on the popup)");
        String selectedCenterName=getSelectedCenterName();
        Assert.assertEquals(selectedCenterName,centerNameFromSearchResult);
        System.out.println("Selected Center is the same  on the popup");

    }

    @When("Click on Find a Center option on top header")
    public void clickOnFindACenterOptionOnTopHeader() {
        clickOnFindCenter();
    }

}
