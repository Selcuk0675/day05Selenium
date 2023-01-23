package practice_erol_hoca_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_BykKckHrf extends TestBase  {
    @Test
    public void name() {
        //google sayfasina gidelim
        driver.get("https://www.google.com");
        //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim
        WebElement searchBox=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);



    }
}
