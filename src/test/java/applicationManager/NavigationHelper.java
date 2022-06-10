package applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationHelper extends HelperBase {
  private HelperBase helperBase;
  String email = "piter"+System.currentTimeMillis()+"@yandex.ru";

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void gotTo(String url) {
    driver.get(url);
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    driver.findElement(locator).sendKeys(text);
  }

  protected void select(By locator, String text) {
    new Select(driver.findElement(locator)).selectByVisibleText(text);
  }

  public void registerNewCostumer() {

    click(By.linkText("New customers click here"));
    type(By.name("tax_id"), "Alex");
    type(By.name("firstname"), "Kokoshka");
    type (By.name("address1"), "12nj");
    click(By.className("select2-selection__rendered"));
    type(By.className("select2-search__field"), "United States" + Keys.ENTER);
    click(By.xpath("//select[@name='zone_code']"));
    select(By.xpath("//select[@name='zone_code']"), "Guam");
    type(By.name("postcode"), "19614");
    type(By.name("company"), "Lopoer");
    type(By.name("lastname"), "Lopoer");
    type(By.name("address2"), "britan beach");
    type(By.name("city"), "piter");
    type(By.name("email"), email);
    type(By.name("city"), "piter");
    type(By.name("phone"), Keys.HOME + "9455485");
    type(By.name("password"), "password");
    type(By.name("confirmed_password"), "password");
    click(By.name("create_account"));
  }


  public void logout() {
    click(By.cssSelector("ul.list-vertical > li:nth-child(4) > a"));
  }

  public void loginInTheShop() {
    type(By.name("email"), email);
    type(By.name("password"), "password");
    click(By.name("login"));
  }
}
