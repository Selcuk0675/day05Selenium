package practice_erol_hoca_3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C06_Actions extends TestBase {
    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    ////New Tab butonunun görünür olduğunu doğrula


    @Test
    public void name() throws InterruptedException {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        WebElement kutu = driver.findElement(By.xpath("(//*[@class='card-up'])[6]"));
        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
        Actions actions = new Actions(driver);
        //actions.moveToElement(kutu).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(yazi.isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();
        Thread.sleep(3000);
        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New Tab']")).isDisplayed());
        //New Tab butonuna click yap
        driver.findElement(By.xpath("//*[text()='New Tab']")).click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
        //İlk Tab'a geri dön
        driver.switchTo().window(allWindow.get(0));
        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New Tab']")).isDisplayed());
    }
}
