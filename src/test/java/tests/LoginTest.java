package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void loginSuccess() {

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("qwerty@ru.ru", "AaSsDd123*$!");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("qwerty@ru.ru").withPassword("AaSsDd123*$!");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void negativeLoginWrongPassword() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("qwerty@ru.ru", "AaSsDd123");
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isLoggedSuccess());
    }

    @AfterMethod
    public void postCondition() {
        app.userHelper().clickOkButton();

    }
}
