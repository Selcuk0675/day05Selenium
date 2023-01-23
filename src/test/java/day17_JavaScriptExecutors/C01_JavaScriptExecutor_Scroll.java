package day17_JavaScriptExecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JavaScriptExecutor_Scroll extends TestBase {
      /*
                scrollIntoViewTest metotu olustur
                Techpro education ana sayfasina git
                We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
                Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
                Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
                Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
     */

    @Test
    public void scrollIntoVieweTest() throws IOException {
        //  scrollIntoViewTest metotu olustur
        //                Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        // 1.Adim
        WebElement weOffer= driver.findElement(By.xpath("//*[text()='we offer']"));
        //2.Adiö
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //3.Adim
        //scrollIntoView(true) belirli bir elemana scroll yapmak icin kullanilir
        //argumants[0] ilk parametredeki element
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
       // js.executeScript("argumants[0].scrollIntoView(true);",weOffer);
       // js.executeScript("argumants[0].scrollIntoView(true);",weOffer);
        waitFor(3);
        //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
       takeScreenShotOfPage();
        //Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrolIntoViewJs(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();
        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement whyUs = driver.findElement(By.xpath("//h3[.='WHY US?']"));
        scrolIntoViewJs(whyUs);
        waitFor(3);
        //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrolIntoViewJs(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        //En uste cik
        scrollTopJS();
        waitFor(3);

        //En alta git
        scrollEndJS();
        waitFor(3);
    }
}