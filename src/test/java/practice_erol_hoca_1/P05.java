package practice_erol_hoca_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {

        //BeforeClass ile driver ı olusturun ve
        //Maximize edin, 15 sn bekletin
        //http://www.google.com adresine gidin
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        //AfterClass ile kapatın
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void before(){
        driver.get("https://www.google.com");
    }
    @Test
    public void test(){
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);

    }
    @After
    public void tearDown() {
        String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Sonuc Sayısı = "+sonuc[1]);
        /*
sonuc yazısını culme olarak alıp önce " " lardan split yaptık
boylece kelımelerden olusan bır array elde etmiş olduk (edited)
daha sonra bu kelımeler arrayının 1. indexini aldık
         */
    }

    @Test
    public void test02(){
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);
    }
    @AfterClass
    public static void afterClass(){
        driver.close();
    }


}
