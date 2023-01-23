package day03_practice_Burak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
    // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
    // TextBox'a 'Merhaba Dunya' yazin.
    // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin

    @Test
    public void iframe() {
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get(" https://the-internet.herokuapp.com/iframe");
        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslik=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.isEnabled());
        System.out.println("Baslik : "+baslik.getText());

        // TextBox'a 'Merhaba Dunya' yazin.

        //önce iceriye girmeliyiz
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
       WebElement textBox= driver.findElement(By.id("tinymce"));
       textBox.clear();
       textBox.sendKeys("Hello World");


        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).isEnabled());
    }
}
