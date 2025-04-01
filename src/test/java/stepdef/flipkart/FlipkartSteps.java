package stepdef.flipkart;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.FlipkartPage;

public class FlipkartSteps extends FlipkartPage {

    @Given("I am on Flipkart {string} home page")
    public void iAmOnFlipkartHomePage(String logoTitle) {
        System.out.println("Verifying if I am on Flipkart " + logoTitle + " home page");
        Assert.assertTrue(getLogoTitle().contains(logoTitle));
        System.out.println("Verified that I am on Flipkart " + logoTitle + " home page");
    }

    @When("I enter {string} in search field")
    public void i_enter_in_search_field(String string) {
        super.enterTextInSearchField(string);

    }

    @When("click on Search button on top right to search  box")
    public void click_on_search_button_on_top_right_to_search_box() {
       // click(btnSearch, "Search Button");

    }


    @Then("Verify if the first search result contains {string} in results")
    public void verifyIfTheFirstSearchResultContainsInResults(String textToCheck) {
        System.out.println("Trying to verify if the first search result contains " + textToCheck + " in results");
        String firstSearchItem = getText(firstSearchResult);
        Assert.assertTrue(firstSearchItem.contains(textToCheck));
        System.out.println("Verified the first search result " + textToCheck + " in results");
        hardWait(10);
    }

    @And("I select {string} from suggestion")
    public void  iSelectFromSuggestion(String optionToSelect) {
        selectItemFromSuggestion(optionToSelect);

    }
}
