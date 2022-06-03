import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginTest extends TestBase {
  @Test
  public void loginTest() {
    navigation.gotTo("http://localhost/litecart/admin/");
    navigation.type(By.name("username"), "admin");
    navigation.type(By.name("password"), "admin");
    navigation.click(By.name("login"));
    wait.until(titleIs("My Store"));
    List<WebElement> fields = driver.findElements(By.id("app-"));
    for (int i = 1; i < fields.size(); i++) {
      String path = "//li[@id='app-'][" + i + "]";
      navigation.click(By.xpath(path));
      Assert.assertTrue(helperBase.isElementPresent(driver, By.cssSelector("h1")));
      if (helperBase.isElementPresent(driver, By.xpath(path + "/ul[@class='docs']"))) {
        List<WebElement> elements = driver.findElements(By.xpath(path + "/ul[@class='docs']/li"));
        for (int l = 1; l <= elements.size(); l++) {
          navigation.click(By.xpath(path + "/ul[@class='docs']/li[" + l + "]/a"));
          Assert.assertTrue(helperBase.isElementPresent(driver, By.cssSelector("h1")));
        }
      }
    }
  }
}
