package mod3;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String login;
        int age;
        String hobby;

        System.out.println("Введите имя: ");
        name = scanner.nextLine();
        System.out.println("Введите логин: ");
        login =(scanner.nextLine());
        System.out.println("Введите возраст: ");
        age = (scanner.nextInt());
        System.out.println("Введите хобби через запятую: ");
        hobby = (scanner.nextLine());
        hobby = (scanner.nextLine());

        Course objects =
                new Course(name, login,age, hobby);


        try {
            FileOutputStream fos = new FileOutputStream("main.omelio");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(objects);
            //oos.writeObject(kotlin);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
