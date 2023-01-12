package junit_ornekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Ornek_5 {
/*
- ebay sayfasına gidiniz
- electronics bölümüne tıklayınız
- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
- Her sayfanın sayfa başlığını yazdıralım
- sayfayı kapatalım
 */

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ebay.com");
    }

@Test
public void test1() throws InterruptedException {
    driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();


    for (int i = 0; i < 24 ; i++) {
     List<WebElement> urunler =  driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        urunler.get(i).click();
        System.out.println(i+". başlık : " + driver.getTitle());
        driver.navigate().back();

   }
 }

   @After
    public void tearDown() throws Exception {
        driver.close();
    }

}


