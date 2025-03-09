package br.com.leoamarilha.saucedemo.tests;

import br.com.leoamarilha.saucedemo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
        navegador.findElement(By.cssSelector(".btn_primary.btn_inventory")).click();
        navegador.findElement(By.id("shopping_cart_container")).click();
        navegador.findElement(By.cssSelector(".btn_action.checkout_button")).click();
        navegador.findElement(By.id("first-name")).sendKeys("Leandro");
        navegador.findElement(By.id("last-name")).sendKeys("Amarilha");
        navegador.findElement(By.id("postal-code")).sendKeys("11035101");
        navegador.findElement(By.cssSelector(".btn_primary.cart_button")).click();
        navegador.findElement(By.cssSelector(".btn_action.cart_button")).click();

        // Validando captura da mensagem via variável e checando no Assert
        String mensagemAtual = navegador.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(mensagemAtual, "THANK YOU FOR YOUR ORDER");
    }

    @AfterMethod
    public void tearDown() {
        navegador.quit();
    }
}
