package ru.test.serviceautotests.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface TestConfig extends Config {
    @Key("test_url")
    String testUrl();

    @Key("keycloak_url")
    String keycloakUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("client_id")
    String clientId();

    @Key("client_secret")
    String clientSecret();

    @Key("grant_type")
    String grantType();
}
