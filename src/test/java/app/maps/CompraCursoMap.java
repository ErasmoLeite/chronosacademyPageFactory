package app.maps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CompraCursoMap {
    AppiumDriver driver;

    @AndroidFindBy(accessibility = "automacao_sem_complicacao_mobile_o_inicio_buttonAdicionar_home")
    public WebElement btnadicionar;


    @AndroidFindBy(accessibility = "automacao_sem_complicacao_mobile_o_inicio")
    public WebElement imagemcurso;

    @AndroidFindBy(accessibility = "automacao_sem_complicacao_mobile_o_inicio_buttonComprar_home")
    public WebElement btncomprar;

    @AndroidFindBy(accessibility = "contador")
    public WebElement btncontador;

    @AndroidFindBy(accessibility = "irParaPagamentoButton")
    public WebElement btnirpagamento;


    @AndroidFindBy(accessibility = "irParaoPagamentoProduct")
    public WebElement btnirParaoPagamentoProduct;



    @AndroidFindBy(accessibility = "metodoPagamento")
    public WebElement metodoPagamento;

    @AndroidFindBy(accessibility = "imagemCartao_credito")
    public WebElement imagemCartao_credito;

    @AndroidFindBy(accessibility = "inputCredicard")
    public WebElement numerocartao;


    @AndroidFindBy(accessibility = "inputdata")
    public WebElement validade;

    @AndroidFindBy(accessibility = "inputCVV")
    public WebElement cvv;

    @AndroidFindBy(accessibility = "inputNomeTitular")
    public WebElement nometitular;

    @AndroidFindBy(accessibility = "inputCPFTitular")
    public WebElement cpftitular;

    @AndroidFindBy(accessibility = "confirmar_pagamento_botao")
    public WebElement confirmarpagamento;

    @AndroidFindBy(accessibility = "imagemLogo_boleto")
    public WebElement boleto;

    @AndroidFindBy(accessibility = "copiar_codigo")
    public WebElement copiar_codigo;

    @AndroidFindBy(accessibility = "imagemLogo_pix")
    public WebElement imagemLogo_pix;

    @AndroidFindBy(accessibility = "copiar_chave_botao")
    public WebElement copiar_chave_botao;

    public CompraCursoMap(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}


