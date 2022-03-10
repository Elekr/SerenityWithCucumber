package starter.stepdefinitions;

import Data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.navigation.DirectLineFormActions;

import java.util.List;

public class GetQuoteStepDefinitions {

    //Used to interact with the webpage
    @Steps
    DirectLineFormActions directLineFormActions;

    @Given("The user has accessed the website")
    public void the_customer_has_accessed_the_website() {
        //Sets the URL to the Direct Line Quote page
        directLineFormActions.toQuotePage();

    }
    @Given("user has accepted the cookies")
    public void accepted_the_cookies() {
        //Click on the accept cookies button (otherwise nothing else on the website is interactive)
        directLineFormActions.acceptCookies();
    }

    @When("the user enters {string} as the registation number")
    public void theUserEntersAsTheRegistationNumber(String testPlate) {
        directLineFormActions.enterRegistration(testPlate);
    }

    @When("click submit")
    public void click_submit() {
        directLineFormActions.clickSubmitButton();
    }

    @Then("the website will show the users car {string}")
    public void theWebsiteWillShowTheUsersCar(String carType) {
        //Checks the Car Type
        List<String> detailsReturned = directLineFormActions.getCarDetails();
        Assertions.assertEquals(carType, detailsReturned.get(0),"Wrong Car Type returned - Test Failed");
    }

    @And("the users car {string}")
    public void theUsersCar(String carDesc) {
        //Checks the Car Description
        List <String> detailsReturned = directLineFormActions.getCarDetails();
        Assertions.assertEquals(carDesc, detailsReturned.get(1),"Wrong Car Description returned - Test Failed");
    }

    @Given("The user wants to check if their car has been modified")
    public void theUserWantsToCheckIfTheirCarHasBeenModified() {
        //The user navigates the quote page
        directLineFormActions.toQuotePage();
    }

    @When("the user clicks the more info button")
    public void theUserClicksTheMoreInfoButton() {
        directLineFormActions.interactInformationButton();
    }

    @Then("the more info text will be shown to the user")
    public void theMoreInfoTextWillBeShownToTheUser() {
        Assertions.assertEquals(TestData.MODIFIED_HINT, directLineFormActions.returnModInfo(), "Wrong Description returned - Test Failed");
    }

    @Given("The user doesn't know their car registration")
    public void theUserDoesnTKnowTheirCarRegistration() {
    }

    @When("the user enters their car make")
    public void theUserEntersTheirCarMake() {
    }

    @And("the user answers the quote questions")
    public void theUserAnswersTheQuoteQuestions() {
    }

    @And("the user enters their car worth")
    public void theUserEntersTheirCarWorth() {
    }

    @And("the user enters their estimated mileage")
    public void theUserEntersTheirEstimatedMileage() {
    }


}
