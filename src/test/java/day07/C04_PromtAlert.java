package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromtAlert extends TestBase {
    //    3. butona tıklayın,
//    uyarıdaki metin kutusuna isminizi yazin,
//    OK butonuna tıklayın
//    ve result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    public void name() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Merhaba ben Selçuk");
        driver.switchTo().alert().accept();
        //You entered: Merhaba ben Selçuk
        Thread.sleep(3000);
        driver.findElement(By.id("result")).getText();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Selçuk"));
    }
}
