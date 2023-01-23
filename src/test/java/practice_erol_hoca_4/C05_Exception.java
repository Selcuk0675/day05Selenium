package practice_erol_hoca_4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_Exception extends TestBase {
    @Test
    public void StaleElementReferansException() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //iphone aratalım
        //Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım
        List<WebElement> urunler=driver.findElements(By.partialLinkText("Apple iPhone"));
        //TEXT içinde Aplle İphone yazisi gecenleri alacam---->>>>By.partialLinkText
        for (int i = 0; i < urunler.size() ; i++) {
            urunler=driver.findElements(By.partialLinkText("Apple iPhone"));//Bunu buraya koymazsak StaleElementReferenceException verir
            urunler.get(i).click();
            driver.navigate().back();
            //StaleElementReferansException hatasını handle etmek için loop içine webelementlerden oluşturduğumuz
            //list'i koymalıyız

        }

            }
}
