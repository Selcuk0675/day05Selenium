package day06_DropDown;

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

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    //Dropdown bir listedir
    //  https://the-internet.herokuapp.com/dropdown
    //ttps://testcenter.techproeducation.com/index.php?page=dropdown
    //https://testcenter.techproeducation.com/index.php?page=dropdown
    /*
        Dropdownu autome edebilmek icin selectTag ini kullaniriz

        1-) locate Webelement ddm=driver.findElement(    ----   )
        2-)Select optons=new Select(ddm);
        3_) options.SelectByİndex(1);
     */

    WebDriver driver;
    //Not: eger test sinifinda birden fazla method olusturulmussa  @Before kullanilir
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.close();
    }
    @Test
    public void selectByIndexTest(){
        //        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        //        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1_) LOCATE
        WebElement year= driver.findElement(By.xpath("//*[@id='year']"));
        //2.Select objesi
        Select yearDropdown=new Select(year);


        //3.Select objesini kullanarak 3 farkli secim yapabiliri
          //i.index kullanarak yani 'sirasi' sifirdan baslar
        yearDropdown.selectByIndex(22);//2000 yili 23. sirada index sifirdan basladigi icin 22 yaptik
        //ayi seciyoruz
        WebElement month=driver.findElement(By.id("month"));
        Select monthDropdown=new Select(month);
       // monthDropdown.selectByIndex(0);
        monthDropdown.selectByValue("0");//seceneklerde value vardir ordan secebiliriz
        //monthDropdown.selectByVisibleText(January);---> case sensetive buyuk kucuk harf onemli

      //Gun Secimi
      WebElement day=driver.findElement(By.id("day"));
      Select dayDropdown=new Select(day);
      dayDropdown.selectByVisibleText("10");//selectByVisibleText() yazi neyse ou kabul eder html ye bakmaya bile gerek yolk

    }
    @Test
    public void printAllTest(){
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");
        //Tum eyaletleri print edelim
        //1) locate
        WebElement state=driver.findElement(By.id("state"));
        Select stateDropdown=new Select(state);
        List<WebElement> stateList=stateDropdown.getOptions();//Butun elementleri return eder
        for (WebElement eachState:stateList){
            System.out.println(eachState.getText());//getText() bunu yazmazsak bize refarance verir
        }
       // stateList.stream().forEach(t-> System.out.println(t.getText()));

    }
    @Test
    public void getSelectedOptionsTest(){
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");
        //State dropdownindaki varsayilan secili secenegin 'Select a State ' oldugunu verify edelim
        WebElement state=driver.findElement(By.id("state"));
        Select stateDropdown=new Select(state);
        String varSAyilanText=stateDropdown.getFirstSelectedOption().getText();//Secili elementi return eder
        Assert.assertEquals("Select a State",varSAyilanText);


    }
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


     /*
         git init
         git add .
         git commit -m ""
         git remote add origin url girin
          git push -u origin master
     */




}
