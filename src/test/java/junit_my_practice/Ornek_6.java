package junit_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class Ornek_6 {
    /*
    1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
    3-Option3 ü seçin.
    4-Option3 ün seçili olduğunu doğrulayın.
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
    public void test01() {
        // 1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // 2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement menu = driver.findElement(By.xpath("//*[text()='Dropdown Example']"));
        Assert.assertTrue(menu.isDisplayed());
        // 3-Option3 ü seçin.
        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
        Select select = new Select(option);
        select.selectByVisibleText("Option3");
        // 4-Option3 ün seçili olduğunu doğrulayın.
        Assert.assertTrue(option.isDisplayed());
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}