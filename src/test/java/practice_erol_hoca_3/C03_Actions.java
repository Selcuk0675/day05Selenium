package practice_erol_hoca_3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */
    /*
    http://uitestpractice.com/Students/Actions adresine gidelim
    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
    Accept ile alert'ü kapatalım
    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin*/

    @Test
    public void actions() {
        //http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");
        //    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement blueBox=driver.findElement(By.xpath("//*[@id='div2']"));
        Actions actions=new Actions(driver);
        waitFor(3);
        actions.moveToElement(blueBox).perform();
        //    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement dc=driver.findElement(By.xpath("//*[@name='dblClick']"));
        actions.doubleClick(dc).perform();
        driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!", driver.switchTo().alert().getText());
        //    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
        //    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin*/
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).release().build().perform();
   // Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
       Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }
}
