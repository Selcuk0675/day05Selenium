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

public class C03_RadioButton {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void after(){
       //driver.close();
    }

    @Test
    public void name() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // radiobutton elementlerini locate edin
        WebElement radioButton1=driver.findElement(By.id("vfb-7-1"));
        WebElement radioButton2=driver.findElement(By.id("vfb-7-2"));
        WebElement radioButton3=driver.findElement(By.id("vfb-7-3"));
        Assert.assertTrue(radioButton3.isDisplayed());

        // option2'yi secin
        radioButton2.click();
        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(radioButton2.isSelected());
        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radioButton1.isSelected());
        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radioButton3.isSelected());
    }
}
