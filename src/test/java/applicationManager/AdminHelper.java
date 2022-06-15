package applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class AdminHelper extends HelperBase {
  NavigationHelper navigation= new NavigationHelper(driver);
  public JavascriptExecutor js= ((JavascriptExecutor)driver);
  public AdminHelper(WebDriver driver) {
    super(driver);
  }

  public void login() {
    navigation.gotTo("http://localhost/litecart/admin/login.php");
    navigation.type(By.name("username"), "admin");
    navigation.type(By.name("password"), "admin");
    navigation.click(By.name("login"));
  }

  public void goToProductPage(){
    navigation.click(By.cssSelector("ul#box-apps-menu li:nth-child(2)#app->a[href]"));
  }

  public void addNewProduct(){
    navigation.click(By.cssSelector("div a:nth-child(2).button"));
  }

  public void fillGeneralPage(){
    navigation.click(By.name("status"));
    navigation.type(By.name("name[en]"), "New thing");
    navigation.type(By.name("code"), "616");
    navigation.click(By.cssSelector("tr>td>input[value='2']"));
    navigation.click(By.name("default_category_id"));
    navigation.select(By.name("default_category_id"),"Subcategory");
    navigation.click(By.cssSelector("tr>td>input[value='1-1']"));
    navigation.type(By.name("quantity"), Keys.HOME+"25");
    navigation.addPhoto(By.name("new_images[]"), "src/test/resources/duck.jpg");
    navigation.click(By.name("date_valid_from"));
    navigation.type(By.name("date_valid_from"), Keys.HOME+"01011991");
    navigation.click(By.name("date_valid_to"));
    navigation.type(By.name("date_valid_to"), Keys.HOME+"02021992");
  }

  public void dillInformationPage() {
    navigation.click(By.cssSelector("ul.index li:nth-child(2)>a"));
    navigation.click(By.name("manufacturer_id"));
    navigation.select(By.name("manufacturer_id"), "ACME Corp.");
    navigation.type(By.name("keywords"), "thing");
    navigation.type(By.name("short_description[en]"), "This the similar Duck");
    navigation.type(By.className("trumbowyg-editor"), "Duck description");
    navigation.type(By.name("head_title[en]"), "Test title");
    navigation.type(By.name("meta_description[en]"), "Test");
  }

  public void fillPricesPage() {
    navigation.click(By.cssSelector("ul.index li:nth-child(4)>a"));
    navigation.type(By.name("purchase_price"), Keys.HOME + "2");
    navigation.click(By.name("purchase_price_currency_code"));
    navigation.select(By.name("purchase_price_currency_code"), "US Dollars");
    navigation.type(By.name("prices[USD]"),"24");
    navigation.type(By.name("prices[EUR]"),"24");
  }

  public void confirm() {
    navigation.click(By.name("save"));
  }
}
