package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void name() {
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com");
        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies=driver.manage().getCookies();//toplam cerez sayisi
        int cookieSayisi=allCookies.size();//tum cookie leri aldik
        System.out.println("cookieSayisi = " + cookieSayisi);
        //3. Bir Cookie yi ismiyle bul
        System.out.println(" cookie yi ismiyle cagirma"+driver.manage().getCookieNamed("i18n-prefs"));

        //tum cookie leri yazdiralim
        allCookies.stream().forEach(t -> System.out.println(t.getName()));
        for (Cookie eachCookie:allCookies){
            System.out.println(eachCookie);//cookie nin tamamini yazdir yani ne olduklarini
            System.out.println(eachCookie.getName());
        }

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem=new Cookie("cikolatam","antep-Fistikli-Cikolata");
        driver.manage().addCookie(favoriCookiem);
        System.out.println(" yeni cookie sayisi"+driver.manage().getCookies().size());

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");
//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());
    }
}
