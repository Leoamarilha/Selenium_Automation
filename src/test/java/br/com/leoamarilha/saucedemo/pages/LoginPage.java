package br.com.leoamarilha.saucedemo.pages;

import br.com.leoamarilha.saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By localizadorUserName = By.id("user-name");
    private By localizadorPassword = By.id("password");
    private By localizadorBotaologin = By.id("login-button");
    private By localizadorMensagemErro = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarPaginaLogin() {
        navegador.get("https://www.saucedemo.com/v1/");
    }

    public void logarUsuarioSenha (String usuario, String senha) {
        navegador.findElement(localizadorUserName).sendKeys(usuario);
        navegador.findElement(localizadorPassword).sendKeys(senha);
        navegador.findElement(localizadorBotaologin).click();
    }

    public String mensagemErro() {
        return navegador.findElement(localizadorMensagemErro).getText();
    }

}
