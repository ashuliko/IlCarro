package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {

        super(wd);
    }


    public void openLoginForm() {

        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void fillLoginForm(User user) {

        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }


    public void submitForm() {

        click(By.xpath("//button[@type='submit']"));
    }


    public boolean isLogged() {

        return wd.findElements(By.xpath("//a[.=' Log in ']")).size() > 0;
    }

    public boolean isLoggedSuccess() {
        String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        return text.equals("Logged in success");
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));

    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));

    }

    public void openRegistrationForm() {

        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastname, String email, String password) {

        type(By.id("name"), name);
        type(By.id("lastName"), lastname);
        type(By.id("email"), email);
        type(By.id("password"), password);


    }

    public void fillRegistrationForm(User user) {

        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[.='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }

    }

    public void checkPolicy() {
//        click(By.xpath("//label[@for = 'terms-of-use']"));

     JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
      js.executeScript("document.querySelector('#terms-of-use').checked=true;");

    }

    public boolean isRegistrationSuccess() {

        WebElement dialog = wd.findElement(By.cssSelector(".dialog-container h2"));
        String message = dialog.getText();
        return message.equals("You are logged in success");
    }

    public boolean isErrorPasswordDisplayed() {

        click(By.id("email"));
     //  return isElementPresent(By.xpath("//div[@class='error']"));
       return isElementPresent(By.xpath("//*[text()='Password must contain minimum 8 symbols']"));

    }

    public boolean isYallaButtonActive() {
        return wd.findElement(By.xpath("//button[@type='submit']")).isSelected();
        //return isElementPresent(By.xpath("//button[@disabled]"));
    }
}