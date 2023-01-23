package day04_practice_Burak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandles extends TestBase {
    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void WHANDLES() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String w1=driver.getWindowHandle();
        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("oppo", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();
        // Basligin 'Oppo' icerdigini test edin.
        List<String> list=new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(list.get(1));
        WebElement baslik=driver.findElement(By.xpath("//h1[@class='proName']"));
        String baslikStr= baslik.getText();
        Assert.assertTrue(baslikStr.contains("Oppo"));
        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(w1);
        System.out.println(driver.getTitle());

    }
}
