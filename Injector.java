package javalr_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector<T> {
    
    private Properties properties;
    
    Injector(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(path)));
    }

    public <T> T inject(T object) throws IOException, IllegalAccessException, InstantiationException{
       Class<? extends Object> class1 = object.getClass();
       Class relate;
       Field[] fl = class1.getDeclaredFields();
       for(Field f: fl){
            Annotation a = f.getAnnotation(AutoInjectable.class);
            f.setAccessible(true);
            if (a!=null){
                String[] fType = f.getType().toString().split(" ");
                String equalName = properties.getProperty(fType[1], null);
                if (equalName != null){
                    try {
                        relate = Class.forName(equalName);
                    } catch (ClassNotFoundException e){
                        System.out.println("No class for " + equalName);
                        continue;
                    }
                    f.set(object, relate.newInstance());
                }
                else
                    System.out.println("No properties for field type " + fType[1]);
            }
        }
        return object;
    }    
}
    

