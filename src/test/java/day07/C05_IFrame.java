package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
//        Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
//        //tag[.='metin']; Bana bu tagli metni ver
        //tag[text()='metin'];
        String expectedText="black border";
        Assert.assertTrue(anaMetin.contains(expectedText));
//        Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. ilk iframe e switch yapiyoruz

        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1="Applications lists";
        Assert.assertEquals(expectedText1,icMetin);
//        Alternatif olarak altdaki secenekler de kullanilabilir
//        Assert.assertTrue(expectedText1.contains(icMetin));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());
//        Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//*[text()='Povered By'])[1]")).getText();
        Assert.assertTrue( driver.findElement(By.xpath("(//*[text()='Povered By'])[1]")).getText().contains("Povered By"));

        /* intervieww Questions
            1-Bir sayfadaki iframe sayisini nasil buluruz
            **İframe ler iframe tagi kullanilarak olusturulur.Asagidaki gibi buluruz
            ***driver.findElement(By.xpath("//iframe")
            2-Tekrar ana sayfaya nasil doneriz?
            ***2 farkli yol vardir;
             **defaultContent ya da parentFrame metotlarini kullanarak cikariz
            ... Bu ikisi arasindaki farklar:
               i)Oncelikle her ikiside frame in disina cıkmammizi saglar
               ii)defaultContent direk ana sayfaya atlatir parentFrame bir ust seviyeye  cikartir
            3)-Bir test case in fail etme sepepleri neler olabilir?
              i)Yanlis locator.Cozum elementi tekrar locate etmek.Degişken element var ise ona gore dynamic xpath yazariz
             ii)Wait/synchronization/ bekleme hatalari. Cozum: implicitlyWait de yeterli sure oldugundan emin oluruz.
                O sureyi artirabiliirz.
                2)Explicit wait kullanilabilir(sonra gorecez)
                3)Iframe Cozum switch to iframe
                4)Alert Cozum switch to alert
                5)New window :  Cozum switch window
         */
        /*
        How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
***driver.findElements(By.tagName(“iframe”));
***driver.findElements(By.xpath(“//iframe”));
————————————
Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
***2 farkli yol vardır.
***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
———————————-
What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
*** Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
—————————————
What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
Iframe. Cozum : switch to iframe
Alert. Cozum : switch to alert
New window(Yeni pencere) : switch to window

         */
    }
}
