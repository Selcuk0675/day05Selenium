import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C06 extends TestBase {
    @Test
    public void name() {
       //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
       driver.get("https://automationfc.github.io/dynamic-loading/");
        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));
        Assert.assertTrue(driver.findElement(By.xpath("//h4")).isDisplayed());


        //Hello World! yazısının çıktığını doğrulayalım
    }

    @Test
    public void fgh() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");
        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed());

    }
}
