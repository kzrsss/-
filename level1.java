package domain;

import java.lang.reflect.Method;

class Person{
public Person(){}

public void eat(){
    System.out.println("HelloWorld");
}
}
public class level1 {
    public static void main(String[] args) throws Exception{
        /*Class cls1=Class.forName("domain.HelloWorld");
        System.out.println(cls1);*/
        Class personClass= Person.class;
        Method eat_method=personClass.getMethod("eat");
        Person p=new Person();
        eat_method.invoke(p);
    }
}
