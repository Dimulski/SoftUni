package Problem1MethodSaysHello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodSaysHello {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Person.class.getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Person person = new Person(name);
        person.sayHello();
    }
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void sayHello() {
        System.out.println(String.format("%s says \"Hello\"!", this.name));
    }
}
