package challenge;

import junit_my_practice.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowHandleDrag_And_Drop extends TestBase {
  @Test
    public void windowHandleDrang_And_DropTest() {

  // go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    //  Fill in capitals by country

      for(int i =1 ; i<8 ; i++){
          WebElement baskentler  = driver.findElement(By.id("box"+i));
          WebElement ulkeler= driver.findElement(By.id("box"+(100+i)));
          Actions actions = new Actions(driver);
          actions.dragAndDrop(baskentler, ulkeler).perform();
      }

  }
}
