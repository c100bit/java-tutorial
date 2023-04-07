package org.example.part2.reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person(1, "name");
        Class personClass2 = person.getClass();
        Class personClass = Person.class;
        Class personClass3 = Class.forName("org.example.part2.reflections.Person");

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.getReturnType() + " " + Arrays.toString(method.getParameterTypes()));
        }

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println(annotation);
            }
        }
    }

}
