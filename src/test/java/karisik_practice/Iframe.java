package karisik_practice;

import junit_my_practice.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iframe extends TestBase {

    @Test
    public void test1() {

// https://the-internet.herokuapp.com/iframe sayfasina gidiniz
       driver.get("https://the-internet.herokuapp.com/iframe ");


// 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslik = driver.findElement(By.xpath("//h3"));
        String baslikYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(baslik.isEnabled());
        System.out.println(baslikYazisi);

        // TextBox'a 'Merhaba Dunya' yazin.
        driver.switchTo().frame("mce_0_ifr");

    WebElement textBox =  driver.findElement(By.xpath("//*[@class='mce-content-body ']"));
    textBox.clear();
    textBox.sendKeys("Merhaba Dunya");
    driver.switchTo().parentFrame();

// TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
     WebElement link= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
     Assert.assertTrue(link.isDisplayed());
        System.out.println("link.getText() = " + link.getText());



    }
}