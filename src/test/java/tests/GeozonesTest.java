package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class GeozonesTest extends TestBase {
    @Test

    public void geoTest() throws InterruptedException {
        admin.login();
        navigation.gotTo("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<String> countries = driver.findElements(By.xpath("//*[@class='row']/td[3]/a"))
                .stream().map(x -> x.getAttribute("href")).collect(Collectors.toList());
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        for (String url : countries) {
            js.executeScript("window.open();");
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            navigation.gotTo(url);
            List<String> zone = driver.findElements(By.cssSelector("td>select[name*='[zone_code]'] option[selected='selected']"))
                    .stream().map(WebElement::getText).collect(Collectors.toList());
           List<String> sortedZone= new ArrayList<>(zone);
           Collections.sort(sortedZone);
           Assert.assertEquals(zone, sortedZone);
           driver.close();
           driver.switchTo().window(mainWindow);
        }
    }

}


