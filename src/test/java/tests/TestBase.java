package tests;

import Pages.BucketPage;
import Pages.HomePage;
import applicationManager.AdminHelper;
import applicationManager.HelperBase;
import applicationManager.NavigationHelper;
import com.google.common.collect.ImmutableMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Set;

public class TestBase {
  public BucketPage bucketPage;
  public HomePage homePage;
  public EventFiringWebDriver driver;
  public WebDriverWait wait;
  public HelperBase helperBase;
  public NavigationHelper navigation;
  public AdminHelper admin;
  public JavascriptExecutor js;

  public static class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by +  " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }
  }

  @BeforeSuite
  public void start() {
    ChromeOptions opt = new ChromeOptions();
    opt.setExperimentalOption("w3c", false);
    driver = new EventFiringWebDriver(new ChromeDriver(opt));
    driver.register(new MyListener());
    wait = new WebDriverWait(driver, 10);
    helperBase = new HelperBase(driver);
    navigation = new NavigationHelper(driver);
    admin = new AdminHelper(driver);
    js = ((JavascriptExecutor)driver);
    homePage = new HomePage(driver,wait);
    bucketPage = new BucketPage(driver,wait);
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
