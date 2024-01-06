import io.github.coffee330501.Mock;
import io.github.coffee330501.MockManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy implements InvocationHandler {
    private final Object target;

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> clazz = target.getClass();
        Mock mockAnno = clazz.getMethod(method.getName()).getAnnotation(Mock.class);
        if (mockAnno == null) return method.invoke(target, args);

        // mock
        String mockType = mockAnno.value();
        if (mockType == null || mockType.length() == 0) {
            mockType = method.getReturnType().getName();
        }
        return MockManager.mock(mockType, args);
    }
}