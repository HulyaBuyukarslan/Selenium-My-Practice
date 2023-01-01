package junit_ornekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Ornek_7 {
/*

1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
                                                             */

        WebDriver driver;
        @Before
        public void setUp() throws Exception {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @Test
        public void test1() {
            //  1. Launch browser
            //  2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            //  3. Verify that home page is visible successfully
            WebElement anasayfa=driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
            Assert.assertTrue(anasayfa.isDisplayed());
            // 4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();
            // 5. Verify 'New User Signup!' is visible
            WebElement user =  driver.findElement(By.xpath("//*[text()='New User Signup!']"));
            Assert.assertTrue(user.isDisplayed());
            // 6. Enter name and already registered email address
            driver.findElement(By.xpath("//*[@name='name']")).sendKeys("ali",Keys.TAB,"asd@gmail.com",Keys.TAB,Keys.ENTER);
            // 7. Click 'Signup' button
            //  8. Verify error 'Email Address already exist!' is visible
            WebElement email = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
            Assert.assertTrue(email.isDisplayed());
            driver.close();
        }
        @After
        public void tearDown() throws Exception {
            driver.close();
        }







}


