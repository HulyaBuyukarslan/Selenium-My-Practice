package junit_my_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandleIframe_3 extends TestBase {
/*
1- go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
2- maximize the web site
3- ikinci emojiye tıklayın
4- ikinci emoji altındaki tüm öğelere tıklayın
5- ana iframe'e geri dön
6- formu doldurun,(Formu istediğiniz metinlerle doldurun)
7- uygula butonuna tıklayın
 */
            @Test
            public void test01() {
                // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
                driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
                // ikinci emojiye tıklayın
                WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
                driver.switchTo().frame(iframe);
                driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
                // tüm ikinci emoji öğelerini tıklayın
                List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//img"));
                emojiler.stream().forEach(t->t.click()); // Lambda ile tüm webelementlere tıkladık
                //for (WebElement w:emojiler) {
                //    w.click();
                //}
                // parent iframe e geri donun
                driver.switchTo().defaultContent();
                //driver.navigate().refresh();
                // formu doldurun,(Formu istediğiniz metinlerle doldurun)
                //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Erol", Keys.TAB,"Evren");
                List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
                List<String> veriler = new ArrayList<>(Arrays.asList(
                        "Ali","Can","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).sendKeys(veriler.get(i));
                }
                //  apply button a basin
                driver.findElement(By.xpath("//*[text()='Apply']")).click();
            }
        }
