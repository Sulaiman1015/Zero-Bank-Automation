package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(className = "active")
    public WebElement accountSummary;
}
