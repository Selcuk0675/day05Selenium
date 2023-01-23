package practice_erol_hoca_4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;

public class C03_Upload extends TestBase {
    @Test
    public void name() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/ ");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement chooseFile= driver.findElement(By.id("uploadfile_0"));
        String path="C:\\Users\\User\\OneDrive\\Masaüstü\\logo tech.jpeg";
        File file=new File(path);
        chooseFile.sendKeys(path);
        driver.findElement(By.xpath("//*[@id='terms']")).click();


        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);//Bunu koymazsak sayfa dolmuyor hata veriyor
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
        //Assert.assertTrue( driver.findElement(By.xpath("//*[text()='has been successfully uploaded.']")).isDisplayed());
    }
}
