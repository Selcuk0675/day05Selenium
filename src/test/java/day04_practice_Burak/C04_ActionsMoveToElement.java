package day04_practice_Burak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C04_ActionsMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

    @Test
    public void name() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com ");
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[text()='EN'])[1]"))).perform();
        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement box= driver.findElement(By.xpath("//*[@id='icp-dropdown']"));
       Select select=new Select(box);
        select.selectByVisibleText("Turkey (Türkiye)");

        //Not: burda dropdown acildigi icin driver alttaki box i gormuyor
        // bu yuzden rasgele nir yere tiklammamiz lazim
        driver.findElement(By.xpath("(//*[@class='a-text-bold'])[3]")).click();//bos bi yere click yaptik
        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@id='icp-save-button']")).click();
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        //Not: driver diger sayfada kaldigi icin windowHandles ile driver i oraya tasiyacaz
        List<String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));
        Assert.assertTrue(driver.getTitle().contains(" Elektronik"));


    }
}
