package org.br.globalhitss.page;

import org.br.globalhitss.core.BasePage;
import org.br.globalhitss.core.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home extends BasePage {

    @FindBy(xpath = "//a[text() = 'entrar']")
    private WebElement btnEntrar2;
    @FindBy(xpath = "//span[text() = 'Entrar']")
    private WebElement btnEntar;
    @FindBy(id = "h_search-input")
    private WebElement textBuscar;
    @FindBy(id = "lgpd-accept")
    private WebElement btnAceitarCookie;
    @FindBy(xpath = "//span[text() = 'Comprar ']")
    private WebElement btnComprar;

    public Home(RemoteWebDriver driver) {
        seleniumLib = new SeleniumLib(driver);
        PageFactory.initElements(driver, this);
    }

    public void clicarComprar() {
        seleniumLib.clicar(btnComprar);
    }

    public void clicarEmEntrar() {
        seleniumLib.clicar(btnEntar);
        seleniumLib.clicar(btnEntrar2);
    }

    public void buscarProduto(String produto) {
        seleniumLib.escreverEnter(produto, textBuscar);
    }

    public WebElement validarItemRetornadoNaBusca(String produto) {
        seleniumLib.clicar(btnAceitarCookie);
        WebElement resultado = null;
        List<WebElement> listaItens = seleniumLib.driver.findElements(By.xpath("//h1[text() = '" + produto + "']/../div[2]/div//a/span"));
        for (WebElement itens : listaItens) {
            String descricaoItem = itens.getText();
            resultado = itens;
            if (descricaoItem.equals(produto)) {
                resultado.click();
                return resultado;
            }
        }
        return resultado;
    }

}
