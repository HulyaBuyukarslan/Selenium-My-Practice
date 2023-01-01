package junit_my_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandleIframe_2 extends TestBase{
/*

1)http://demo.guru99.com/test/guru99home/sitesine gidiniz
2)sayfadaki iframe sayısını bulunuz.
3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
4)ilk iframe'den çıkıp ana sayfaya dönünüz
5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız

 */
        @Test
        public void test01() throws InterruptedException {
            //1)http://demo.guru99.com/test/guru99home/sitesine gidiniz
            driver.get("http://demo.guru99.com/test/guru99home/");
            //2)sayfadaki iframe sayısını bulunuz.
            int iframeSayisi = driver.findElements(By.xpath("//iframe")).size();
            System.out.println("iframeSayisi = " + iframeSayisi);
            //3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
            WebElement requiredFrame = driver.findElement(By.xpath("//iframe[contains(@src,'https://www.youtube.com/embed/RbSlW8jZFe8')]"));
            driver.switchTo().frame(requiredFrame);
            WebElement element = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
            element.click();
            Thread.sleep(10000);
            //4)ilk iframe'den çıkıp ana sayfaya dönünüz
            driver.switchTo().defaultContent();
            //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız
            driver.switchTo().frame(2);
          //  driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();


        }
    }
