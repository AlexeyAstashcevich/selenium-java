package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class DucksPageValueTest extends TestBase {
  @Test
  public void duckPagesValue() {
    navigation.gotTo("http://localhost/litecart/");
    WebElement duckLink = driver.findElements(By.cssSelector("div#box-campaigns a.link")).iterator().next();
    String duckTitle = duckLink.findElement(By.className("name")).getText();
    String duckPrice = duckLink.findElement(By.className("regular-price")).getText();
    String color = duckLink.findElement(By.className("manufacturer")).getCssValue("color");


//    Assert.assertEquals();


  }
}
