package junit_my_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class HandleIframe_1 extends TestBase {
/*
   1- https://the-internet.herokuapp.com/iframe  sitesine gidiniz
   2- sayfadaki toplam iframe sayısını bulunuz.
   3- Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
   4- Paragrafdaki yaziyi silelim
   5- Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
   6- Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim

 */

         @Test
         public void test01(){
            int iframeSayisi = driver.findElements(By.tagName("iframe")).size();
            System.out.println("iframeSayisi = " + iframeSayisi);
            String metin = driver.findElement(By.xpath("//h3")).getText();
            Assert.assertTrue(metin.contains("Editor"));
            driver.switchTo().frame(0);
            driver.findElement(By.xpath("//p[.='Your content goes here.']")).clear();
            driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("iframe in icindeyim");
            driver.switchTo().parentFrame();
            String altYazi = driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
            Assert.assertTrue(altYazi.contains("Elemental Selenium"));
        }
    }
