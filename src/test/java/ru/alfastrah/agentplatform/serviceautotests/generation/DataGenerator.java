package ru.alfastrah.agentplatform.serviceautotests.generation;

import java.util.List;
import java.util.Random;

public final class DataGenerator {
    private static final Random RANDOM = new Random();
    private static final String CYRILLIC_LETTERS = "абвгдежзийклмнопрстуфхцчшщьыъэюя";
    private static final String LATIN_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final List<String> PATHS = List.of(
            "/page/profile/",
            "/page/widget",
            "/page/journal",
            "/page/bluecard",
            "/page/gap",
            "page/osago",
            "/page/antimite",
            "/page/ns",
            "/page/feature/toggle"
    );

    private DataGenerator() {
    }

    public static String generateTitle() {
        return generateCyrillicText(5, 20);
    }

    public static String generateSubtitle() {
        return generateCyrillicText(5, 20);
    }

    public static String generateNumber() {
        String letters = generateLatinText(2, 4);
        String digits = String.valueOf(100 + RANDOM.nextInt(900));
        return letters + "-" + digits;
    }

    public static String generatePath() {
        return PATHS.get(RANDOM.nextInt(PATHS.size()));
    }

    public static <T extends Enum<T>> T getRandomEnum(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        return values[RANDOM.nextInt(values.length)];
    }

    private static String generateCyrillicText(int min, int max) {
        int length = RANDOM.nextInt(max - min + 1) + min;
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(CYRILLIC_LETTERS.charAt(RANDOM.nextInt(CYRILLIC_LETTERS.length())));
        }
        return capitalize(builder.toString());
    }

    private static String generateLatinText(int min, int max) {
        int length = RANDOM.nextInt(max - min + 1) + min;
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(LATIN_LETTERS.charAt(RANDOM.nextInt(LATIN_LETTERS.length())));
        }
        return builder.toString();
    }

    private static String capitalize(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
