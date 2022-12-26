package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkDers {
    public static void main(String[] args) {
        //1-https://www.amazon.com/ sayfasina gidelim
        //2-arama kutusunu locate edelim
        //3-"Samsung headphones" ile arama yapalim
        //4-Bulunan sonuc sayisini yazdiralim
        //5-Ilk urunu tiklayalim
        //6-Sayfadaki tum basliklari yazdiralim
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2-arama kutusunu locate edelim
       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //3"Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones");//Keys.ENTER
        aramaKutusu.submit();//enter a bastik
        //4-Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramaSonucu.getText());//1-16 of 243 results for "Samsung headphones"


        //5-Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@class='s-image']")).click();

        //6-Sayfadaki tum basliklari yazdiralimLİ     baslik dedigi icin h1 leri secip for icine koyuyorz
        List<WebElement> sayfaBasliklariListesi=driver.findElements(By.xpath("//h1"));
        for (WebElement w: sayfaBasliklariListesi){
            System.out.println(w.getText());
        }
       // sayfaBasliklariListesi.forEach(t->System.out.println(t.getText()));
        driver.close();
    }
}
