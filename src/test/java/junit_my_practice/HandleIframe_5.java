package junit_my_practice;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HandleIframe_5 extends TestBase {
      @Test
        public void test01() {


                  // https://the-internet.herokuapp.com/iframe adresine gidiniz
                  driver.get("https://the-internet.herokuapp.com/iframe");
                  // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
                  WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
                  driver.switchTo().frame(iframe);
                  WebElement textBox = driver.findElement(By.xpath("//p"));
                  textBox.clear();
                  textBox.sendKeys("Techproeducation");
                  // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
                  driver.switchTo().defaultContent();
                  WebElement elementalSeleniumLinki = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
                  Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
                  // Elemental Selenium linkine tıklayın
                  elementalSeleniumLinki.click();
                  List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
                  System.out.println("Açılan pencerelerin handle değerleri : "+windowHandles);
                  driver.switchTo().window(windowHandles.get(1));
        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */
                  // Açılan sayfada sayfa başlığını yazdırınız
                  System.out.println("Elemantal Selenium Sayfa Başlığı : "+driver.getTitle());
                  // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
                  WebElement sourceLabsLinki = driver.findElement(By.xpath("//*[text()='Sauce Labs']"));
                  Assert.assertTrue(sourceLabsLinki.isDisplayed());
                  // Source labs linkine tıklayın
                  // Açılan sayfada sayfa başlığını yazdırınız
                  // ilk sekmeye geri dönelim ve url'ini yazdıralım
                  // ilk sekmeyi kapatalım
              }
          }
