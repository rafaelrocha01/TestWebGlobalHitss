package org.br.globalhitss.core;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class RestLib {
    public RequestSpecification httpRequest;
    public static Response resp;
    public static int status;

    public Response get(String endpoint) {
        httpRequest = RestAssured.given();
        resp = httpRequest.request(Method.GET, endpoint);
        status = resp.getStatusCode();
        return resp;
    }

    public Response post(JSONObject body, String endpoint) {
        httpRequest = RestAssured.given();
        httpRequest.body(body.toString());
        httpRequest.header("Content-Type", "application/json");
        resp = httpRequest.post(endpoint);
        status = resp.getStatusCode();
        return resp;
    }

}
