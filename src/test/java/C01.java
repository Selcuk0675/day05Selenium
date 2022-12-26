import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01 {
    /*
        1. What is Dropdown?
        Draopdown liste olusturmak icin kullanilir

        2. How to handle dropdown elements?Dropdown nasil automate edilir
            - locate
            - Select objesi
            - Select methods
          Not: select objesi olusturma nedenim,dropdownlarin Select classi ile olusturulmasi
        3. Tum dropdown seceneklerini nasil print ederiz
          -  Tum dropdown elementlerini getOptions() methodu ile listeye koyariz
          - sonra secenekleri loop ile yazdirabiliriz
        4. Bir ssecenegin secili oldugunu otomate etmek icin ne yapilir?
        orn: Gun olarak 10 u secdik ama ya secilmediyse?
        getFirstSelectedOptions()  secili olan secenegi return edeer
     */
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectedByIndextest(){
        //        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        WebElement year=driver.findElement(By.id("year"));
        Select dropdownYear=new Select(year);
        dropdownYear.selectByVisibleText("2000");
        //dropdownYear.selectByValue("2000");
        //dropdownYear.selectByIndex(22);

        WebElement month=driver.findElement(By.id("month"));
        Select dropdownMonth=new Select(month);
        dropdownMonth.selectByVisibleText("January");

        WebElement day=driver.findElement(By.id("day"));
        Select dropdownDay=new Select(day);
        dropdownDay.selectByIndex(11);
    }
    @Test
    public void printAllState(){
        //Tum eyaletleri print edelim
        WebElement state=driver.findElement(By.id("state"));
        Select dropdownstate=new Select(state);


        List<WebElement> printAllState=dropdownstate.getOptions();

        for (WebElement stateList: printAllState){
            System.out.println(stateList.getText());


        }

    }
    @Test
    public void getSelected(){
        //State dropdownindaki varsayilan secili secenegin 'Select a State ' oldugunu verify edelim
        WebElement SelectState=driver.findElement(By.id("state"));
        Select dropdowSelectState=new Select(SelectState);

        String verfy=dropdowSelectState.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",verfy);


    }

}
