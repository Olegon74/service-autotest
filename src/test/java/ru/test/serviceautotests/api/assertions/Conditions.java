package ru.test.serviceautotests.api.assertions;

import org.junit.jupiter.api.Assertions;

public final class Conditions {
    private Conditions() {
    }

    public static Condition hasStatusCode(int expectedStatusCode) {
        return response -> Assertions.assertEquals(
                expectedStatusCode,
                response.statusCode(),
                "Unexpected status code"
        );
    }
}
