package practice_erol_hoca_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {
    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void before(){
        driver.get(" https://www.google.com/");
    }

    @Test
    public void test01() {
        //        cookies uyarisini kabul ederek kapatin
        //        Sayfa basliginin “Google” ifadesi icerdigini test edin
        driver.getTitle();
        Assert.assertTrue( driver.getTitle().contains("Google"));
        //        Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //        Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.id("result-stats")).getText().split(" ")[1]);
        String sonuc=driver.findElement(By.id("result-stats")).getText().split(" ")[1];
        //        sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc=sonuc.replaceAll("\\D","");//ReplaceAllMethodu ile \\D kullanaraka butun noktalama isaretlerini hiclikle degistir
       // Bu sekilde1660000000 'u noktasiz yazdirdik
        int istenenSayi=10000000;
       Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);
        //        Sayfayi kapatin
        driver.close();

    }
}
