package br.com.leoamarilha.saucedemo.tests;
import br.com.leoamarilha.saucedemo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(description = "Testes Automatizados de Login")
public class LoginTests {

    private WebDriver navegador;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
    }

    @Test(description = "Logar com um usuario válido")
    public void testLoginValido() {
        LoginPage loginPage = new LoginPage(navegador);
        loginPage.acessarPaginaLogin();
        loginPage.logarUsuarioSenha("standard_user", "secret_sauce");

        Assert.assertEquals(navegador.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test(description = "Logar com um usuario inválido")
    public void testLoginInvalido() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarPaginaLogin();
        loginPage.logarUsuarioSenha("stadwadwa", "secret_sauce");
        String mensagemErro = loginPage.mensagemErro();

        Assert.assertEquals(mensagemErro , "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown() {
        navegador.quit();
    }

}
