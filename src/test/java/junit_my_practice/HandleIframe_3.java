package junit_my_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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
        public void test01(){
          //1- go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
          //2- maximize the web site
            driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
          //3- ikinci emojiye tıklayın
            driver.switchTo().frame(1);
            driver.findElement(By.xpath("//*[@href='#nature']")).click();
          //4- ikinci emoji altındaki tüm öğelere tıklayın
            List<WebElement> emoji = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
            for (WebElement w : emoji) {
                w.click();
            }
            //5- ana iframe'e geri dön
            driver.switchTo().defaultContent();
            //6- formu doldurun,(Formu istediğiniz metinlerle doldurun)
            //7- uygula butonuna tıklayın
            driver.findElement(By.xpath("(//*[@class='mdl-textfield__input'])[1]"))
                    .sendKeys("aaa", Keys.TAB,"bbb",Keys.TAB,"aaa", Keys.TAB,"bbb",Keys.TAB,"aaa", Keys.TAB,"bbb",Keys.TAB,"aaa", Keys.TAB,"bbb",Keys.TAB,"aaa",Keys.TAB,"bbb",Keys.TAB,"aaa",Keys.TAB,Keys.ENTER);
        }
    }
