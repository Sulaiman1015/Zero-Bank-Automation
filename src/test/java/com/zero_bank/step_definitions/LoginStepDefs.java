package com.zero_bank.step_definitions;

import com.zero_bank.pages.AccountSummaryPage;
import com.zero_bank.pages.LoginPage;
import com.zero_bank.utilities.BrowserUtils;
import com.zero_bank.utilities.ConfigurationReader;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    private String actualErrorMessage;


    @Given("user is on login page")
    public static void user_is_on_login_page()  {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.cssSelector("button#signin_button")).click();


    }

    @When("user login with username {string} and password {string}")
    public void user_login_with_username_and_password(String username, String password) {

        loginPage.login(ConfigurationReader.get(username),ConfigurationReader.get(password));

    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageName) {
        String pageMenu = accountSummaryPage.accountSummary.getText();
        Assert.assertEquals("verify title",pageName.toLowerCase(),pageMenu.toLowerCase());
        Assert.assertTrue(accountSummaryPage.accountSummary.isDisplayed());

    }


    @Then("user login with wrong username {string} and password {string}")
    public void user_login_with_wrong_username_and_password(String username, String password) throws InterruptedException {
        //loginPage.logOut.click();
        //BrowserUtils.waitFor(2);
        //Driver.getDriver().findElement(By.cssSelector("button#signin_button")).click();

        //LoginStepDefs.user_is_on_login_page();

        if (username.equals("wrong") && password.equals("wrong")){
            loginPage.login(username,password);
            BrowserUtils.waitFor(2);
            actualErrorMessage = loginPage.getErrorMessage.getText();

        }else if (username.equals("") && password.equals("")){
            loginPage.login(username,password);
            BrowserUtils.waitFor(2);
            actualErrorMessage = loginPage.getErrorMessage.getText();

        }


    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String errorMessage) {

        Assert.assertEquals(errorMessage,actualErrorMessage);

       Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
    }


}
