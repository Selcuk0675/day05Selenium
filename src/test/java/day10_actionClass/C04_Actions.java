package day10_actionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    //Class: Action4
    //Method: dragAndDropTest
    //Given user is on https://jqueryui.com/droppable/
    //And user moves the target element(Drag me to my target) in to  destination(Drop here)
    @Test
    public void dragAndDropTest(){
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
//        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();
        waitFor(5);
    }
    @Test
    public void clickAndHoldTest(){
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
//        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)//kaynagi tut
                .moveToElement(hedef)//hedefe koy
                .release()
                .build()//perform dan once ozellikle birden cok fonksiyonlarda kullanilmasi gerekir
                        // yoksa bazen hataverebilir
                .perform();//islemi gerceklestir

    }

    @Test
    public void moveByOffSetTest() {
        //        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
       //        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(430,30).release().build().perform();


    }
}