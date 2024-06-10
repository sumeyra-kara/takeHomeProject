package com.myideasoft.pages;

import com.myideasoft.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//a[@title='Ürün']")
    public WebElement ürünButton;
}
