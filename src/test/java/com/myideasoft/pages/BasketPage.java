package com.myideasoft.pages;

import com.myideasoft.utilities.BrowserUtils;
import com.myideasoft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasketPage {
    public BasketPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void ürünSayisiDogrulama(){
        WebElement dropDownMenu = Driver.get().findElement(By.xpath("//select[@id='qty-input']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("5");
    }
    @FindBy(xpath = "//span[text()='SEPETE EKLE']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//*[text()='SEPETİNİZE EKLENMİŞTİR']")
    public WebElement sepeteEklenmisMesaji;

    @FindBy(xpath = "//span[text()='Sepet']")
    public WebElement sepetButonu;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement sepettekiUrunAdedi;


}
