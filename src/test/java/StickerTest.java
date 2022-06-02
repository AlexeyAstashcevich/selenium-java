import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StickerTest extends TestBase {
  @Test
  public void stickerTest() {
    navigation.gotTo("http://localhost/litecart/");
    List<WebElement> ducks = driver.findElements(By.cssSelector("a.link[href*='ducks']"));
    for (WebElement duck : ducks) {
//      String ducky = duck.findElement(By.className("sticker new")).toString();
      Assert.assertTrue(helperBase.isStickerPresent(duck));
    }
  }
}
