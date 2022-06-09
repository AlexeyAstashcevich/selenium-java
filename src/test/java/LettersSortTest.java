
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
            ArrayList<String> countrySorted = (ArrayList<String>) countryList;
            Collections.sort(countrySorted);
            Assert.assertEquals(countrySorted, countryList);
        }
        List<String> insideCountryList = new ArrayList<>();
        for (WebElement wek : countries) {
            WebElement countriesInside = wek.findElement(By.xpath("..//..//td[6]"));
            if (!countriesInside.getText().equals("0")) {

                insideCountryList.add(wek.findElement(By.xpath("..//..//td[5]/a")).getAttribute("href"));
            }
        }
        for (String url : insideCountryList) {
            driver.get(url);
            List<String> insideCountry = new ArrayList<>();
            List<WebElement> list = driver.findElements(By.xpath("*//tr/td[3]/input[@type='hidden']"));
            for (WebElement ins : list) {
                insideCountry.add(ins.getAttribute("defaultValue"));
            }
            ArrayList<String> insideCountrySorted = (ArrayList<String>) insideCountry;
            Collections.sort(insideCountrySorted);
            Assert.assertEquals(insideCountry, insideCountrySorted);
        }
    }
}

