package mod3;

import java.io.Serializable;

import static java.lang.String.join;

public class Course<hobby> implements Serializable {
    private int age;
    private String hobby;
    private String name;
    private String login;

    public Course(String name, String login, int age, String hobby) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobby = hobby;
    }

    public String toString() {
        return "Пользователь: " + name + " c логином: " + login + ". Его возраст: " + age + ". Все хобби: \n" + String.join("\n", hobby.split(", "));

    }
}
