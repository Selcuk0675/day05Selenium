package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {
    //Create a class: Action5
    //Create a method keyboardActions
    //Google a gidin https://www.google.com
    //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
    //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
    //Ve ENTER tusuna bas

    @Test
    public void keyboardActions() {
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");
        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas
        WebElement aramaKutusu=driver.findElement(By.name("q"));
       // aramaKutusu.sendKeys("iPhone X fiyatlari", Keys.ENTER);
        Actions actions=new Actions(driver);
        actions.
                 keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde Shist tusuna bas
                .sendKeys("iPhone X fiyatlari")//shifte basiliyken yazi yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift de artik basma
                .sendKeys("  cok pahali!"+Keys.ENTER)//normal halde yaz ve Enter tusuna bas
                .build()//birden fazla actions methodu kullanildiginda baglantiyi guclendirir
                .perform();


    }
}
