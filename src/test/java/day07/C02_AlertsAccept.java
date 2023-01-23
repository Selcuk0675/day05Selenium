package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {
    @Test
    public void acceptAlertTest() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts
//        1. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
//        uyarıdaki OK butonuna tıklayın
        Thread.sleep(3000);
        driver.switchTo().alert().accept();//bu islem sonucu ok secenegine tiklamis oluruz
//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert", driver.findElement(By.id("result")).getText());
       String hdh="You successfully clicked an alert";


    }
    /*
        How to handle allert in selenium?
        -Alertler javascript le olusur .Inspct edilemezler Oncelikle alerte switch edecez
     */
}