package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;

public class BucketPage extends BasePage{
  public BucketPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void deleteDucksFromBucket(List<WebElement> ducksInBucket) {
    for (int i = 0; i < ducksInBucket.size(); i++) {
      navigation.click(By.name("remove_cart_item"));
      wait.until(numberOfElementsToBeLessThan(By.cssSelector("tr>td.item"), ducksInBucket.size() - i));
    }
  }
}
