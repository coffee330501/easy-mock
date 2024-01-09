package io.github.coffee330501.easyMock;

import java.util.HashMap;
import java.util.Map;

public class MockManager {
    private static boolean USE_MOCK = false;
    private static final Map<String, MockStrategy<?>> processorMap = new HashMap<>();

    static {
        registerMockProcessor(MockStrategies.LONG, MockStrategies.LONG_MOCK);
        registerMockProcessor(MockStrategies.STRING, MockStrategies.STRING_MOCK);
        registerMockProcessor(MockStrategies.INTEGER, MockStrategies.INTEGER_MOCK);
        registerMockProcessor(MockStrategies.BIG_DECIMAL, MockStrategies.BIG_DECIMAL_MOCK);
    }

    public static void registerMockProcessor(String type, MockStrategy<?> processor) {
        processorMap.put(type, processor);
    }

    public static Object mock(String type, Object... param) {
        if (!USE_MOCK) throw new RuntimeException("mock has been turn off");

        MockStrategy<?> mockStrategy = processorMap.get(type);
        if (mockStrategy == null) throw new RuntimeException("mock strategy of type " + type + " is not exists");
        return mockStrategy.mock(param);
    }

    public static void turnOnMock() {
        USE_MOCK = true;
    }

    public static void turnOffMock() {
        USE_MOCK = false;
    }

    public static boolean isGlobalUseMock(){
        return USE_MOCK;
    }
}
