package practice_erol_hoca_4;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C06_ScreenShot extends TestBase {
    @Test
    public void screenShot() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Tüm sayfanın resmini alalım
        String tarih=new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ScreenShot/tumSayfa"+tarih+".jpeg"));
        /*
            FİLEUTİLS CLASS'İ FİLE NESNELEREİ İLE BİRLİKTE KULLANABİLECEGİMİZ METHODLAR İCERİR
            BU METHODLARİ KULLANARAK DOSYALARİ OKUMA ,YAZMA,VE KOPYALAMA İŞLEMLERİNİ
            COK DAHA KOLAY YAPABİLİRFİZX
         */
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ScreenShot/tumSayfa"+tarih+".jpeg"));
        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.navigate().back();
        //Arama sonucunun resmini alalım
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ScreenShot/tumSayfa"+tarih+".jpeg"));

    }
}
