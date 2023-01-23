package day14_screenShot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {
    /*
            Raporlama test execution dokuman yaparlar
            Test te manuel olarak vyaptigimiz kisa vadede kolaydir ama uznu vadede cok fazla vakit kaybidir
            Raporlama: bizm adim adim yaptigmiz test adimlarini dokumante etmek demektir
            1: bunu biz framework a koyariz rahat ederiz
            2: anlaşilir gerksiz detaylara yer vermeden tum detaylarin olmasi

            ExtentReport: selenyumun bir parcasi degildir.Dependicy lazim ayni JUnit gib
            bunun icin Maven repositorye gidip ordan dependicy almamaliyiz
               .JUnit
               .TestNG
               .Cucumber ve birkac tane daha frameeork te kullanilabilir
            En fazla Javada kullnilir
            ExtentReport ta farkli siniflar vardir farkli formatlar var

            Kullnaim amaclari:
              -Custom HTML raporlari olusturmak icn kullanir yani sirkete ozel seyler eklenebilir

     */
    //HATİRLAMAMİZ GEREKEN 3 Class bunlari hepsi bir araya geliyo rapor olusturuyo
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    @Test
    public void extentReportsTest() {

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

        //tum ayarlar bitti.Extent test objesi ile loglama(rapora yazdirma) isleminmi yapabilirim
        extentTest.pass("Kullanici Ana Sayfaya Gider");
        driver.get("https://www.techproeducation.com");

        //Lms sayfasina gidelim
        extentTest.pass("Kullanici LMS sayfasina gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //TEST bitti
        extentTest.pass("test basariyla gerceklesti");

        //Raporu gostermek icin; ve extent raporu kapatir bu adim ZORUNLUDUR
        extentReports.flush();

        //https://files.slack.com/files-pri/T03MPM084DV-F04JQ638GQP/image.png


    }
}
