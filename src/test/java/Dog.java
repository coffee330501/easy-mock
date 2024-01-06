import io.github.coffee330501.Mock;
import io.github.coffee330501.MockStrategies;

public class Dog implements DogService {
    private int age;
    private String id;
    private String name;

    @Override
    @Mock(MockStrategies.INTEGER)
    public int getAge() {
        return age;
    }

    @Override
    @Mock
    public String getId() {
        return id;
    }

    @Mock(MockStrategiesExtend.MY_STRING)
    public String getName() {
        return name;
    }
}
