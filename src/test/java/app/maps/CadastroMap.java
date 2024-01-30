package app.maps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CadastroMap {

    AppiumDriver driver;

    @AndroidFindBy(accessibility = "naoTemConta_text")
    public WebElement naotemconta;

    @AndroidFindBy(accessibility = "inputNome_register")
    public WebElement nome;

    @AndroidFindBy(accessibility = "inputEmail_register")
    public WebElement email;

    @AndroidFindBy(accessibility = "inputSenha_register")
    public WebElement senha;

    @AndroidFindBy(accessibility = "inputConfirmarSenha_register")
    public WebElement confirmarsenha;


    @AndroidFindBy(accessibility = "buttonCadastrar_register")
    public WebElement btncadastrar;


    public void CadastroMap(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}



