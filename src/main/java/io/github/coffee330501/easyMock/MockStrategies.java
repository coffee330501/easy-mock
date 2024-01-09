package io.github.coffee330501.easyMock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class MockStrategies {
    public static final String LONG = "java.lang.Long";
    public static final String STRING = "java.lang.String";
    public static final String INTEGER = "java.lang.Integer";

    static MockStrategy<String> STRING_MOCK = param -> UUID.randomUUID().toString();
    static MockStrategy<Integer> INTEGER_MOCK = param -> ThreadLocalRandom.current().nextInt(0, 999999);
    static MockStrategy<Long> LONG_MOCK = param -> ThreadLocalRandom.current().nextLong(0L, 9999999999L);
    static MockStrategy<BigDecimal> BIG_DECIMAL_MOCK = param -> new BigDecimal(String.valueOf(Math.random() * 10000)).setScale(2, RoundingMode.DOWN);

    public static void main(String[] args) {
        System.out.println(LONG_MOCK.mock());
    }

}
