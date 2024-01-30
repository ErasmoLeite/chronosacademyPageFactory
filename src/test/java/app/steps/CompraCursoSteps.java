package app.steps;

import app.pages.CadastroPage;
import app.pages.CompraCursoPage;
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
import utils.util;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static utils.util.*;

public class CompraCursoSteps {

    private CompraCursoPage compraCursoPage;
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
        options.setUnlockType("pattern");
        options.setUnlockKey("741236");
        options.setEnsureWebviewsHavePages(true);
        options.setAutoGrantPermissions(true);
        options.setFullReset(false);

        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(1000);

        compraCursoPage = new CompraCursoPage(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), compraCursoPage);


    }

    @Test
    public void BotaoAdicionarEPagarComCartao() throws IOException, InterruptedException {

        compraCursoPage.btnadicionar();
        compraCursoPage.contador();
        compraCursoPage.irpagamento();
        compraCursoPage.metodo();
        compraCursoPage.cartaodecredito();
        compraCursoPage.inputCredicard(numerocartao);
        compraCursoPage.inputdata(validadecartao);
        compraCursoPage.inputCVV(cvvcartao);
        compraCursoPage.inputNomeTitular(Nome);
        compraCursoPage.inputCPFTitular(Documento);
        compraCursoPage.confirmar_pagamento_botao();


    }


    @Test
    public void BotaoAdicionarEPagarComBoleto() throws IOException, InterruptedException {

        compraCursoPage.btnadicionar();
        compraCursoPage.contador();
        compraCursoPage.irpagamento();
        compraCursoPage.metodo();
        compraCursoPage.boleto();
        compraCursoPage.copiacodigoboleto();


    }


    @Test
    public void BotaoAdicionarEPagarComPix() throws IOException, InterruptedException {

        compraCursoPage.btnadicionar();
        compraCursoPage.contador();
        compraCursoPage.irpagamento();
        compraCursoPage.metodo();
        compraCursoPage.pix();
        compraCursoPage.copiachave();


    }



    @Test
    public void BotaoComprarEPagarComCartaoCredito() throws IOException, InterruptedException {

        compraCursoPage.btncomprar();
        compraCursoPage.irParaoPagamentoProduct();
        compraCursoPage.metodo();
        compraCursoPage.cartaodecredito();
        compraCursoPage.inputCredicard(numerocartao);
        compraCursoPage.inputdata(validadecartao);
        compraCursoPage.inputCVV(cvvcartao);
        compraCursoPage.inputNomeTitular(Nome);
        compraCursoPage.inputCPFTitular(Documento);
        compraCursoPage.confirmar_pagamento_botao();


    }


    @Test
    public void BotaoComprarEPagarComBoleto() throws IOException, InterruptedException {

        compraCursoPage.btncomprar();
        compraCursoPage.irParaoPagamentoProduct();
        compraCursoPage.metodo();
        compraCursoPage.boleto();
        compraCursoPage.copiacodigoboleto();


    }

    @Test
    public void BotaoComprarEPagarComPix() throws IOException, InterruptedException {

        compraCursoPage.irParaoPagamentoProduct();
        compraCursoPage.irpagamento();
        compraCursoPage.metodo();
        compraCursoPage.pix();
        compraCursoPage.copiachave();


    }

    @Test
    public void SelecionarImagemCursoEPagarComCartaoCredito() throws IOException, InterruptedException {

        compraCursoPage.imagemcurso();
        compraCursoPage.irParaoPagamentoProduct();
        compraCursoPage.metodo();
        compraCursoPage.cartaodecredito();
        compraCursoPage.inputCredicard(numerocartao);
        compraCursoPage.inputdata(validadecartao);
        compraCursoPage.inputCVV(cvvcartao);
        compraCursoPage.inputNomeTitular(Nome);
        compraCursoPage.inputCPFTitular(Documento);
        compraCursoPage.confirmar_pagamento_botao();


    }

    @Test
    public void SelecionarImagemCursoEPagarComBoleto() throws IOException, InterruptedException {

        compraCursoPage.imagemcurso();
        compraCursoPage.irParaoPagamentoProduct();
        compraCursoPage.metodo();
        compraCursoPage.boleto();
        compraCursoPage.copiacodigoboleto();


    }

    @Test
    public void SelecionarImagemCursoEPagarCom_Pix() throws IOException, InterruptedException {

        compraCursoPage.imagemcurso();
        compraCursoPage.irParaoPagamentoProduct();
        compraCursoPage.metodo();
        compraCursoPage.pix();
        compraCursoPage.copiachave();


    }
}
