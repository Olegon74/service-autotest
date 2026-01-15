package ru.test.serviceautotests.api.clients.auth;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.test.serviceautotests.config.ConfigLoader;
import ru.test.serviceautotests.config.TestConfig;
import ru.test.serviceautotests.api.models.TokenResponse;
import ru.test.serviceautotests.utils.SecretResolver;

import static io.restassured.RestAssured.given;

public class AuthClient {
    private final TestConfig config = ConfigLoader.getConfig();

    @Step("Получение access token")
    public String getAccessToken() {
        Response response = given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", config.grantType())
                .formParam("client_id", config.clientId())
                .formParam("client_secret", SecretResolver.resolve(config.clientSecret()))
                .formParam("username", SecretResolver.resolve(config.username()))
                .formParam("password", SecretResolver.resolve(config.password()))
                .post(config.keycloakUrl());

        return response.as(TokenResponse.class).getAccessToken();
    }
}
