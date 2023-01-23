package day12_files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FilesUpload extends TestBase {

    @Test
    public void fileUpload() {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        //Upload butonuna basalim.
        //“File Uploaded!” textinin goruntulendigini test edelim.
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        //chooseFileButton.click();  YAPMİYACAZ
        String path="C:/Users/User/OneDrive/Masaüstü/logo tech.jpeg";
        //String path=System.getProperty("user.home")+"/OneDrive/Masaüstü/logo tech.jpeg";
        /*
            chooseFileButton una secmek istedigimiz dosyanin yolunu gondererek tikladim
         */
        chooseFileButton.sendKeys(path);
        waitFor(5);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals("File Uploaded!",driver.findElement(By.xpath("//h3")).getText());



    }
}
