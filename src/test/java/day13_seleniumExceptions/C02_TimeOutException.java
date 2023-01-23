package day13_seleniumExceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
        TimeOutException:
            If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
            Simply put, wait time is over but the commend is not completed
            Solution:
            -Increase the wait time
            -Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
            -I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
            -Case by case, I prefer different explicit waits to maximize the performance of the automation script
            Collapse


     */

    /*           TimeOutException
      timeOut=Sure doldu
      * Sadece explicitWait kullanildigi zaman ve element bulunammadiginda alinir alinir
      * imlicitWait de noSuchElement aliriz
      * ExplicitWait & yanlis locator ->timeout
      * ExplicitWait & sure yeterli degil->timeout yani explicitWait varsa timeOut aliriz
               ----Solution----
      * sureyi artirabiliriz
      * farkli explicitWait kullaniriz
       - orn/ waitForVisibilityOfElementLocated YERİNE  presenceOfElementLocator.
       -Ya da javascript executor daki waiter sayfa gecişlerini beklemek icin kullanabilirim
      * Locatori tekrar kontrol etmek
      * Frameworkumde hazir reusable methodlar var
        Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz

     */

    @Test
    public void timeOutException() {
        driver.get("https://www.techproeducation.com");
        //ExplicitWait  icin olusturdugumuz methodlardan birini kullanalim
        //Parametre 1: beklemek istedigim elemnt, paramaetre 2: max sure
        //Rastgele yanlis xpath verdik problem olusturmak icin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yanliş İd")));// bu eleman icin bekleyelim
        //org.openqa.selenium.TimeoutException:

        /*
            EXPLİCİT WAİT KULLANACAZ ELEMANİ BULAMAYACAGİZ O ZAMAN ALİRİZ

         */
    }
}
