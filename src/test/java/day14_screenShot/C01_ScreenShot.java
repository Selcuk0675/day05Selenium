package day14_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    //Class : screenShot1
    //Techpro education a git ve Sayfanin goruntusunu al
    //-“QA” aramasi yap
    //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
    /*
            Selenyumda tum ekran goruntusu nasil alinir;

           -tum ekran goruntusu selenyumdan gelen getScreenshotAs metodu ile alinir.
           -getScreenshotAs metodu selenyumdaki TakesScreenshot api indan gelir.  api:aplication programing interface

     */


    @Test
    public void fullPageScreenShot() throws IOException {

        driver.get("https://www.techproeducation.com");
        // Windows + Shift + S  --EKRAN GORUNTUSU
        //1. Oncelikle biz ekran goruntusunu getScreenshotAs metodu ile alip File olarak olusturalim
      File goruntu=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//goruntuyu aldik daha kaydetmedik
        //2. Almiş oldugum ekran goruntusunu belirli bir patha ekledik   user.dir->user-directory dosya
        //Kayit ismini dinamik yapmak icn date objesi olusturduk
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);
        //3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);


        //        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
        //        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
        //                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path

        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+Keys.ENTER);
        waitFor(3);
        //        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));
//      REUSABLE METHOD yardimiyla GORUNTUYU ALALIM
        takeScreenShotOfPage();




    }
}
