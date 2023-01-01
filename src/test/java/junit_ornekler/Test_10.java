package junit_ornekler;
import junit_my_practice.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class Test_10 extends TestBase {

         @Test
        public void test01() throws IOException, InterruptedException {
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            //3. Verify that home page is visible successfully
            WebElement anasayfa = driver.findElement(By.xpath("//html"));
            Assert.assertTrue(anasayfa.isDisplayed());
            //4. Click on 'Contact Us' button
            driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
            //5. Verify 'GET IN TOUCH' is visible
            WebElement gorunum = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
            Assert.assertTrue(gorunum.isDisplayed());
            //6. Enter name, email, subject and message
            //7. Upload file
            //8. Click 'Submit' button
            driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Hulya",
                         Keys.TAB,"abc@hotmail.com"
                        ,Keys.TAB,"ogrenci",Keys.TAB,"merhaba",Keys.TAB);
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//*[@class='form-control'])[5]")).sendKeys("C:\\Users\\Hp\\Desktop\\SELENIUM");
            driver.findElement(By.xpath("(//*[@type='submit'])[1]")).sendKeys(Keys.ENTER);
            //9. Click OK button
            driver.switchTo().alert().accept();
            //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
            WebElement gorunum2 = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
            Assert.assertTrue(gorunum2.isDisplayed());
            //11. Click 'Home'  button and verify that landed to home page successfully
            //bu asamada reklam cıktıgı ıcın devam edemedik.yapan arkadaslar paylasabılır..
            Thread.sleep(3000);
            driver.switchTo().frame(1);
            driver.findElement(By.xpath("(//*[@id='cbb'])[1]")).click();
            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
            Thread.sleep(3000);
            driver.navigate().back();
            driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
            WebElement anasayfaTekrar = driver.findElement(By.xpath("//html"));
            Assert.assertTrue(anasayfaTekrar.isDisplayed());





        }
    }
