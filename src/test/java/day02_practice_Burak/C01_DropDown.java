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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
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
    public void name() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement ddm=driver.findElement(By.xpath("  //*[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());//***Yazdirmak icin bunu yapıyoruz
        Thread.sleep(3000);
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
       select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // Tüm option'ları yazdırın
        List<WebElement> tumOption= select.getOptions();//Bunlari yazdirmak icin Stringe cevirmemiz lazim
        int sayac=1;
        for (WebElement each:tumOption) {
            System.out.println(sayac+".option"+each.getText());
            sayac++;
        }
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected=3;
        int actual=tumOption.size();


        Assert.assertEquals(expected,actual);
        driver.close();
    }
}
//** INTERVIEW QUESTION ** implicitlyWait() nereden gelir? -> Selenium
//                         Thread.sleep() nereden gelir -> Java
