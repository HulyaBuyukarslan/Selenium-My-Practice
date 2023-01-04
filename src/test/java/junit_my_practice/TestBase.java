package junit_my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public abstract class TestBase {
        //    driver objesini olustur. Driver ya public yada protected olmali.
        //    Sebebi child classlarda gorulebilir olmasi
        protected static WebDriver driver;
        //    setUp
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        //   tearDown
        @After
        public void tearDown(){
         //   driver.quit();
        }

  public static void handleWindows (){
       String ilkPencere = driver.getWindowHandle();
       Set<String> butunPencereler = driver.getWindowHandles();
       for (String w : butunPencereler){
           if (!w.equals(ilkPencere)){
               driver.switchTo().window(w);
               break;

           }
       }

    }


    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    }

