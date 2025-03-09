package br.com.leoamarilha.saucedemo.pages;

import br.com.leoamarilha.saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage  extends BasePage {

    @FindBy(css = ".btn_action.checkout_button" )
    private WebElement botaoCheckout;

    public CartPage(WebDriver navegador) {
        super(navegador);
    }

    public void clicarBotaoCheckout () {
        botaoCheckout.click();
    }
}
