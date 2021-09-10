package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginSuccess() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("qwerty@ru.ru", "AaSsDd123*$!");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void negativeLoginWrongPassword() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("qwerty@ru.ru", "AaSsDd123*6!");
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isLogged());
    }

    @AfterMethod
    public void postCondition() {
        if(app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }
}
