package junit_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Handle_Dropdown_1 {
/*
    https://the-internet.herokuapp.com/dropdown adresinegidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value)yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True, degilse False yazdırın.

                                                                                            */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @Test
    public void test2(){
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        List<WebElement> secenekler = select.getOptions();

//      for(WebElement w :secenekler){
//      System.out.println(w.getText());

        secenekler.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println(secenekler.size());
        if(secenekler.size()==4){
            System.out.println("True");
        }else System.out.println("False");

//  Assert.assertFalse(secenekler.size()==4);

    }

    @After
    public void tearDown(){
        driver.close();
    }
}