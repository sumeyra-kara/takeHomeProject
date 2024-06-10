package com.myideasoft.pages;

import com.myideasoft.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//input[@class='auto-complete']")
    public WebElement searchBox;


}
