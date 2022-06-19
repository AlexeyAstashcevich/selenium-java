import applicationManager.AdminHelper;
import applicationManager.HelperBase;
import applicationManager.NavigationHelper;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Set;

public class TestBase {
  public WebDriver driver;
  public WebDriverWait wait;
  public HelperBase helperBase;
  public NavigationHelper navigation;
  public AdminHelper admin;
  public JavascriptExecutor js;


  @BeforeSuite
  public void start() {

    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, 10);
    helperBase = new HelperBase(driver);
    navigation = new NavigationHelper(driver);
    admin = new AdminHelper(driver);
    js = ((JavascriptExecutor)driver);
  }

  @AfterSuite(alwaysRun = true)
  public void stop() {
    driver.quit();
    driver = null;
  }

  public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows){
      return new ExpectedCondition<String>(){
          @NullableDecl
          @Override
          public String apply(@NullableDecl WebDriver input) {
              Set<String> newWindows = driver.getWindowHandles();
              newWindows.removeAll(oldWindows);
              return newWindows.stream().iterator().next();
          }
      };
  }
}
