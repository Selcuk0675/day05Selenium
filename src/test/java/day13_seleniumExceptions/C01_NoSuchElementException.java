package day13_seleniumExceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    /*
            NoSuchElementException:
          * Yabnliş locator
          * PopUp, yeni pencere,iframe
          * sayfa dolmada proplem
          * sakli olam element

          --COZUM--
          * locator dogrulunu tekrar kontrol et
          * Manuel test ile iframe, newWindow,alert ...gibi elementlerin varligini kontrol etme
          * Beklme problemi vardir imlicitWait bizim bekleme problemimizi cozmuyor olabilir
            Bu durumda explicitWait ya da fluent wait kullaniriz
     */

    @Test
    public void noSuchElements() {
        //techproya git yanlis locator al
        driver.get("https://www.techproeducation.com");
        driver.
                findElement(By.xpath("//*[@type='searchh']")).//org.openqa.selenium.NoSuchElementException
                sendKeys("selcuk", Keys.ENTER);

    }
}
