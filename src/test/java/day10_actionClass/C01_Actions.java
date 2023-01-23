package day10_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    //Mouse-Based actions
    //Method:right Click
    //https://the-internet.herokuapp.com/context_menu  sitesine gidin
    //Kutuya sag tıklayın
    //Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edin
    //Tamam diyerek alerti kapatın

    @Test
    public void rightClick() {
        //1:Actions objesi olustur
        Actions actions=new Actions(driver);
        //2:Eleemnt ı locaTE edelim
        WebElement kutu=driver.findElement(By.id("hot-spot"));
        //Kutuya Sag tiklayalim
        actions.contextClick(kutu).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        //Tamam diyerek alerti kapatın
        driver.switchTo().alert().accept();


    }
}
