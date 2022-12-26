package day06_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusableMethod {
    //REUSABLE METHOD:Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim
    WebDriver driver;
    //Not: eger test sinifinda birden fazla method olusturulmussa  @Before kullanilir
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");

    }
    public void selectFromDropdown(WebElement dropdown,String secenek){

      //Gonderilen dorpdown elementlerin tum optionslari alinir
        List<WebElement> options=dropdown.findElements(By.tagName("option"));//tum opton tagli elementleri aliyoruz
        for (WebElement eachOption:options){
            if (eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }

    }
    @Test
    public void selectFromDropdown(){
        selectFromDropdown();
    }
}
