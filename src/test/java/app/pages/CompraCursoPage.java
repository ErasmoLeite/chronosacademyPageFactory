package app.pages;

import app.maps.CompraCursoMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CompraCursoPage {

    AppiumDriver driver;
    CompraCursoMap compraCursoMap;

    public CompraCursoPage(AppiumDriver driver) {
        this.driver = driver;
        compraCursoMap = new CompraCursoMap(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), compraCursoMap);
    }


    public void btnadicionar() {
        compraCursoMap.btnadicionar.click();
    }

    public void contador() {
        compraCursoMap.btncontador.click();
    }


    public void irpagamento() {
        compraCursoMap.btnirpagamento.click();
    }


    public void irParaoPagamentoProduct() {
        compraCursoMap.btnirParaoPagamentoProduct.click();
    }


    public void metodo() {
        compraCursoMap.metodoPagamento.click();
    }

    public void cartaodecredito() {
        compraCursoMap.imagemCartao_credito.click();
    }

    public void inputCredicard(String numerocartao) {
        compraCursoMap.numerocartao.sendKeys(numerocartao);
    }


    public void inputdata(String validadecartao) {
        compraCursoMap.validade.sendKeys(validadecartao);
    }


    public void inputCVV(String cvvcartao) {
        compraCursoMap.cvv.sendKeys(cvvcartao);
    }


    public void inputNomeTitular(String Nome) {
        compraCursoMap.nometitular.sendKeys(Nome);
    }

    public void inputCPFTitular(String documento) {
        compraCursoMap.cpftitular.sendKeys(documento);
    }

    public void confirmar_pagamento_botao() {
        compraCursoMap.confirmarpagamento.click();
    }

    public void boleto() {
        compraCursoMap.boleto.click();
    }

    public void copiacodigoboleto() {
        compraCursoMap.copiar_codigo.click();
    }

    public void pix() {
        compraCursoMap.imagemLogo_pix.click();
    }

    public void copiachave() {
        compraCursoMap.copiar_chave_botao.click();
    }


    public void btncomprar() {
        compraCursoMap.btncomprar.click();
    }


    public void imagemcurso() {
        compraCursoMap.imagemcurso.click();
    }
}

