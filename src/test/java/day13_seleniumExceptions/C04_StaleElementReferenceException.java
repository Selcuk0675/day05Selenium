package day13_seleniumExceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*          --StaleElementReferenceException--

     stale: modasi gecmiş tarihi gecmis, eski,kullan ilamazdurumda
     * Burda bir webElementi tekrar tekrar kullanirsak fakat design miz iyi degilse
     * Bir sayfayi yeniledigimizde refresh yapildiginda olur
     *Sayfada ileri geri gittigimizde

            --cozum--
      * Elementi tekrar bulacaz

     */

    @Test
    public void StaleElementReferenceException1() {
        driver.get("https://www.techproeducation.com");
        //        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et

//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        WebElement lMSLOGİNlİNK= driver.findElement(By.linkText("LMS LOGIN"));
        lMSLOGİNlİNK.click();//lms e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//url nin lms icerdigiini test et

        //tekrar ana sayfaya gel ve lms login sayfasina tekrar
        driver.navigate().back();
        waitFor(3);
        lMSLOGİNlİNK.click();//bu eeman artik eski eleman oluyo dolayisiyla hata vriyo
        //org.openqa.selenium.StaleElementReferenceException
    }


        @Test
        public void staleElementReferenceExceptionTest2(){
            driver.get("https://www.techproeducation.com");
            waitFor(5);
            WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
            waitFor(5);
            driver.navigate().refresh();
            waitFor(5);
            lmsLoginLink.click();//syfa yenilenmeden once buldugum elementi ,sayfa yenilendikten sonra kullnmak istedim
            //org.openqa.selenium.StaleElementReferenceException

            //cozum eskyen elemnti tekrar locate etmek ama sikinti locate de deil
            driver.findElement(By.linkText("LMS LOGIN")).click();
        }




    }

