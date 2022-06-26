package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import java.util.List;
import java.util.stream.Collectors;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class DucksPageValueTest extends TestBase {
  @Test
  public void duckPagesValue() {
    navigation.gotTo("http://localhost/litecart/");
    WebElement duckLink = driver.findElements(By.cssSelector("div#box-campaigns a.link")).iterator().next();
    String duckTitle = duckLink.findElement(By.className("name")).getText();
    String duckPrice = duckLink.findElement(By.className("regular-price")).getText();
    String color = duckLink.findElement(By.className("manufacturer")).getCssValue("color");
    Color.fromString(color).getColor();
    java.awt.Color rgb = Color.fromString(color).getColor();
    Assert.assertTrue(rgb.getBlue() == rgb.getGreen());
    Assert.assertTrue(rgb.getBlue() == rgb.getGreen());
    List<String> colorOfPrice = driver.findElements(By.cssSelector("strong.campaign-price"))
            .stream().map(x->x.getAttribute("color")).collect(Collectors.toList());
    for(String duck: colorOfPrice){
      Assert.assertTrue();
    }


//    Assert.assertEquals();


  }
}
