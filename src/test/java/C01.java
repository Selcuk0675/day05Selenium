import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void name() {

        Faker faker=new Faker();
        String email=faker.internet().password();
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");
        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate ediniz
         WebElement name=driver.findElement(By.xpath("//*[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Actions actions=new Actions(driver);
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("12").sendKeys(Keys.TAB).sendKeys("Temmuz").sendKeys(Keys.TAB).sendKeys("2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}
