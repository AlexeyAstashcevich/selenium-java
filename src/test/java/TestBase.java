import applicationManager.HelperBase;
import applicationManager.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
  public WebDriver driver;
  public WebDriverWait wait;
  public HelperBase helperBase;
  public NavigationHelper navigation;


  @BeforeSuite
  public void start() {
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, 10);
    helperBase = new HelperBase(driver);
    navigation= new NavigationHelper(driver);
  }

  @AfterSuite
  public void stop() {
    driver.quit();
    driver = null;
  }
}
