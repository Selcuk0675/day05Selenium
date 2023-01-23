import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C05 extends C02 {
    @Test
    public void name() throws IOException {
        driver.get("https://www.amazon.com");
        takeScreenShotOfPage();
        WebElement turboDizel=driver.findElement(By.xpath("(//*[@class='nav-a  '])[1]"));
        takeScreenshotOfElement(turboDizel);
        System.out.println(carp(2, 3));


    }

}
