package junit_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Method_Kullanimi {
    /*
        ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        ~ click on Phones & PDAs
        ~ get the brandName of phones
        ~ click on add to button for all elements
        ~ click on black total added cart button
        ~ get the names of list from the cart
        ~ compare the names from displaying list and cart list
         */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test01() throws InterruptedException {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.linkText("Phones & PDAs")).click();
        getName();
        clickAllElements();
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();
        getNameOfCart();
        compareTwoList();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    public List<String> getName() {
        //~ get the brandName of phones
        List<WebElement> brandName = driver.findElements(By.xpath("//h4"));
        List<String> brandList = new ArrayList<>();
        for (int i = 0; i < brandName.size(); i++) {
            brandList.add(brandName.get(i).getText());
        }
        return brandList;
    }

    public void clickAllElements() throws InterruptedException {
        //~ click on add to button for all elements
        List<WebElement> addToCart = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        for (int i = 0; i < addToCart.size(); i++) {
            addToCart.get(i).click();
            Thread.sleep(2000);
        }
//
    }

    public List<String> getNameOfCart() {
        // ~ get the names of list from the cart
        List<WebElement> listOfCart = driver.findElements(By.xpath("//*[@class='text-left']"));
        List<String> CartList = new ArrayList<>();
        for (int i = 0; i < listOfCart.size(); i++) {
            CartList.add(listOfCart.get(i).getText());
        }
        return CartList;
    }

    public void compareTwoList() {

        if (getName().containsAll(getNameOfCart())) {
            System.out.println(getName());
            System.out.println(getNameOfCart());
            System.out.println("Listeler aynidir");
        }else{
            System.out.println("Listeler ayni degildir");

        }
    }
}