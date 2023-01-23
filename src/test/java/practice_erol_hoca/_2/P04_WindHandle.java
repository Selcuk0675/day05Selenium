package practice_erol_hoca._2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P04_WindHandle extends TestBase {
    @Test
    public void name() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
        String w1=driver.getWindowHandle();//Bunun la Sayfanin hash code Unu aldik
        //Sayfa title’nin “Amazon” icerdigini test edin
        driver.getTitle();
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//Yeni bir sekme acmis olduk
        driver.get("https://www.techproeducation.com ");
        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));
        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
       // driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.walmart.com ");
        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(w1);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));


    }
}
