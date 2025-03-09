package br.com.leoamarilha.saucedemo.pages;

import br.com.leoamarilha.saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement botaoLogin;

    @FindBy(css = "h3[data-test='error']")
    private WebElement mensagemErro;

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginPage acessarPaginaLogin() {
        navegador.get("https://www.saucedemo.com/v1/");
        return new LoginPage(navegador);
    }

    public LoginPage logarUsuarioSenha (String usuario, String senha) {
        userName.sendKeys(usuario);
        password.sendKeys(senha);
        botaoLogin.click();
        return new LoginPage(navegador);
    }

    public String mensagemErro() {
        return mensagemErro.getText();
    }

}
