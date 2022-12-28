package junit_my_practice;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Handle_Dropdown_3 {
/*
1.http://zero.webappsecurity.com/ Adresine gidin
2.Sign in butonuna basin
3.Login kutusuna “username” yazin
4.Password kutusuna “password” yazin
5.Sign in tusuna basin
6.Pay Bills sayfasina gidin
7.“Purchase Foreign Currency” tusuna basin
8.“Currency” drop down menusunden Eurozone’u secin
9.“amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

                                                                                                    */
WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }

@Test
    public void test1() throws InterruptedException {
    driver.findElement(By.xpath("//*[@class='icon-signin']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB,"password", Keys.TAB, Keys.ENTER);
    Thread.sleep(2000);
    driver.navigate().back();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='online-banking']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
    Thread.sleep(2000);
    WebElement dropdown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
    Select select = new Select(dropdown);
    select.selectByVisibleText("Eurozone (euro)");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1000");
    Thread.sleep(2000);
    WebElement dolarButonu = driver.findElement(By.xpath("//*[@type='radio']"));
    Assert.assertTrue(!dolarButonu.isSelected());
    driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@value='Purchase']")).click();
    Thread.sleep(2000);
    WebElement sonucYazisi = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
    Assert.assertTrue(sonucYazisi.isDisplayed());

}
@After
    public void tearDown(){
        driver.close();
}
}
