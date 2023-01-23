package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExist {
        //    Class : FileExistTest
        //    Method : isExist
        //    Masa ustunden bir dosyanın varligini test et

    @Test
    public void isExist() {
        String userDir=System.getProperty("user.dir");
        System.out.println(userDir);

        String userHome=System.getProperty("user.home");
        System.out.println(userHome);

        //Masaustundeki tech_logosunun yolunu alalim
       // String dosyaYolu=userHome+"/Masaüstü/logo.jpeg";
        String dosyaYolu="C:/Users/User/OneDrive/Masaüstü/logo tech.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist=Files.exists(Paths.get(dosyaYolu));//dosya var ise true yoksa false return eder
        Assert.assertTrue(isExist);
        //C:\Users\User>"C:\Users\User\OneDrive\Masaüstü\logo tech.jpeg" sonra kontrol et
          /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */
    }
}
