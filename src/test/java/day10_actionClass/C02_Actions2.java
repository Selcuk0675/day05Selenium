package day10_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {
    //Class: Actions2
    //Method : hoverOver() and test the following scenario:
    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan “Account & Lists” menüsüne git
    //“Account” secenegine tikka
    //Acilan sayfanin Title in “Your Account” icerdigini dogrula


    @Test
    public void hoverOverTest() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        //1 : Actions
        Actions actions=new Actions(driver);
      WebElement hedef= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
      waitFor(1);
        actions.moveToElement(hedef).perform();
        waitFor(2);
        //“Account” secenegine tikka
        driver.findElement(By.linkText("Account")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}