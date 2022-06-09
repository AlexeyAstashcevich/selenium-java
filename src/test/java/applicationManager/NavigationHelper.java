package applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  private HelperBase helperBase;
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

  public void registerNewCostumer() {
    driver.findElement(By.xpath("//*table/tbody/tr[5]/td/a"));
    type(By.name("tax_id"),"Alex");
    type(By.name("firstname"),"Kokoshka");
    type((By.name("address1"),"12nj");
    driver.findElement(By.id("select2-country_code-g6-container")).sendKeys();
    type(By.name("company"),"Lopoer");
    type(By.name("lastname"),"Lopoer");
    type(By.name("address2"),"britan beach");
    type(By.name("city"),"piter");
    type(By.name("email"),"piter");
    type(By.name("city"),"piter");
    type(By.name("phone"),Keys.HOME +"9455485");
    type(By.name("password"),"password");
    type(By.name("confirmed_password"),"password");
    click(By.name("create_account"));





  }


}
