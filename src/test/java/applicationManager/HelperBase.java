package applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

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

  public boolean isStickerPresent(WebElement webelement) {
    WebElement stickerNew = null;
    WebElement stickerSale = null;
    try {
      stickerNew = webelement.findElement(By.className("sticker new"));
    } catch (NoSuchElementException ex) {
    }
    try {
      stickerSale = webelement.findElement(By.className("sticker sale"));
    } catch (NoSuchElementException ex) {
    }
    return ( Objects.isNull(stickerNew) && Objects.nonNull(stickerSale)) ||
            (Objects.nonNull(stickerNew) && Objects.isNull(stickerSale));
  }

}

