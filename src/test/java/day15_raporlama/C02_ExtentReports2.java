package day15_raporlama;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ExtentReports2 extends TestBase {
    //HATİRLAMAMİZ GEREKEN 3 Class bunlari hepsi bir araya geliyo rapor olusturuyo
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public  static void extentReportsSetUp(){
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();


        //*************RAPORU CUSTOMIZE EDEBİLİRİZ****************
        //extentReports bunu kullanarak system bilgisi ekleyebiliriz
        //Bunlari bi kere yapariz sonra testlerimizi yapariz yani şablon olusturuyoz
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Lions");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Selcuk");

        //***********************Extra rapor ismi ve documan iismi ekleyebiliriz********************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Report");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");


        //***********************Configuration (Rapor) ayarlari bitti****************************
        //Son olarak raporu yapistirmamiz lazim yani raporu projemize ekliyoruz
        extentReports.attachReporter(extentHtmlReporter);

        //Extent Test Objesini olusturduk
        extentTest=extentReports.createTest("Extent Report login Test","Smoke Test Raporu");


    }

    @Test
    public void extentReportsTest() {
        extentTest.pass("PASS");
        extentTest.info("BİLGİLENDİRME NOTU");
        extentTest.fail("FAİLED");
        extentTest.warning("UYARİ MESAJİ");
        extentTest.skip("ATLAMA MESAJİ");
        extentTest.fatal("COKUS MESAJI");

    }

    @AfterClass
    public static void extentReportsTEARdOWN() throws Exception {
        extentReports.flush();

    }
    //https://files.slack.com/files-pri/T03MPM084DV-F04JYGTH3FC/image.png
}
