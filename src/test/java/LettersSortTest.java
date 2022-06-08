
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LettersSortTest extends TestBase {
  @Test
  public void sortTest() {
    login();
    navigation.gotTo("http://localhost/litecart/admin/?app=countries&doc=countries");
    List<WebElement> countries = driver.findElements(By.xpath("//*[@class='row']/td[5]/a"));
    List<String> countryList = new ArrayList<>();
    for (WebElement wec : countries) {
        countryList.add(wec.getText());
        WebElement countriesInside = wec.findElement(By.xpath("..//..//td[6]"));
        if (!countriesInside.getText().equals("0")) {
          List<String> insideCountry = new ArrayList<>();
          wec.click();
          List<WebElement> list = driver.findElements(By.cssSelector("tbody input[name=zone]"));
          for (WebElement ins:list){
            insideCountry.add( ins.getText());
          }
          ArrayList<String> insideCountrySorted = (ArrayList<String>) insideCountry;
          Collections.sort(insideCountrySorted);
          Assert.assertEquals(insideCountry,insideCountrySorted );
          list.removeAll(list);
          insideCountry.removeAll(insideCountry);
          insideCountrySorted.removeAll(insideCountrySorted);
          navigation.gotTo("http://localhost/litecart/admin/?app=countries&doc=countries");
        }
      }
    ArrayList<String> countrySorted = (ArrayList<String>) countryList;
    Collections.sort(countrySorted);
    Assert.assertEquals(countrySorted, countryList);
  }
}