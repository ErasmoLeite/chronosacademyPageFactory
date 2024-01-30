package app.steps;

import app.pages.CadastroPage;
import app.pages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static utils.util.*;


public class CadastroSteps {
    private CadastroPage cadastroPage;
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("uiautomator2");
        options.setAppPackage("br.com.chronosacademy");
        options.setAppActivity("br.com.chronosacademy.MainActivity");
        options.setDeviceName("emulator-5554");
        options.setUnlockType("pattern");
        options.setUnlockKey("741236");
        options.setEnsureWebviewsHavePages(true);
        options.setAutoGrantPermissions(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(1000);

        cadastroPage = new CadastroPage(driver); // Criação da instância da página de login

        PageFactory.initElements(new AppiumFieldDecorator(driver), cadastroPage);
    }


    @Test
    public void testCadastro() {

        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputEmail(Email);
        cadastroPage.inputSenha(Senha);
        cadastroPage.confirmarsenha(Confirmasenha);
        cadastroPage.btnentrar();
        assertEquals("Cadastro realizado com sucesso!", driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Cadastro realizado com sucesso!\"]/android.view.ViewGroup/android.widget.TextView")).getText());


    }


    @Test
    public void telaCadastroNomeObrigatorio()  {
        cadastroPage.naotemconta();
        cadastroPage.inputEmail(Email);
        cadastroPage.inputSenha(Senha);
        cadastroPage.confirmarsenha(Confirmasenha);
        cadastroPage.btnentrar();
        assertEquals("O campo de nome é obrigatório.", driver.findElement(AppiumBy.accessibilityId("nomeError")).getText());



    }

    @Test
    public void telaCadastroEmailObrigatorio() throws InterruptedException {
        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputSenha(Senha);
        cadastroPage.confirmarsenha(Confirmasenha);
        cadastroPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O campo de email é obrigatório.", driver.findElement(AppiumBy.accessibilityId("emailError")).getText());


    }

    @Test
    public void telaCadastroEmailFormatoInvalido() throws InterruptedException, IOException {

        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputEmail(EmailInvalido);
        cadastroPage.inputSenha(Senha);
        cadastroPage.confirmarsenha(Confirmasenha);
        cadastroPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O email não é válido.", driver.findElement(AppiumBy.accessibilityId("emailError")).getText());

    }

    @Test
    public void telaCadastroSenhaObrigatoria() throws InterruptedException, IOException {


        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputEmail(Email);
        cadastroPage.confirmarsenha(Confirmasenha);
        cadastroPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O campo de senha é obrigatório.", driver.findElement(AppiumBy.accessibilityId("passwordError")).getText());

    }

    @Test
    public void telaCadastroConfirmarsenhaobrigatório() throws InterruptedException, IOException {

        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputEmail(Email);
        cadastroPage.inputSenha(Senha);
        cadastroPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O campo de Confirmar senha é obrigatório.", driver.findElement(AppiumBy.accessibilityId("confirmPasswordError")).getText());

    }

    @Test
    public void telaCadastroSenhasNaocoincidem() throws InterruptedException, IOException {


        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputEmail(Email);
        cadastroPage.inputSenha(Senha);
        cadastroPage.confirmarsenha(Senhaminima);
        cadastroPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("As senhas não coincidem.", driver.findElement(AppiumBy.accessibilityId("confirmPasswordError")).getText());

    }

    @Test
    public void telaCadastroSenhaMinimoCaracteres_ConfirmarSenhaVazio() throws InterruptedException, IOException {


        cadastroPage.naotemconta();
        cadastroPage.inputNome_register(Nome);
        cadastroPage.inputEmail(Email);
        cadastroPage.inputSenha(Senhaminima);

        cadastroPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("A senha deve ter no mínimo 6 caracteres.", driver.findElement(AppiumBy.accessibilityId("passwordError")).getText());


    }

}
