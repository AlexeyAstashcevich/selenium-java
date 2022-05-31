package applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void gotTo(String url){
    driver.get(url);
  }

  public void click(By locator){
    driver.findElement(locator).click();
  }

  public void type(By locator, String text){
    driver.findElement(locator).sendKeys(text);
  }
}
