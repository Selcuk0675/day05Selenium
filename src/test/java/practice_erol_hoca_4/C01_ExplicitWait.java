package practice_erol_hoca_4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    /*
                                 - Explicit Wait -
     Selenium’da Explicit Wait, Web Sürücüsüne belirli koşulları (Expected Condition) veya
 “ElementNotVisibleException” exception’ı atmadan önce aşılan maksimum süreyi beklemesini söylemek için kullanılır.
 Akıllı bir bekleme türüdür ancak yalnızca belirli öğeler(elementler) için uygulanabilir.
 Dinamik olarak yüklenen web elementleri beklerken implicit wait’ten daha iyi seçenekler sunar.
     Explicit Wait kullandığımızda, “ExpectedConditions” tanımlamalıyız veya Fluent Wait kullanarak durumu ne
 sıklıkla kontrol etmek istediğimizi yapılandırmalıyız.
Syntax:
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));

   Özetle, Implicit Wait genel bir bekleme süresidir ve tüm web elementleri için kullanılırken,
    Explicit Wait ise belirli bir web elementi için belirli bir süre boyunca bekleme yapar.


  */
    //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
    //Start button'nuna basalım
    //Hello World! yazısının çıktığını doğrulayalım
    @Test
    public void visibilityTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");
        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));
        //Start buttonuna bastıktan sonra Hello World! yazısı görünene kadar bekledik
        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
    }
    @Test
    public void invisibleTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");
        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading... ']")));
        //Start buttonuna bastıktan sonra Loading webelementi kaybolana kadar bekledik
        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
    }
}