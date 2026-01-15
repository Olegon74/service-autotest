package ru.test.serviceautotests.api.clients;

import ru.test.serviceautotests.api.clients.auth.AuthClient;
import ru.test.serviceautotests.config.ConfigLoader;
import ru.test.serviceautotests.config.TestConfig;

public abstract class BaseClient {
    protected final TestConfig config;
    protected final String baseUrl;
    protected final String accessToken;

    protected BaseClient() {
        this.config = ConfigLoader.getConfig();
        this.baseUrl = config.testUrl();
        this.accessToken = new AuthClient().getAccessToken();
    }
}
