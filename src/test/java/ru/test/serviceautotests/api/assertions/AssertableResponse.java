package ru.test.serviceautotests.api.assertions;

import io.restassured.response.Response;

public class AssertableResponse {
    private final Response response;

    public AssertableResponse(Response response) {
        this.response = response;
    }

    public AssertableResponse should(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T as(Class<T> type) {
        return response.as(type);
    }

    public <T> T as(String path, Class<T> type) {
        return response.jsonPath().getObject(path, type);
    }
}
