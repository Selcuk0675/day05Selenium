package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileDowland extends TestBase {
    //Class : FileDownloadTest
    // Method : downloadTestExist
    //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
    //b10 all test cases dosyasını indirelim
    //Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void downloadTestExist() {
        //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(3);
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = "C:/Users/User/Downloads/b10 all test cases, code.docx";
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);


    }
}
