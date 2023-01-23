package day17_JavaScriptExecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_Soru extends TestBase {
    @Test
    public void getValueTest() {
        //    *****ODEV*****
        // 1)getValueTest metotu olustur
        // 2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
        // 3)Tarih kısmındaki Yazili metinleri al ve yazdır
       // System.out.println(driver.findElement(By.xpath("//*[@id='hotelDates']")).getText());
        //Bu yukaridaki gibi text i alamiyuruz bu yuzden JS kullanacaz
        //reusable method
        getValueByJS("hotelDates");


    }
}
