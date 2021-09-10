package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

import static tests.TestBase.app;

public class RegistrationTest extends TestBase {


    @BeforeMethod
    public void precondition() {

    }

    @Test
    public void registrationTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("And", "Sh", "qwerty" + i + "@ru.ru", "AaSs" + i + "23*$!");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
    }

    @Test
    public void registrationTestNegative() {


    }

    @AfterMethod
    public void postCondition() {


    }


}
