package applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HelperBase {
  WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isElementPresent(WebDriver driver, By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }


  public boolean isElementPresent2(WebElement stickers) {
    try {
      stickers.findElement(By.className("sticker"));
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

}


