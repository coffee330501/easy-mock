import io.github.coffee330501.MockManager;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args)  {
        // turn on mock,look TestProxy for details
        MockManager.turnOnMock();

        // mock in proxy
        Dog dog = new Dog();
        DogService dogProxy = (DogService) Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), new TestProxy(dog));
        System.out.println(dogProxy.getAge());
        System.out.println(dogProxy.getId());

        // custom mock
        MockManager.registerMockProcessor(MockStrategiesExtend.MY_STRING, MockStrategiesExtend.STRING_MOCK);
        System.out.println(dogProxy.getName());
    }


}
