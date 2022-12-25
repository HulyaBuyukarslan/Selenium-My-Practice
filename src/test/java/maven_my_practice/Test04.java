package maven_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test04 {

/*
    1- http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
    2- Telefonlar ve PDA'lar üzerine tıklayın
    3- telefonların markasını alın
    4- tüm öğeler için ekle düğmesine tıklayın
    5- siyah toplam eklenen sepet düğmesine tıklayın
    6- listenin isimlerini sepetten al
    7- görüntüleme listesinden ve alışveriş sepeti listesindeki adları karşılaştırın
    8- sayfayı kapatın.

    Not: Methodlar oluşturarak yapınız.
    clickAllElements
    getName
    compareTwoList

   */
     static WebDriver driver = new ChromeDriver();
     static List<String> goruntulemeListesi = new ArrayList<>();
     static List<String> alisverisSepetiListesi = new ArrayList<>();


    public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    //1
    driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=common/home");

   //2
    driver.findElement(By.linkText("Phones & PDAs")).click();


   //3
//    WebElement marka1 = driver.findElement(By.linkText("HTC Touch HD"));
//    System.out.println(marka1.getText());
//    WebElement marka2 = driver.findElement(By.linkText("iPhone"));
//    System.out.println(marka2.getText());
//    WebElement marka3 = driver.findElement(By.linkText("Palm Treo Pro"));
//    System.out.println(marka3.getText());
    goruntulemeListesi = getName("//h4");

    //4
        clickAllElements();

    //5
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();

    //6
        alisverisSepetiListesi = getName("//*[@class='text-left']");

    //7
        compareTwoList();

    //8
       driver.close();
    }

    public static List<String> getName(String telefonAdlari) {
        List<String> liste = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(By.xpath(telefonAdlari));

        for (WebElement w : webElements){
         liste.add(w.getText());
        }

        Collections.sort(liste);
        System.out.println(liste);
        return liste;
    }

    public static void clickAllElements(){
        for (int i = 1; i <=goruntulemeListesi.size() ; i++) {
            driver.findElement(By.xpath("(//*[.='Add to Cart'])[" +i+ "]")).click();

        }
    }

    public static void compareTwoList(){
        if(goruntulemeListesi.equals(alisverisSepetiListesi)){
            System.out.println("İki liste eşittir");
        }else{
            System.out.println("İki liste eşit değildir");
        }
    }

}







