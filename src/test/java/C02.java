import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class C02 extends TestBase {
    @Test
    public void name() throws IOException {
        driver.get("https://www.amazon.com");
        takeScreenShotOfPage();
        takeScreenshotOfElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")));

    }
    public static int carp(int a,int b){
        return a * b;


    }
}
