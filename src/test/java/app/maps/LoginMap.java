package app.maps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginMap {
    AppiumDriver driver;

    @AndroidFindBy(accessibility = "inputEmail")
    public WebElement inputemail;

    @AndroidFindBy(accessibility = "inputPassword")
    public WebElement inputpassword;

    @AndroidFindBy(accessibility = "btnEntrar")
    public WebElement btnentrar;

    public LoginMap(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
