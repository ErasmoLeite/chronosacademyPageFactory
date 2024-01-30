package app.steps;

import app.pages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.util;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static utils.util.*;
import static utils.util.Emailincorreto;

public class LoginSteps {
    private LoginPage loginPage;
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("uiautomator2");
        options.setAppPackage("br.com.chronosacademy");
        options.setAppActivity("br.com.chronosacademy.MainActivity");
        options.setDeviceName("emulator-5554");
        options.setEnsureWebviewsHavePages(true);
        options.setAutoGrantPermissions(true);
      //  options.setFullReset(false);
       // options.setNoReset(true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
         Thread.sleep(1000);

        loginPage = new LoginPage(driver); // Criação da instância da página de login

        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPage);
    }

    @Test
    public void testLoginDefault() throws InterruptedException {
        // Realize a ação de entrada de email na página de login
        loginPage.inputEmail(Email);
        loginPage.inputSenha(Senha);
        loginPage.btnentrar();

        Thread.sleep(6000);
        assertEquals("Olá, Teste", driver.findElement(AppiumBy.accessibilityId("nameUser")).getText());
        assertEquals("Conheça todos nossos cursos", driver.findElement(AppiumBy.accessibilityId("conhecaTodosNossoCursos")).getText());
    }

    @Test
    public void testLogin() throws InterruptedException {

        loginPage.inputEmail(Email);
        loginPage.inputSenha(Senha);
        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("Olá, Teste", driver.findElement(AppiumBy.accessibilityId("nameUser")).getText());
        assertEquals("Conheça todos nossos cursos", driver.findElement(AppiumBy.accessibilityId("conhecaTodosNossoCursos")).getText());
    }

    @Test
    public void telaLoginEmailObrigatorio() throws InterruptedException {


        loginPage.inputSenha(Senha);
        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O campo de email é obrigatório.", driver.findElement(AppiumBy.accessibilityId("emailError")).getText());


    }

    @Test
    public void telaLoginEmailIncorreto() throws InterruptedException, IOException {

        loginPage.inputEmail(Emailincorreto);
        loginPage.inputSenha(Senha);
        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("Email ou senqha incorretos.", driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"authError\"])[1]")).getText());
        assertEquals("Email ou senha incorretos.", driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"authError\"])[2]")).getText());



    }


    @Test
    public void telaLoginEmailESenhaObrigatorio() throws InterruptedException {

        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O campo de email é obrigatório.", driver.findElement(AppiumBy.accessibilityId("emailError")).getText());
        assertEquals("O campo de senha é obrigatório.", driver.findElement(AppiumBy.accessibilityId("passwordError")).getText());

    }

    @Test
    public void telaLoginEmailInvalido() throws InterruptedException {
        loginPage.inputEmail(EmailInvalido);
        loginPage.inputSenha(Senha);
        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O email não é válido.", driver.findElement(AppiumBy.accessibilityId("emailError")).getText());

    }

    @Test
    public void telaLoginSenhaObrigatoria() throws InterruptedException {
        loginPage.inputEmail(Email);

        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("O campo de senha é obrigatório.", driver.findElement(AppiumBy.accessibilityId("passwordError")).getText());


    }

    @Test
    public void telaLoginSenhaMinima() throws InterruptedException {
        loginPage.inputEmail(Email);
        loginPage.inputSenha(Senhaminima);
        loginPage.btnentrar();
        Thread.sleep(6000);
        assertEquals("A senha deve ter no mínimo 6 caracteres.", driver.findElement(AppiumBy.accessibilityId("passwordError")).getText());

    }

    @Test
    public void telaLoginSenhaIncorreta() {

        loginPage.inputEmail(Email);
        loginPage.inputSenha(Senhaincorreta);
        loginPage.btnentrar();
       // assertEquals("Senha Incorreta.", driver.findElement(AppiumBy.accessibilityId("authError")).getText());


    }

}