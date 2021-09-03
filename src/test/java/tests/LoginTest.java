package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginSuccess() {
        openLoginForm();
        fillLoginForm("qwerty@ru.ru", "AaSsDd123*$!");
        submitForm();
        Assert.assertTrue(isLogged());
    }

    @Test
    public void negativeLoginWrongPassword() {
        openLoginForm();
        fillLoginForm("qwerty@ru.ru", "AaSsDd123*6!");
        submitForm();
        Assert.assertFalse(isLogged());
    }

    @AfterMethod
    public void postCondition() {
        if(isLogOutPresent()) {
            logout();
        }
    }
}
