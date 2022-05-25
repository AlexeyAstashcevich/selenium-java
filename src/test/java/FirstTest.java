import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class FirstTest extends TestBase {
  @Test

  public void myFirstTest() {
    driver.get("https://yandex.ru/");
    driver.findElement(By.id("text")).sendKeys("maven");
    driver.findElement(By.cssSelector(".search2")).submit();
    wait.until(titleContains("maven — Яндекс"));
  }
}
