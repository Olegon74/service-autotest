package ru.test.serviceautotests.api.clients.shell;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import ru.test.serviceautotests.api.assertions.AssertableResponse;
import ru.test.serviceautotests.api.clients.BaseClient;

import static io.restassured.RestAssured.given;

public class TabControllerClient extends BaseClient {
    @Step("Создание вкладки")
    public AssertableResponse createTab(Object body) {
        return new AssertableResponse(
                given()
                        .relaxedHTTPSValidation()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .auth().oauth2(accessToken)
                        .body(body)
                        .baseUri(baseUrl)
                        .post("/shell/api/tabs")
                        .then().log().all()
                        .extract().response()
        );
    }

    @Step("Получение списка вкладок пользователя")
    public AssertableResponse getTabs() {
        return new AssertableResponse(
                given()
                        .relaxedHTTPSValidation()
                        .log().all()
                        .auth().oauth2(accessToken)
                        .baseUri(baseUrl)
                        .get("/shell/api/tabs")
                        .then().log().all()
                        .extract().response()
        );
    }

    @Step("Удаление вкладки по id: {tabId}")
    public AssertableResponse deleteTab(int tabId) {
        return new AssertableResponse(
                given()
                        .relaxedHTTPSValidation()
                        .log().all()
                        .auth().oauth2(accessToken)
                        .baseUri(baseUrl)
                        .delete("/shell/api/tabs/" + tabId)
                        .then().log().all()
                        .extract().response()
        );
    }
}
