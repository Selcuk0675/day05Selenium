package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
    // ve result mesajının "You clicked: Cancel" oldugunu test edin.
    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts

    @Test
    public void name() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();//cancel secenegine tikliyoruz
        driver.findElement(By.id("result"));
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult,actualResult);

    }
}
