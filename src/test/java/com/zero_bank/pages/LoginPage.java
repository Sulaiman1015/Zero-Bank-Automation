package com.zero_bank.pages;

import com.zero_bank.utilities.BrowserUtils;
import com.zero_bank.utilities.ConfigurationReader;
import com.zero_bank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "user_login")//@FindBy(css = "input#user_login")
    public WebElement usernameInput;

    @FindBy(id = "user_password")//@FindBy(css = "input#user_password")
    public WebElement passwordInput;

    @FindBy(name = "submit")//@FindBy(css = "input[name='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement getErrorMessage;

    @FindBy(id = "logout_link")
    public WebElement logOut;

    public void login(String username,String password) {


        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        BrowserUtils.waitFor(3);
        submitButton.click();


    }
    //public void logOut(){
       // Driver.getDriver().findElement(By.id("logout_link")).click();

    //}
}
