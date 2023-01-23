package practice_erol_hoca._2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
       // driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //    cancel Alert  (Press a Button !)
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //    finally print on console this message "Hello TechproEducation How are you today"
        //    aseertion these message

            //    go to url :http://demo.automationtesting.in/Alerts.html
            driver.get("http://demo.automationtesting.in/Alerts.html");
            //    click  "Alert with OK" and click 'click the button to display an alert box:'
            //    accept Alert(I am an alert box!) and print alert on console
            WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
            alert.click();
            System.out.println(driver.switchTo().alert().getText()); // Alert üzerindeki yazıyı konsola yazdırdık
            driver.switchTo().alert().accept(); // Alertte tamam'a bastık
            //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
            driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
            //    cancel Alert  (Press a Button !)
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();
            //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
            //    and then sendKeys 'TechProEducation' (Please enter your name)
            driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().sendKeys("TechProEducation");
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            //    finally print on console this message "Hello TechProEducation How are you today"
            System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());
            //    aseertion these message
            Assert.assertEquals("Hello TechProEducation How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());
        }
        /*
        import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Go to URL
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // Click "Alert with OK" button and click "click the button to display an alert box" button
        driver.findElement(By.xpath("//button[@class='btn btn-danger' and text()='Alert with OK']")).click();
        driver.findElement(By.id("alert")).click();

        // Accept alert and print alert text on console
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        // Click "Alert with OK & Cancel" button and click "click the button to display a confirm box" button
        driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Alert with OK & Cancel']")).click();
        driver.findElement(By.id("confirm")).click();

        // Cancel alert
        alert = driver.switchTo().alert();
        alert.dismiss();

        // Click "Alert with Textbox" button and click "click the button to demonstrate the prompt box" button
        driver.findElement(By.xpath("//button[@class='btn btn-info' and text()='Alert with Textbox']")).click();
        driver.findElement(By.id("prompt")).click();

        // Send keys to alert and print alert text on console
        alert = driver.switchTo().alert();
        alert.sendKeys("TechProEducation");
        System.out.println(alert.getText());
        alert.accept();

        // Close browser
        driver.close();
    }
}
         */
    }


