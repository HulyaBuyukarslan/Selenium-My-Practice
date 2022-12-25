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

public class Test05 {
    //1-Test01 isimli bir class olusturun
    //2-https://www.amazon.com/ adresine gidin
    //3-Browseri tam sayfa yapin
    //4-Sayfayi “refresh” yapin
    //5-”Salesforce Apex Questions Bank” icin arama yapiniz
    //6-Kac sonuc bulundugunu yaziniz
    //7-Sayfayi kapatin

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Salesforce Apex Questions Bank", Keys.ENTER);

        WebElement aramaSonucu = driver.findElement(By.xpath("//*[text()='4 results for']"));
        List<String > aramaSonucuList = new ArrayList<>(Arrays.asList(aramaSonucu.getText().split(" ")));
        System.out.println(aramaSonucuList.get(0));
        driver.close();

    }

}
