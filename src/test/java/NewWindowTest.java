import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class NewWindowTest extends TestBase{
    @Test
    public void newWindowTest() {
        admin.login();
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        navigation.click(By.cssSelector("ul#box-apps-menu>li:nth-child(3)>a"));
        navigation.click(By.cssSelector("div>a.button"));
        List<WebElement> links = driver.findElements(By.cssSelector("tr>td>a[href*=http]"));
        for (WebElement link: links){
            link.click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }


    }

}
