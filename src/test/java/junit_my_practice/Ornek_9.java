package junit_my_practice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class Ornek_9 extends TestBase{

/*
1- go to url :http://demo.automationtesting.in/Alerts.html
2- Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
3- Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
4- "Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
5- Alert'ü kapatın
6- "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın
7- Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
8- Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
9- finally print on console this mesaaje "Hello TechproEducation How are you today"

 */


        //1- go to url :http://demo.automationtesting.in/Alerts.html
        @Test
        public void test01() throws InterruptedException {
            driver.get("http://demo.automationtesting.in/Alerts.html");
            //2- Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
            driver.findElement(By.xpath("//*[@class=\"btn btn-danger\"]")).click();
            Thread.sleep(2000);
            //3- Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            //4- "Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
            driver.findElement(By.xpath("(//*[@data-toggle=\"tab\"])[2]")).click();
            driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
            Thread.sleep(2000);
            //5- Alert'ü kapatın
            driver.switchTo().alert().dismiss();
            //6- "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın
            driver.findElement(By.xpath("(//*[@data-toggle=\"tab\"])[3]")).click();
            driver.findElement(By.xpath("//*[@class=\"btn btn-info\"]")).click();
            //7- Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
            driver.switchTo().alert().sendKeys("TechProEducation");
            driver.switchTo().alert().accept();
            //8- Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
            String name = driver.findElement(By.id("demo1")).getText();
            Assert.assertTrue(name.contains("TechProEducation"));
            //9- finally print on console this mesaaje "Hello TechproEducation How are you today"
            System.out.println(name);
        }
    }
