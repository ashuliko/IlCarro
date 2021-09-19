package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{


    @BeforeMethod
    public void precondition(){
        if(app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void registrationTest(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("And", "Sh", "qwerty"+i+"@ru.ru", "AaSs23*"+i+"$!");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());
    }

    @Test
    public void registrationTest2(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("And", "Sh", "qwerty"+i+"@ru.ru", "AaSs23*"+i+"$!");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());
    }

    @Test
    public void registrationTestModel(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User()
                .withName("And").withLastName("Sh").withEmail("qwerty"+i+"@ru.ru").withPassword("AaSs23*"+i+"$!");

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm(user);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());
    }

    @Test
    public void registrationTestNegative() throws InterruptedException {

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("And", "Sh", "qwerty"+i+"@ru.ru", "23*"+i);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();

        Assert.assertTrue(app.userHelper().isErrorPasswordDisplayed());
        Assert.assertFalse(app.userHelper().isYallaButtonActive());

    }
    @AfterMethod
    public void postCondition(){
        app.userHelper().clickOkButton();
    }
}
