package org.br.globalhitss.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumLib {
    public RemoteWebDriver driver;

    public SeleniumLib(RemoteWebDriver driver){
        this.driver = driver;
    }

    public void clicar(WebElement webElement){
        webElement.click();
    }

    public void clicarScroll(WebElement webElement){
        scroll(webElement);
        webElement.click();
    }

    public void moverMouse(WebElement element) {
        try {
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void focarNoElemento(WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }

    public void escrever(String texto, WebElement webElement){
        webElement.sendKeys(texto);
    }

    public void escreverEnter(String texto, WebElement webElement){
        webElement.sendKeys(texto);
        webElement.sendKeys(Keys.ENTER);
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String obterTexto(WebElement element){
        scroll(element);
        return element.getText();
    }

}
