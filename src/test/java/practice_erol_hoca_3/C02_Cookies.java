package practice_erol_hoca_3;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {
    //*
    //                                    Cookies(Çerezler)
    //        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    //    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    //    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    //    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
    //     */


    @Test
    public void COOKİES() {
        //Techproeducation adresine gidiniz
        //Sayfadaki cookie lerin sayısını yazdırınız
        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        //Yeni bir cookie ekleyiniz
        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        //Oluşturduğumuz cookie'i silelim
        //Tüm cookieleri silelim


        //Techproeducation adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println("Cookies number :"+cookies.size());
        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie c:cookies){
            System.out.println(c.getName()+":"+c.getValue());
        }
        //Yeni bir cookie ekleyiniz
        Cookie newCookie=new Cookie("Selcuk","123456789");
        driver.manage().addCookie(newCookie);
        System.out.println("newCookie = " + newCookie);
        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies2=driver.manage().getCookies();
        System.out.println("Cookies number :"+cookies2.size());
        cookies2.stream().forEach(t-> System.out.println(t.getName()+":"+t.getValue()));

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookieNamed("Selcuk");
        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3=driver.manage().getCookies();
        System.out.println("Cookies number :"+cookies3.size());

    }
}
