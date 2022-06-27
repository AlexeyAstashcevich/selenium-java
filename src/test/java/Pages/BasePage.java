package Pages;

import applicationManager.AdminHelper;
import applicationManager.HelperBase;
import applicationManager.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  public WebDriver driver;
  public WebDriverWait wait;
  public HelperBase helperBase;
  public NavigationHelper navigation;
  public AdminHelper admin;

  public BasePage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    helperBase = new HelperBase(driver);
    navigation = new NavigationHelper(driver);
    admin = new AdminHelper(driver);
  }
}
