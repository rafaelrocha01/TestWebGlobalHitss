package org.br.globalhitss.page;

import org.br.globalhitss.core.BasePage;
import org.br.globalhitss.core.SeleniumLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCliente extends BasePage {

    @FindBy(id = "email-input")
    private WebElement textEmail;
    @FindBy(id = "password-input")
    private WebElement textSenha;
    @FindBy(id = "login-button")
    private WebElement btnContinuar;

    public LoginCliente(RemoteWebDriver driver) {
        seleniumLib = new SeleniumLib(driver);
        PageFactory.initElements(driver, this);
    }

    public void preencherEmail(String email) {
        seleniumLib.escrever(email, textEmail);
    }

    public void preencherSenha(String senha) {
        seleniumLib.escrever(senha, textSenha);
    }

    public void clicarContinuar() {
        seleniumLib.clicar(btnContinuar);
    }
}
