package practice_erol_hoca._2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class DropDown extends TestBase {

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Dropdown menuyu yazdıralım
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }
        //Dropdown menuden baby secelim
        //arama bölümünden milk aratalım
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);
    }
}


