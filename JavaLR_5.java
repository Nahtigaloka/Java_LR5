package javalr_5;
import java.io.IOException;

public class JavaLR_5 {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException{
        SomeBean sb = (new Injector<SomeBean>("src/javalr_5/beanProperties.properties").inject(new SomeBean()));
        sb.foo();
    }
    
}
