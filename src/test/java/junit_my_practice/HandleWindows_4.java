package junit_my_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class HandleWindows_4 extends TestBase{

    @Test
    public void test1() {
         // 1-https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String pencere1 = driver.getWindowHandle();
        // 2-Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String sayfaMetni = driver.findElement(By.xpath("//h3")).getText();
        String istenenMetin = "Opening a new window";
        Assert.assertEquals(istenenMetin,sayfaMetni);

        // 3-Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBasligi =  driver.getTitle();
        String istenenBaslik = "The Internet";
        Assert.assertEquals(istenenBaslik,sayfaBasligi);

       // 4-Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@href='/windows/new']")).click();


        // 5-Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> butunPencereler = driver.getWindowHandles();
        for (String w : butunPencereler){
            if (!w.equals(pencere1)){
                driver.switchTo().window(w);
                break;
            }
        }
        String sayfaBasligi2 =  driver.getTitle();
        String istenenBaslik2 = "New Window";
        Assert.assertEquals(istenenBaslik2,sayfaBasligi2);

       // 6-Sayfadaki textin “New Window” olduğunu doğrulayın.
        String sayfaMetni2 = driver.findElement(By.xpath("//h3")).getText();
        String istenenMetin2 = "New Window";
        Assert.assertEquals(istenenMetin2,sayfaMetni2);

       // 7-Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(pencere1);
        String sayfaBasligiTekrar =  driver.getTitle();
        String istenenBaslikTekrar = "The Internet";
        Assert.assertEquals(istenenBaslikTekrar,sayfaBasligiTekrar);



    }
}
