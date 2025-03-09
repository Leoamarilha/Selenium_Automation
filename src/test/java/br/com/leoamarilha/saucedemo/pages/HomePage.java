package br.com.leoamarilha.saucedemo.pages;

import br.com.leoamarilha.saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  extends BasePage {

    public HomePage (WebDriver navegador) {
        super(navegador);
    }

    public HomePage selecionarMochilaSauceLabs() {
        navegador.findElement(By.cssSelector(".btn_primary.btn_inventory")).click();
        return new HomePage(navegador);
    }

    public CartPage clicarBotaoCarrinho() {
        navegador.findElement(By.id("shopping_cart_container")).click();
        return new CartPage(navegador);
    }

}
