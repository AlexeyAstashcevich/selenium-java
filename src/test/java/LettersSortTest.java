import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LettersSortTest extends TestBase {
  @Test
  public void sortTest(){
    login();
    navigation.gotTo("http://localhost/litecart/admin/?app=countries&doc=countries");
    List<WebElement> countries = driver.findElements(By.cssSelector("tr.row a"));
    List<String> country = null;
    for (WebElement wec:countries){
      String countri = wec.getAttribute("Text");
     country.add(countri);
    }

  }
}
