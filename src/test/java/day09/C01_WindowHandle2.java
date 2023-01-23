package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void name() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualwindow1Text=driver.findElement(By.xpath("//h3")).getText();
        String expectedwindow1Text="Opening a new window";
        Assert.assertEquals(expectedwindow1Text,actualwindow1Text);
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualwindow1Title=driver.getTitle();
        String expectedwindow1Title="The Internet";
        Assert.assertEquals(expectedwindow1Title,actualwindow1Title);
        String w1=driver.getWindowHandle();
        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);
        //İkinci pencere acilir işlem yapmak istedigimizden
        // o pencereye switch yapmaliyiz yoksa o sayfada işlem yapamayiz
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);//ikinci windowa gittik
      //  switchToWindow("New Window");//title stringin icine yazdik
        String actujalWindow2=driver.getTitle();
        String expectedWindow2="New Window";
        Assert.assertEquals(expectedWindow2,actujalWindow2);
    }
}
