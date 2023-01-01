package junit_my_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class HandleWindows_3 extends TestBase{


    @Test
    public void test1() throws InterruptedException {
         // 1-https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String ilkPencere = driver.getWindowHandle();

        // 2-Title'in "Windows" oldugunu test edin
        String actualTitle =  driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(expectedTitle,actualTitle);

       // 3-Click here a tiklayin
        driver.findElement(By.xpath("//*[@href='index.php?page=new-windows']")).click();

        // 4-Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
        Set<String> butunPencereler = driver.getWindowHandles();
        for (String w : butunPencereler){
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 ="New Window";
        Assert.assertEquals(expectedTitle2,actualTitle2);



    }
}
