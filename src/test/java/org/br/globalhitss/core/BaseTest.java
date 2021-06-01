package org.br.globalhitss.core;


import io.restassured.RestAssured;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.br.globalhitss.config.Parametro.urlApi;


public class BaseTest {

    protected DriverSelenium driverSelenium;

    protected RemoteWebDriver startTestCase() {
        RestAssured.baseURI = urlApi;
        driverSelenium = new DriverSelenium();
        return driverSelenium.getDriver();
    }

    public void finishTestCase() {
        driverSelenium.closeDriver();
    }
}
