package app.pages;

import app.maps.CadastroMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CadastroPage {

    AppiumDriver driver;
    CadastroMap cadastroMap;

    public CadastroPage(AppiumDriver driver) {
        this.driver = driver;
        cadastroMap = new CadastroMap();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), cadastroMap);
    }



    public void naotemconta() {
        cadastroMap.naotemconta.click();
    }

    public void inputEmail(String email) {
        cadastroMap.email.sendKeys(email);
    }

    public void inputNome_register(String nome) {
        cadastroMap.nome.sendKeys(nome);
    }

    public void inputSenha(String password) {
        cadastroMap.senha.sendKeys(password);
    }

    public void confirmarsenha(String confirmarsenha) {
        cadastroMap.confirmarsenha.sendKeys(confirmarsenha);
    }

    public void btnentrar() {
        cadastroMap.btncadastrar.click();

    }
}

