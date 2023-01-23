package day02_practice_Burak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void after(){
        //driver.close();
    }

    @Test
    public void name() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // checkbox elementlerini locate edin
        WebElement chechbox1=driver.findElement(By.id("vfb-6-0"));
        WebElement checkbox2=driver.findElement(By.id("vfb-6-1"));
        WebElement checkbox3=driver.findElement(By.id("vfb-6-2"));
        // checkbox1 ve checkbox3  secili degil ise secin
        if (!chechbox1.isSelected()&&!checkbox3.isSelected()){
            chechbox1.click();

        }
        if (!checkbox3.isSelected()){
            checkbox3.click();
        }
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin***test dedigi icin assert kullanacaz
        Assert.assertTrue(chechbox1.isSelected());
        Assert.assertTrue(checkbox3.isSelected());
        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkbox2.isSelected());
    }
}
