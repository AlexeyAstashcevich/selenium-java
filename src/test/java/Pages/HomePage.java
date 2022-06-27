package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class HomePage extends BasePage{
  public HomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void addDucksToBucket(int sumOfDucks) {
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
  }

  public void goToBucket() {
    navigation.click(By.cssSelector("div#cart-wrapper a.link"));
  }

}
