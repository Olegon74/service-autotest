package ru.alfastrah.agentplatform.serviceautotests.config;

import org.aeonbits.owner.ConfigFactory;

public final class ConfigLoader {
    private static final TestConfig CONFIG;

    static {
        String env = System.getProperty("env", "dev");
        System.setProperty("env", env);
        CONFIG = ConfigFactory.create(TestConfig.class);
    }

    private ConfigLoader() {
    }

    public static TestConfig getConfig() {
        return CONFIG;
    }
}
