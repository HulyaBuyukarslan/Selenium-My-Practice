package junit_my_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;

public class HandleWindows_1 extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        //1-Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");

        //2-Sayfa’nin window handle degerini String bir degiskene atayin
        String window1 = driver.getWindowHandle();

        //3-Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //4-Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin

        WebDriver yeniWindow = driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        // driver.get("https://www.techproeducation.com");
        yeniWindow.navigate().to("https://www.techproeducation.com");

        //5-Sayfa title’nin “Techpro Education” icerdigini test edin
        String actualTitle2  = driver.getTitle();
        String expectedTitle2 = "Techpro Education";
        Assert.assertTrue(actualTitle2.contains(expectedTitle2));

        //6-Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        WebDriver yeniWindow2 = driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(1000);
       // driver.get("https://www.walmart.com");
        yeniWindow2.navigate().to("https://www.walmart.com");

        //7-Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitle3  = driver.getTitle();
        String expectedTitle3 = "Walmart";
        Assert.assertTrue(actualTitle3.contains(expectedTitle3));

        //8-Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        Thread.sleep(1000);
        driver.switchTo().window(window1);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.com"));

    }
}
