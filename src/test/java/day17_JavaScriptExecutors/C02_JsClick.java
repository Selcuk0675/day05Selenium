package day17_JavaScriptExecutors;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsClick extends TestBase {
    @Test
    public void clickByJSTest() {
        //clickByJSTest
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        //LMS LOGIN elementine tikla
        //(//*[@class='elementor-item'])[4]
      // WebElement element= driver.findElement(By.xpath("(//*[@class='elementor-item'])[4]"));
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));

       // clickByJS(element);

        waitFor(3);
        //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
       // Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
        Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
    }
}
