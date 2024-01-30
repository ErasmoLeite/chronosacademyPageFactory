package app.pages;

import app.maps.LoginMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class LoginPage {
    AppiumDriver driver;
    LoginMap loginMap;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        loginMap = new LoginMap(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), loginMap);
    }

    public void inputEmail(String username) {
        loginMap.inputemail.sendKeys(username);
    }

    public void inputSenha(String password) {
        loginMap.inputpassword.sendKeys(password);
    }

    public void btnentrar() {
        loginMap.btnentrar.click();

    }
}
