package br.com.leoamarilha.saucedemo.tests;
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

        new LoginPage(navegador)
                .acessarPaginaLogin()
                .logarUsuarioSenha("standard_user", "secret_sauce");
    }

    @Test(description = "Comprar Mochila Sauce Labs")
    public void testComprarMochilaSauceLabs() {

       String mensagemAtualCompra =  new HomePage(navegador)
                .selecionarMochilaSauceLabs()
                .clicarBotaoCarrinho()
                .clicarBotaoCheckout()
                .preencherNome("Leandro")
                .preencherSobrenome("Amarilha")
                .preencherCep("11035101")
                .clicarBotaoContinuar()
                .clicarBotaoFinalizar()
                .sucessoCompra();

        // Validando captura da mensagem via variável e checando no Assert
        Assert.assertEquals(mensagemAtualCompra, "THANK YOU FOR YOUR ORDER");
    }

    @AfterMethod
    public void tearDown() {
        navegador.quit();
    }
}
