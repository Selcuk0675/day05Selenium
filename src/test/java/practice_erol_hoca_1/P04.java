package practice_erol_hoca_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // Add Element butonuna 100 defa basınız
        for (int i=1;i<100;i++){
            driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        }
        // 100 defa basıldığını test ediniz
        List<WebElement> deleteButon=driver.findElements(By.xpath("//*[@class='added-manually']"));
        Assert.assertEquals(deleteButon.size(),99);
        // 90 defa delete butonuna basınız
        for (int i = 0; i <90; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }
        // 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButonList=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
    int kalanDeleteButon=deleteButon.size()-90;
    Assert.assertEquals(kalanDeleteButon,deleteButonList.size());
        // Sayfayı kapatınız
        driver.close();
    }
}
