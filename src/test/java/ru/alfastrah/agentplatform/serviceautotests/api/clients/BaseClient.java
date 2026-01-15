package ru.alfastrah.agentplatform.serviceautotests.api.clients;

import ru.alfastrah.agentplatform.serviceautotests.api.clients.auth.AuthClient;
import ru.alfastrah.agentplatform.serviceautotests.config.ConfigLoader;
import ru.alfastrah.agentplatform.serviceautotests.config.TestConfig;

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
