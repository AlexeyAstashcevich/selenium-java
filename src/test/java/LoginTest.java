import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginTest extends TestBase {
  @Test
  public void loginTest(){
    navigation.gotTo("http://localhost/litecart/admin/");
    navigation.type(By.name("username"),"admin");
    navigation.type(By.name("password"),"admin");
    navigation.click(By.name("login"));
    wait.until(titleIs("My Store"));
    navigation.click(By.name("Appearence"));
    Assert.assertTrue(helperBase.isElementPresent(driver, By.cssSelector("h1")));
  }
}
