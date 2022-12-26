package junit_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Before_After_Test_Kullanimi_3 {
/*
    1-https://books-pwakit.appspot.com/ adresine gidin.
    2-"BOOKS" başlığının görünür olduğunu doğrulayın
    3-Arama çubuğunda "Selenium" u aratın.
    4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
                                                                                     */


    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


}
