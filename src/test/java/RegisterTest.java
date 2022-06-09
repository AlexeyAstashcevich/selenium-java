import org.testng.annotations.Test;

public class RegisterTest extends TestBase{
    @Test
    public void registerTest(){
        navigation.gotTo("http://localhost/litecart/");
        navigation.registerNewCostumer();
    }
}
