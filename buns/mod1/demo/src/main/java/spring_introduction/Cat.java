package spring_introduction;

import org.springframework.stereotype.Component;
import spring_introduction.Pet;

//@Component("catBean")
public class Cat implements Pet {
    public Cat(){
        System.out.println("cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("meow-meow");
    }
}
