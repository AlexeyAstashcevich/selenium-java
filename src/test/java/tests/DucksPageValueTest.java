package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DucksPageValueTest extends TestBase {
  @Test
  public void duckPagesValue() {
    navigation.gotTo("http://localhost/litecart/");
    WebElement duckLink = driver.findElements(By.cssSelector("div#box-campaigns a.link")).iterator().next();
    String duckTitle = duckLink.findElement(By.cssSelector(" div.name")).getText();
    String duckPrice = duckLink.findElement(By.className("regular-price")).getText();
    String color = duckLink.findElement(By.className("manufacturer")).getCssValue("color");
    java.awt.Color rgb = Color.fromString(color).getColor();
    Assert.assertTrue(rgb.getBlue() == rgb.getGreen());
    Assert.assertTrue(rgb.getBlue() == rgb.getGreen());
    String priceColor = duckLink.findElement(By.cssSelector("strong.campaign-price"))
            .getCssValue("color");
    java.awt.Color priceRgb = Color.fromString(priceColor).getColor();
    Assert.assertEquals(priceRgb.getBlue(), 0);
    Assert.assertEquals(priceRgb.getGreen(), 0);
    double sizerCampaignPrice = Double.parseDouble(duckLink.findElement(By.className("campaign-price"))
            .getCssValue("font-size").replaceAll("px", ""));
    double sizeRegularPrice = Double.parseDouble(duckLink.findElement(By.className("regular-price"))
            .getCssValue("font-size").replaceAll("px", ""));
    Assert.assertTrue(sizerCampaignPrice > sizeRegularPrice);
    duckLink.click();
    String duckTitleInsidePage = driver.findElement(By.cssSelector("h1.title")).getText();
    String duckPriceInsidePage = driver.findElement(By.className("regular-price")).getText();
    Assert.assertEquals(duckPriceInsidePage, duckPrice);
    Assert.assertEquals(duckTitleInsidePage, duckTitle);
    String colorInsidePage = driver.findElement(By.className("manufacturer")).getCssValue("color");
    java.awt.Color rgbInsidePage = Color.fromString(colorInsidePage).getColor();
    Assert.assertTrue(rgbInsidePage.getBlue() == rgbInsidePage.getGreen());
    Assert.assertTrue(rgbInsidePage.getBlue() == rgbInsidePage.getGreen());
    double sizerCampaignPriceInsidePage = Double.parseDouble(driver.findElement(By.className("campaign-price"))
            .getCssValue("font-size").replaceAll("px", ""));
    double sizeRegularPriceInsidePage = Double.parseDouble(driver.findElement(By.className("regular-price"))
            .getCssValue("font-size").replaceAll("px", ""));
    Assert.assertTrue(sizerCampaignPriceInsidePage > sizeRegularPriceInsidePage);
  }
}
