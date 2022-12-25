package maven_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {
//1. "https://www.saucedemo.com" Adresine gidin
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin
public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    driver.get("https://www.saucedemo.com");
    driver.findElement(By.xpath("//*[@class='input_error form_input']")) .sendKeys("standard_user", Keys.ENTER);
    driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce",Keys.ENTER);
    driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
    driver.findElement(By.xpath("//*[@class='inventory_item_name']")).click();
    driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']")).click();
    driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
    WebElement urunIsmi = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
    if(urunIsmi.isDisplayed()){
    System.out.println("Sepete ekleme testi BASARILI");
    }else{
    System.out.println("Sepete ekleme testi BASARISIZ");
    }
    driver.close();

}

}
