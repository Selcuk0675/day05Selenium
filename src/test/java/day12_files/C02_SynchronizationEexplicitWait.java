package day12_files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_SynchronizationEexplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        //Start buttonuna tıkla
        //Hello World! Yazının sitede oldugunu test et
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[@id='start']//button")).click();
//        WebElement helloWorld=driver.findElement(By.xpath("//*[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!", helloWorld.getText());

        //imlicitWait ile test calismadi
        //cozum explicit wait

        //1.WebDriverWait objesini olustur
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        //2. wait objesini kullanarak bekleme probleminin  cozmeye calisiriz
       WebElement helloWorldElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
       String helloWorldtext=helloWorldElement.getText();
       Assert.assertEquals("Hello World!",helloWorldtext);


    }
}
