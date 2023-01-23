package day10_actionClass;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {
    //Class: ActionClass3
    //Method : scrollUpDown()
    //https://techproeducation.com a git
    //Sayfanin altına doğru gidelim
    //Sonra sayfanın üstüne doğru gidelim

    @Test
    public void scrollUpDown() {
        //https://techproeducation.com a git
        driver.get("https://techproeducation.com ");
        //Sayfanin altına doğru gidelim
       Actions actions=new Actions(driver);
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);

        actions.sendKeys(Keys.ARROW_DOWN).perform();//Page down dan daha az mesafe aldirri
        waitFor(3);

        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(3);
        actions.sendKeys(Keys.ARROW_UP).perform();
        //Sonra sayfanın üstüne doğru gidelim
    }
}
