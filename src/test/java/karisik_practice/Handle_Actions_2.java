package karisik_practice;

import junit_my_practice.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Handle_Actions_2 extends TestBase {

    @Test
    public void name() {
        //-http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        //-Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//*[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("//*[text()='Fleet']")).click();
        //-Sayfa başlığının Fleet içerdiğini test edelim
    }
}
