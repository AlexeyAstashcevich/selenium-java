import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductToBucketTest extends TestBase {
  @Test
  public void bucketTest() {
    navigation.gotTo("http://localhost/litecart/");
    int sumOfDucks = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());
    for (int i = 1; i < 4; i++) {
      if (admin.isElementPresent(driver, By.id("rslides1_s0"))) {
        navigation.click(By.cssSelector("div.content a.link"));
        if (helperBase.isElementPresent(driver, By.name("options[Size]"))) {
          navigation.click(By.name("options[Size]"));
          navigation.select(By.name("options[Size]"), "Small");
        }
        navigation.click(By.name("add_cart_product"));
        wait.until(textToBe(By.cssSelector("span.quantity"), String.valueOf(sumOfDucks + i)));
      } else {
        navigation.gotTo("http://localhost/litecart/");
        navigation.click(By.cssSelector("div.content a.link"));
        if (helperBase.isElementPresent(driver, By.name("options[Size]"))) {
          navigation.click(By.name("options[Size]"));
          navigation.select(By.name("options[Size]"), "Small");
        }
        navigation.click(By.name("add_cart_product"));
        wait.until(textToBe(By.cssSelector("span.quantity"), String.valueOf(sumOfDucks + i)));
      }
    }
      navigation.click(By.cssSelector("div#cart-wrapper a.link"));
      List<WebElement> ducksInBucket = driver.findElements(By.cssSelector("tr>td.item"));
      for (int i = 0; i < ducksInBucket.size(); i++) {
        navigation.click(By.name("remove_cart_item"));
        wait.until(numberOfElementsToBeLessThan(By.cssSelector("tr>td.item"), ducksInBucket.size() - i));
      }
      List<WebElement> checkBucket = driver.findElements(By.cssSelector("tr>td.item"));
      Assert.assertEquals(checkBucket.size(), 0);

  }
}
