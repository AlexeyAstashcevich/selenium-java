package tests;

import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @Test
    public void registerTest(){
        navigation.gotTo("http://localhost/litecart/");
        navigation.registerNewCostumer();
        navigation.logout();
        navigation.loginInTheShop();
        navigation.logout();
    }
}
