
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


public class LettersSortTest extends TestBase {
    @Test
    public void sortTest(){
        admin.login();
        navigation.gotTo("http://localhost/litecart/admin/?app=countries&doc=countries");
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        List<WebElement> countries = driver.findElements(By.xpath("//*[@class='row']/td[5]/a"));
        for (WebElement wec : countries) {
            if (!wec.findElement(By.xpath("..//..//td[6]")).getText().equals("0")) {
                String url = wec.findElement(By.xpath("..//..//td[5]/a")).getAttribute("href");
                js.executeScript("window.open();");
                String newWindow = wait.until(anyWindowOtherThan(oldWindows));
                driver.switchTo().window(newWindow);
                navigation.gotTo(url);
                List <String> list = driver.findElements(By.xpath("*//tbody//tbody//tr/td[3]/input[@type='hidden']"))
                        .stream().map(x->x.getAttribute("defaultValue")).collect(Collectors.toList());
                List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
                Assert.assertEquals(list, sortedList);
                driver.close();
                driver.switchTo().window(mainWindow);
            }
        }
    }
}

