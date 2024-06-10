package com.myideasoft.tests.endToEndTests;

import com.myideasoft.pages.BasketPage;
import com.myideasoft.pages.BasePage;
import com.myideasoft.pages.ProductPage;
import com.myideasoft.utilities.BrowserUtils;
import com.myideasoft.utilities.ConfigReader;
import com.myideasoft.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    BasePage homePage =new BasePage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @Test
    public void smokeTest() {

        extentLogger = report.createTest("Shopping Test");
        extentLogger.info("Bu sayfaya gidilir "+ ConfigReader.get("url"));
        driver.get(ConfigReader.get("url"));

        extentLogger.info("Arama kısmına ürün yazılarak arama yapılır");
        homePage.searchBox.sendKeys(ConfigReader.get("aranacakKelime")+ Keys.ENTER);

        extentLogger.info("Arama sonucunda listelenen ürünün detayına girilir");
        productPage.ürünButton.click();

        extentLogger.info("Ilgili üründen 5 adet secilir");
        basketPage.ürünSayisiDogrulama();

        extentLogger.info("Secilen 5 adet ürün sepete eklenir");
        basketPage.sepeteEkle.click();

        extentLogger.info("SEPETİNİZE EKLENMİŞTİR yazısının görünmesi kontrol edilir");
        String expectedMessage="SEPETİNİZE EKLENMİŞTİR";
        String actualMessage=basketPage.sepeteEklenmisMesaji.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Sepet sayfasına gidilir");
        BrowserUtils.clickWithJS(basketPage.sepetButonu);

        extentLogger.info("Sepet içeriğinde ilgili üründen 5 adet olduğu kontrol edilir");
        String expectedUrunAdet ="5";
        String actualUrunAdet = basketPage.sepettekiUrunAdedi.getAttribute("value");
        Assert.assertEquals(actualUrunAdet,expectedUrunAdet);

        extentLogger.pass("Test basariyla gecti");

    }


}
