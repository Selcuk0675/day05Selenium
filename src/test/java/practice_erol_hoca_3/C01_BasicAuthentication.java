package practice_erol_hoca_3;

import org.junit.Test;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {
    /*
                                Basic Authentication(Temel Kimlik Doğrulama)
        Basic Authentication, HTTP protokolü üzerinden bir web sayfasına erişim için kullanılan bir
    güvenlik yöntemidir. Bu yöntem, kullanıcı adı ve parola gibi kimlik bilgilerini gönderen bir
    istemci tarafından kullanılır ve sunucu tarafından doğrulanır. Eğer kimlik bilgileri doğru ise,
    sunucu istemciye erişim izni verir. Eğer kimlik bilgileri yanlış ise, sunucu istemciye erişim izni vermez.
        Basic Authentication genellikle özel veya yönetim tarafından korunan web siteleri için kullanılır.
    Örnek olarak, şirket içi yönetim arayüzleri, veritabanı yönetim sistemleri, sanal makine yönetim arayüzleri
    gibi siteler kullanabilir.
    Bu tür sitelerde, kullanıcıların sadece yetkilendirilmiş kullanıcılar tarafından erişilebileceği
    garanti edilmek istenebilir. Ayrıca bazı bölgesel / ülke veya alan spesifik hizmetlerde kullanılmakta,
    örneğin bankaların online bankacılık hizmetleri, sağlık hizmetleri, kamu hizmetleri, e-devlet hizmetleri gibi.

     */

    @Test
    public void basicAuthentication() {
        //http://httpbin.org/basic-auth/foo/bar adresine gidiniz
        //Username  : foo
        //password  : bar
        //Yukardaki verileri kullanarak güvenliği geçin
        //driver.get("http://httpbin.org/basic-auth/foo/bar");
        driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");

        //nOT:       foo:bar@   http:// bundan sonra bunlari yerlestiriyoruz


    }
}
