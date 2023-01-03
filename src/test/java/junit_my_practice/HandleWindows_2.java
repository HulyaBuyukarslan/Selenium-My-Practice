package junit_my_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Set;

public class HandleWindows_2 extends TestBase{

  @Test
    public void test1() {
        // 1- url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        // 2- ilk pencereyi al
        String ilkPencere = driver.getWindowHandle();
        // 3- "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        // 4- setteki tüm pencereyi al
        // 5- diğer pencereye geç
//          Set<String> tumPencereler =   driver.getWindowHandles();
//          for(String w : tumPencereler){
//            if (!w.equals(ilkPencere)){
//                driver.switchTo().window(w);
//                break;
//            }
//        }

      handleWindows();
       // 6- e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com");
        // 7- Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //  8- "This access is valid only for 20 days." ifadesinin beklendiği gibi olduğunu doğrula
        String sayfaMetni = driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();
        String istenenMetin = "This access is valid only for 20 days.";
        Assert.assertEquals(istenenMetin,sayfaMetni);
       // 9- Tekrar ilk pencereye geç
        driver.switchTo().window(ilkPencere);
        //10- İlk pencerede olduğunu doğrula
        Assert.assertTrue(driver.getCurrentUrl().contains("popup.php"));


    }
}
