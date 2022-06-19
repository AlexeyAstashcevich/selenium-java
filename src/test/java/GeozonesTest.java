import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GeozonesTest extends TestBase{
    @Test

    public void geoTest() throws InterruptedException {
        admin.login();
        navigation.gotTo("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<String> countries = driver.findElements(By.xpath("//*[@class='row']/td[3]/a"))
                .stream().map(x->x.getAttribute("href")).collect(Collectors.toList());
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        for (String url: countries){
            js.executeScript("window.open();");
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            navigation.gotTo(url);
            navigation.click(By.className("select2-selection__rendered"));
            List<String> listOfCountry = driver.findElements(By.cssSelector("li.select2-results__option[id]"))
                    .stream().map(x->x.getText()).collect(Collectors.toList());
            List<String> sortedListOfCountry = new ArrayList<>(listOfCountry);
            Collections.sort(sortedListOfCountry);
            Assert.assertEquals(sortedListOfCountry, listOfCountry);
            for (String country: listOfCountry){
                navigation.type(By.cssSelector("input.select2-search__field"), country+ Keys.ENTER);
                List<WebElement> zones = driver.findElements(By.cssSelector("select[name='zones[1][zone_code]']>option"));
                navigation.click(By.className("select2-selection__rendered"));
                if(zones.size()>1){
                    List<String> zonesString = zones.stream().map(WebElement::getText).collect(Collectors.toList());
                    List<String> sortedZones= new ArrayList<>(zonesString);
                    Collections.sort(sortedZones);
                    Assert.assertEquals(zonesString, sortedZones);
                }
            }
            driver.close();
            driver.switchTo().window(mainWindow);
        }
        }
    }

