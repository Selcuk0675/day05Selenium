package day13_seleniumExceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class C03_NullPointerException  {
    /*          --NullPointerException--
      * Degiskenleri olusturup instantiate etmedigimizde aliriz
      * Yani WebDriver driver=driver.get(); diye yaparsak hata aliriz normalde orada new olmali yani biseye atadik
              WebDriver  driver=new ChromeDriver(); boyle olmali   //somutlastirma , orneklerle destekleme = instensieyt
     */
    WebDriver driver;//driver olusturduk ama ici bombos yani new demedik
    Faker faker;

    @Test
    public void NullPointerException() {
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException

    }

    @Test
    public void name() {
       // faker=new Faker();// cozum
        System.out.println(faker.name().firstName());//java.lang.NullPointerException
        //Burda da NullPointerException aldik cunku instantiate etmedik yani new demedik

    }

}
