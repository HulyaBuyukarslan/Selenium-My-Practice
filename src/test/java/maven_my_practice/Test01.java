package maven_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
//Test01 isimli bir class olusturun
//1 https://www.google.com/ adresine gidin
//2 Sayfa basliginin "Google" ifadesi icerdigini test edin
//3 Arama cubuguna "Nutella" yazip aratin
//4 Bulunan sonuc sayisini yazdirin
//5 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
//6 Sayfayi kapatin

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //1
            driver.get("https://www.google.com/");


            //2
            Thread.sleep(1000);
            String baslik = driver.getTitle();
            if (baslik.contains("Google")) {
                System.out.println("Baslik testi PASSED");
            } else {
                System.out.println("Baslik Testi FAILED");
            }

            //3
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);


            //4
            Thread.sleep(1000);
            WebElement sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
            System.out.println(sonucSayisi.getText());
            List<String> liste = new ArrayList<>(Arrays.asList(sonucSayisi.getText().split(" ")));
            System.out.println(liste.get(1));


            //5
            Thread.sleep(1000);
            String sonSonuc =liste.get(1).replaceAll("[\\p{Punct}]","");

            int yeniSonuc =Integer.parseInt(sonSonuc);

            if(yeniSonuc>10000000){
                System.out.println("Sonuc sayisi testi PASSED");
            }else {
                System.out.println("Sonuc sayisi testi FAILED");
            }

            //6
            driver.close();

        }
    }
