package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;


    public void init(){
      wd = new ChromeDriver();
      wd.navigate().to("https://ilcarro.xyz/search");
      wd.manage().window().maximize();
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      userHelper = new UserHelper(wd);

    }

    public void stop(){
        wd.quit();

    }
               //getter userHelper, nado delat' vsegda
    public UserHelper userHelper() {
        return userHelper;
    }
}
