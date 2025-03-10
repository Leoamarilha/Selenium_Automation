package br.com.leoamarilha.saucedemo.pages;

import br.com.leoamarilha.saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement primeiroNome;

    @FindBy(id = "last-name")
    private WebElement ultimoNome;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(css = ".btn_primary.cart_button")
    private WebElement botaoContinuar;

    @FindBy(css = ".btn_action.cart_button")
    private WebElement botaoFinalizar;

    @FindBy(className = "complete-header")
    private WebElement header;

    public CheckoutPage(WebDriver navegador) {
        super(navegador);
    }

    public CheckoutPage preencherNome(String nome){
        primeiroNome.sendKeys(nome);
        return new CheckoutPage(navegador);
    }

    public CheckoutPage preencherSobrenome(String sobrenome){
        ultimoNome.sendKeys(sobrenome);
        return new CheckoutPage(navegador);
    }

    public CheckoutPage preencherCep(String cep){
        postalCode.sendKeys(cep);
        return new CheckoutPage(navegador);
    }

    public CheckoutPage clicarBotaoContinuar(){
        botaoContinuar.click();
        return new CheckoutPage(navegador);
    }

    public CheckoutPage clicarBotaoFinalizar(){
        botaoFinalizar.click();
        return new CheckoutPage(navegador);
    }

    public String sucessoCompra (){
       return header.getText();
    }
}
