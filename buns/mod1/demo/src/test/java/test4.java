import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        //Dog myDog = context.getBean("myPet", Dog.class);
        //myDog.setName("Alma");
        //Dog yourDog = context.getBean("myPet", Dog.class);
        //yourDog.setName("strelka");
        //System.out.println("Переменные ссылаются на 1 обьект" + (myDog==yourDog));
        //System.out.println(myDog.getName());
        //System.out.println(yourDog.getName());
        context.close();

    }
}
