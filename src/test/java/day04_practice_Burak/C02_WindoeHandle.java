package day04_practice_Burak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindoeHandle extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void windowHandle() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String w1=driver.getWindowHandle();
        // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        // 4- title'in 'Best Buy' icerdigini test edelim
        String w2=driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(w1);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        //driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
       Assert.assertTrue( driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(w2);
        // 8- logonun gorundugunu test edelim
        driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue( driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }
}
