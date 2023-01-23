package practice_erol_hoca_3;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Actions extends TestBase {
    @Test
    public void name() {
        /*
        -http://spicejet.com/ sayfasına gidelim
        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        -Sayfa başlığının Fleet içerdiğini test edelim
     */

        //-http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        waitFor(3);
        driver.findElement(By.xpath("(//*[@class='css-76zvg2 r-homxoj'])[4]")).click();

        //        -Sayfa başlığının Fleet içerdiğini test edelim


    }
}
