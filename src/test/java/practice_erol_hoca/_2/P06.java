package practice_erol_hoca._2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P06 extends TestBase {
    @Test
    public void name() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");
        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).isDisplayed());
        // Elemental Selenium linkine tıklayın
        driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).click();
        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowHandles = " + windowHandles);
        driver.switchTo().window(windowHandles.get(1));//burda index s0 dan basliyo biz 1 dedigimizde ikinci sayfaya gecmis olacaz
        System.out.println(driver.getTitle());
        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='link']")).isDisplayed());

        // Source labs linkine tıklayın
        driver.findElement(By.xpath("//*[@class='link']")).click();
        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowHandles2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowHandles2 = " + windowHandles2);
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println(driver.getTitle());
        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(windowHandles2.get(0));
        // ilk sekmeyi kapatalım
        driver.close();


    }

}
