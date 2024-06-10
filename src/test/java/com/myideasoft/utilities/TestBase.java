package com.myideasoft.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {
    /*
     TestBase class'ini bu class'i parent edinecek class'larda driver olusturmamak ve ayarlari yeniden
     yapmamak icin kullaniyoruz.
      */
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;  // Bu obje raporu olusturmak ve rapor ile ilgili metadata'yi tabimlamak icin kullanilir
    protected ExtentHtmlReporter htmlReporter; // Bu obje raporumuzun html formatinda olmasini saglar

    protected ExtentTest extentLogger; // her test ile ilgili log kayitlarini ve test adimlarini tanimlamamizi saglar
    @BeforeTest
    public void setUpTest(){
        // initialize the object
        report=new ExtentReports();

        String projectPath = System.getProperty("user.dir"); // proje Yolu  //raporun kayit edilecegi yeri belirleyelim
        //String reportPath = projectPath+ "/test-output/report.html";
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String reportPath = System.getProperty("user.dir")+"/test-output/report"+date+".html";

        htmlReporter=new ExtentHtmlReporter(reportPath);   // html raporumuzu olusturalim

        report.attachReporter(htmlReporter);// html raporumuzu report (metadata) nesnesi ile iliskilendirelim

        htmlReporter.config().setReportName("Smoke Test");// raporun basligini duzenleyelim

        //raporun meta datasini duzenleyelim
        report.setSystemInfo("Enviroment","Test");
        report.setSystemInfo("Browser", ConfigReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("tester",System.getProperty("user.name"));
        report.setSystemInfo("PO",System.getProperty("Figen"));

    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }



    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        actions=new Actions(driver);

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE) { // eger testin sonucu basarisiz olursa

            String screenshotPath = BrowserUtils.getScreenshot(result.getName()); // ekran görüntüsünü alalim
            extentLogger.fail(result.getName()); // basarisiz testin adini alma
            extentLogger.addScreenCaptureFromPath(screenshotPath); // screenshotu rapora ekleme
            extentLogger.fail(result.getThrowable()); // log kayitlarini da ekliyorum
        }
        Driver.closeDriver();

    }

}
