package ru.test.serviceautotests.api.assertions;

import io.restassured.response.Response;

@FunctionalInterface
public interface Condition {
    void check(Response response);
}
