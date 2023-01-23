package practice_erol_hoca_4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class C04_Download extends TestBase {
    @Test
    public void name() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement element= driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element);
        waitFor(3);

        driver.findElement(By.xpath("(//*[@aria-expanded='false'])[83]")).click();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        List<String> ws=new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(ws.get(1));
        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        waitFor(10);
        //Driver'in indiğini doğrulayalım
        String path="C:\\Users\\User\\Downloads\\chromedriver_win32.zip";
        assert Files.exists(Paths.get(path));

    }
}
