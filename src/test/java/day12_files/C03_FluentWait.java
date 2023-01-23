package day12_files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        //Start buttonuna tıkla
        //Hello World! Yazının sitede oldugunu test et
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[@id='start']//button")).click();
        //1.
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//Max bekleme suresi
                .pollingEvery(Duration.ofSeconds(3))//deneme araliklari
                .withMessage("IGNORE EXCEPTİON")//mecburi olmamakla braber mesaj yazabilirim
                .ignoring(NoSuchMethodException.class);//Exception u handle et optional
        //2.Wait objeseini kullanarak bekleme problemini coz
        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
        String helloWorldText=helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

    }
}
