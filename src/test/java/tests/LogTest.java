package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class LogTest extends TestBase{
  @Test
  public void logTest(){
    admin.login();
    navigation.gotTo("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    navigation.click(By.cssSelector("#content > form > table > tbody > tr:nth-child(4) > td:nth-child(3) > a"));
    List<String> ducks = driver.findElements(By.cssSelector("tr.row>td:nth-child(3)>a"))
            .stream().map(x->x.getAttribute("href")).collect(Collectors.toList());
    String mainWindow = driver.getWindowHandle();
    Set<String> oldWindows = driver.getWindowHandles();
    for(String url : ducks){
      js.executeScript("window.open();");
      String newWindow = wait.until(anyWindowOtherThan(oldWindows));
      driver.switchTo().window(newWindow);
      navigation.gotTo(url);
      System.out.println( driver.manage().logs().get("browser").filter(Level.WARNING));
      driver.close();
      driver.switchTo().window(mainWindow);
    }
  }
}
