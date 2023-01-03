package junit_my_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class HandleWindows_5 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        ////https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        driver.manage().deleteAllCookies();
        ////Alerts, Frame & Windows Butonuna click yap
        Thread.sleep(5000);
        WebElement buton = driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]"));
        buton.click();
        Thread.sleep(5000);
        ////""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement yazi = driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']"));
        Assert.assertTrue(yazi.isDisplayed());
        Thread.sleep(5000);
        ////Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("(//*[.='Browser Windows'])[2]")).click();
        Thread.sleep(5000);
        ////New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());
        Thread.sleep(5000);
        ////New Tab butonuna click yap
        WebElement newTab1 = driver.findElement(By.xpath("//*[@id='tabButton']"));
        newTab1.click();
        Thread.sleep(5000);
        ////Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String ilkPencere = driver.getWindowHandle();
        Set<String> tumPencereler = driver.getWindowHandles();
        for (String w : tumPencereler) {
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }
        Thread.sleep(5000);
        WebElement yeniTabYazi = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(yeniTabYazi.isDisplayed());
        Thread.sleep(5000);
        ////İlk Tab'a geri dön
        driver.switchTo().window(ilkPencere);
        Thread.sleep(5000);
        //////New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButon = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTabButon.isDisplayed());
        Thread.sleep(5000);
    }
}