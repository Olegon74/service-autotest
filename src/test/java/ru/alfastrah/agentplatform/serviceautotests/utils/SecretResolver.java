package ru.alfastrah.agentplatform.serviceautotests.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public final class SecretResolver {
    private static final String PREFIX = "ENC(";
    private static final String SUFFIX = ")";

    private SecretResolver() {
    }

    public static String resolve(String value) {
        if (value == null || !value.startsWith(PREFIX) || !value.endsWith(SUFFIX)) {
            return value;
        }

        String password = System.getProperty("jasypt.encryptor.password");
        if (password == null || password.isBlank()) {
            return value;
        }

        String encrypted = value.substring(PREFIX.length(), value.length() - SUFFIX.length());
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(password);
        return encryptor.decrypt(encrypted);
    }
}
