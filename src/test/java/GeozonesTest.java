import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeozonesTest extends TestBase{
    @Test

    public void geoTest(){
        admin.login();
        navigation.gotTo("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countries = driver.findElements(By.xpath("//*[@class='row']/td[3]/a"));
        List<String> coutriesUrl = new ArrayList<>();
        for (WebElement url: countries){
            coutriesUrl.add(url.getAttribute("href"));
        }
        for (String country: coutriesUrl){
            navigation.gotTo(country);
            List<WebElement> countriesList = driver.findElements(By.xpath("//*tr/td[2]/select[@aria-hidden='true']"));
        }
    }
}
