package javalr_5;

import reflection.SomeInterface;
import reflection.SomeOtherInterface;


class SomeBean {
  
    @AutoInjectable
    private SomeInterface Field1;
    @AutoInjectable
    private SomeOtherInterface Field2;

    public SomeBean() {}

    public void foo(){
        Field1.doSomething();
        Field2.doSomething();
    }
       
}