package practice_erol_hoca_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_Actions extends TestBase {
    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Çizimden sonra clear butonuna basalım
    - Son olarak sayfayı temizleyiniz
     */

    @Test
    public void drawing() {
        //http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement canvas= driver.findElement(By.xpath("//canvas"));
        Actions actions=new Actions(driver);
        actions.moveToElement(canvas).clickAndHold();
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);
              }
        actions.release().build().perform();//burda build() yukardi perform yapmadigimiz actions lari birlestirr
        //actions.click().keyUp().perform(); //release() mouse biraktirir
        //    - Çizimden sonra clear butonuna basalım
        waitFor(3);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
       // driver.findElement(By.xpath("//*[text()='Clear']")).click();
        //    - Son olarak sayfayı temizleyiniz

    }
}
