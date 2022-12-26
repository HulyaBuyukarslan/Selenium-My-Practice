package junit_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

//1.  Launch browser
//2.  Navigate to url 'http://automationexercise.com'
//3.  Verify that home page is visible successfully
//4.  Click on 'Signup / Login' button
//5.  Verify 'New User Signup!' is visible
//6.  Enter name and email address
//7.  Click 'Signup' button
//8.  Verify that 'ENTER ACCOUNT INFORMATION' is visible
//9.  Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


public class Before_After_Test_Kullanimi_1 {
        static WebDriver driver;
        @BeforeClass
        public static void beforeClass() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("http://automationexercise.com");
        }
        @Test
        public void test01() {
            WebElement soru = driver.findElement(By.xpath("//*[@lang='en']"));
            Assert.assertTrue(soru.isDisplayed());
        }
        @Test
        public void test02() {
            driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        }
        @Test
        public void test03() {
            WebElement sign = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
            Assert.assertTrue(sign.isDisplayed());
        }
        @Test
        public void test04() {
            driver.findElement(By.xpath("//*[@name='name']")).sendKeys("derrmaan", Keys.TAB, "derrman@hootm.com", Keys.ENTER);
        }
        @Test
        public void test05(){
            WebElement account= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
            Assert.assertTrue(account.isDisplayed());
        }
        @Test
        public void test06(){
            driver.findElement(By.xpath("//*[@id='id_gender1']"));
            driver.findElement(By.xpath("//*[@id='name']"))
                    .sendKeys("",Keys.TAB,
                            "1234",Keys.TAB,
                            "12",Keys.TAB,
                            "August",Keys.TAB,
                            "1999",Keys.TAB);
            driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
            driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
            driver.findElement(By.xpath("//*[@id='first_name']"))
                    .sendKeys("ali",Keys.TAB,
                            "can",Keys.TAB,
                            "can inc",Keys.TAB,
                            "mersin",Keys.TAB,
                            "mersin",Keys.TAB,
                            "Isr",Keys.TAB,
                            "aaaa", Keys.TAB,
                            "bbbb",Keys.TAB,
                            "cccc",Keys.TAB,
                            "dddd",Keys.TAB,Keys.ENTER);

        }
    }
