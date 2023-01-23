package day01_practice_Burak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {
            // ...Exercise 2...


        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Baby" secenegini secin
        // sectiginiz option'i yazdirin
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test02() {

        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Baby" secenegini secin
        // sectiginiz option'i yazdirin
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        driver.get(" https://www.amazon.com/");
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");
       String sctgmOptn= select.getFirstSelectedOption().getText();
        System.out.println("sctgmOptn = " + sctgmOptn);
        List<WebElement> tumOption=select.getOptions();
        int actualOptionSysi=tumOption.size();
        int expectedOptionSysi=28;
      //  Assert.assertEquals(expectedOptionSysi,actualOptionSysi);
        Assert.assertEquals(28,tumOption.size());



    }
}
