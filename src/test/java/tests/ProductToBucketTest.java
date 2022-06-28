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
    int sumOfDucks = bucketPage.getSumOfDucksInBucketBeforeTest();
    homePage.addDucksToBucket(sumOfDucks);
    homePage.goToBucket();
    List<WebElement> ducksInBucket =bucketPage.getSumInBacketForRemove();
    bucketPage.deleteDucksFromBucket(ducksInBucket);
    List<WebElement> checkBucket = bucketPage.getSumInBucketforCheck();
    Assert.assertEquals(checkBucket.size(), 0);
  }


}
