package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductTest extends TestBase{
  @Test

  public void addProduct(){
    admin.login();
    admin.goToProductPage();
    List<WebElement> productsBefore = driver.findElements(By.cssSelector("tr.row td:nth-child(3)>a"));
    admin.addNewProduct();
    admin.fillGeneralPage();
    admin.dillInformationPage();
    admin.fillPricesPage();
    admin.confirm();
    admin.goToProductPage();
    List<WebElement> productsAfter = driver.findElements(By.cssSelector("tr.row td:nth-child(3)>a"));
    Assert.assertEquals(productsBefore.size()+1,productsAfter.size());

  }
}
