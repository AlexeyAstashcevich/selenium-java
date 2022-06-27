package tests;

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
        List<String> countriesString = new ArrayList<>(countries.stream().map(x->x.getText()).collect(Collectors.toList()));
        List<String> countrySorted = new ArrayList<>(countriesString);
        Collections.sort(countrySorted);
        Assert.assertEquals(countriesString, countrySorted);
        for (WebElement wec : countries) {
            if (!wec.findElement(By.xpath("..//..//td[6]")).getText().equals("0")) {
                String url = wec.findElement(By.xpath("..//..//td[5]/a")).getAttribute("href");
                js.executeScript("window.open();");
                String newWindow = wait.until(anyWindowOtherThan(oldWindows));
                driver.switchTo().window(newWindow);
                navigation.gotTo(url);
                List <String> list = driver.findElements(By.xpath("*//tbody//tbody//tr/td[3]"))
                        .stream().map(x->x.getText()).collect(Collectors.toList());
                list.remove("");
                List<String> sortedList = new ArrayList<>(list);
                Collections.sort(sortedList);
                Assert.assertEquals(list, sortedList);
                driver.close();
                driver.switchTo().window(mainWindow);
            }
        }
    }
}

