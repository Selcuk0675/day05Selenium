import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C02 {
    WebDriver  driver;

    @Before
    public void before(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @After
    public void after(){

        //driver.close();

    }
    @Test
    public void Test01(){
        //        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        //        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
       WebElement year=driver.findElement(By.id("year"));
        Select ydd=new Select(year);
        ydd.selectByVisibleText("2010");

        WebElement month=driver.findElement(By.id("month"));
        Select mdd=new Select(month);
        mdd.selectByVisibleText("April");

        WebElement day=driver.findElement(By.id("day"));
        Select ddd=new Select(day);
        ddd.selectByVisibleText("15");

    }
    @Test
    public void Tes02(){
        //Tum eyaletleri print edelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement state=driver.findElement(By.id("state"));
        Select dstt=new Select(state);
        List<WebElement> dsttAll=dstt.getOptions();
      for (WebElement state1: dsttAll){
          System.out.println(state1.getText());
      }

    }
    @Test
    public void test3(){
        //State dropdownindaki varsayilan secili secenegin 'Select a State ' oldugunu verify edelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement stt=driver.findElement(By.xpath("//*[@id='state']"));
        Select sttd=new Select(stt);
       String ilkDeger=sttd.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",ilkDeger);
    }

}
 /*
         git init
         git add .
         git commit -m ""
         git remote add origin url girin
          git push -u origin master
     */
