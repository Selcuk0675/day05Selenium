package day04_Maven;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C02_Odev {
    public static void main(String[] args) {
        //https://www.google.com/ adresine gidin
        // 3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        //5-Arama cubuguna “Nutella” yazip aratin
        //6-Bulunan sonuc sayisini yazdirin
        //7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8-Sayfayi kapatin
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Samsung headphones", Keys.ENTER);
        System.out.println(driver.getTitle());

        System.out.println(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        List<WebElement> titleList=driver.findElements(By.xpath("//h1"));
        for (WebElement w: titleList){
            System.out.println(w.getText());
        }

    }
}
