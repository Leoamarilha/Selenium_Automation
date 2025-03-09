package br.com.leoamarilha.saucedemo.tests;

import br.com.leoamarilha.saucedemo.pages.CartPage;
import br.com.leoamarilha.saucedemo.pages.CheckoutPage;
import br.com.leoamarilha.saucedemo.pages.HomePage;
import br.com.leoamarilha.saucedemo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTests {

    private WebDriver navegador;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarPaginaLogin();
        loginPage.logarUsuarioSenha("standard_user", "secret_sauce");
    }

    @Test(description = "Comprar Mochila Sauce Labs")
    public void testComprarMochilaSauceLabs() {

        HomePage homePage = new HomePage(navegador);
        CartPage cartPage = new CartPage(navegador);
        CheckoutPage checkoutPage = new CheckoutPage(navegador);

        homePage.selecionarMochilaSauceLabs();
        homePage.clicarBotaoCarrinho();
        cartPage.clicarBotaoCheckout();
        checkoutPage.preencherNome("Leandro");
        checkoutPage.preencherSobrenome("Amarilha");
        checkoutPage.preencherCep("11035101");
        checkoutPage.clicarBotaoContinuar();
        checkoutPage.clicarBotaoFinalizar();

        // Validando captura da mensagem via variável e checando no Assert
        String mensagemAtualCompra = checkoutPage.sucessoCompra();
        Assert.assertEquals(mensagemAtualCompra, "THANK YOU FOR YOUR ORDER");
    }

    @AfterMethod
    public void tearDown() {
        navegador.quit();
    }
}
