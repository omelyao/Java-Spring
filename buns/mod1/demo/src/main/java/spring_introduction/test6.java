package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);

        //Pet cat1 = context.getBean("catBean", Pet.class);
        //Pet cat2 = context.getBean("catBean", Pet.class);
        System.out.println(person.getSurname());
        System.out.println(person.getAge());
        person.callYourPet();

        context.close();
    }
}
