package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductToBucketTest extends TestBase {
  @Test
  public void bucketTest() {
    navigation.gotTo("http://localhost/litecart/");
    int sumOfDucks = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());
    homePage.addDucksToBucket(sumOfDucks);
    homePage.goToBucket();
    List<WebElement> ducksInBucket = driver.findElements(By.cssSelector("tr>td.item"));
    bucketPage.deleteDucksFromBucket(ducksInBucket);
    List<WebElement> checkBucket = driver.findElements(By.cssSelector("tr>td.item"));
    Assert.assertEquals(checkBucket.size(), 0);
  }
}
