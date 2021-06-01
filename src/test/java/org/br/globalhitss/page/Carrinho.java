package org.br.globalhitss.page;

import org.br.globalhitss.core.BasePage;
import org.br.globalhitss.core.RestLib;
import org.br.globalhitss.core.SeleniumLib;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carrinho extends BasePage {

    @FindBy(xpath = "//button[text() = 'OK']")
    private WebElement btnOk;
    @FindBy(id = "cep")
    private WebElement textCep;
    @FindBy(id = "buy-button")
    private WebElement btnContinuar;

    public Carrinho(RemoteWebDriver driver) {
        seleniumLib = new SeleniumLib(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean validarItemNoCarrinho(String produto) {
        return seleniumLib.driver.findElements(By.xpath("//a[@title = '" + produto + "']")).size() > 0;
    }

    public void clicarOk() {
        seleniumLib.clicar(btnOk);
    }

    public void preencherCep(String cep) {
        seleniumLib.escrever(cep, textCep);
    }

    public void clicarContinuar() {
        seleniumLib.clicar(btnContinuar);
    }

    public boolean validarValorDoFrete(String valor) {
        return seleniumLib.driver.findElements(By.xpath("//span[text() = '" + valor + "']")).size() > 0;
    }

    public String buscarCep(String rua) throws JSONException {
        restLib = new RestLib();
        restLib.get("SP/sao paulo/" + rua + "/json");
        JSONArray jsonArray = new JSONArray(RestLib.resp.asString());
        JSONObject json = jsonArray.getJSONObject(1);
        return json.getString("cep");
    }

    public boolean validarMensagemDeErroParaCepInvalido(String msg){
        return seleniumLib.driver.findElements(By.xpath("//p[text() = '"+msg+"']")).size() > 0;
    }
}
