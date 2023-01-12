package junit_ornekler;

import junit_my_practice.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class YouTube extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//div[@id='search-input']//input[@id='search']")).click();
        driver.findElement(By.xpath("//div[@id='search-input']//input[@id='search']")).sendKeys("Techproeducation"+ Keys.ENTER);
    }

}
