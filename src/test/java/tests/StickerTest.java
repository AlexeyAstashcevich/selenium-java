package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StickerTest extends TestBase {
  @Test
  public void stickerTest() {
    navigation.gotTo("http://localhost/litecart/");
    List<WebElement> ducks = driver.findElements(By.className("product"));
    for (WebElement duck : ducks) {
      Assert.assertTrue(helperBase.isElementPresent2(duck));
      List<WebElement> duckList =duck.findElements(By.className("sticker"));
      Assert.assertEquals(duckList.size(),1);
    }
  }
}
