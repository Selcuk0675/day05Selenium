package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
        -Utilities tekrar tekrar kullanacagimiz classlari koydugumuz paketin adididr
            -TestBase
            -Driver-> Sonra
            -ExcelUtil-> Sonra
            -Configiration-> Sonra
        -Utilities Test case ler yazilmaz
        -Sadece tekrar kullanilabilecek destek(support) class lar olusturulur
        -Bunlar Test case lerin yazilmasini hizlandirr
     */
    @Test
    public void test(){
        // techpro ana sayfasina git ve titlin 'Bootcamp' icerdigini test edeleim
        driver.get("https://www.techproeducation.com");
        driver.getTitle();
        Assert.assertTrue(driver.getTitle().contains("Bootcamp"));
    }
}
