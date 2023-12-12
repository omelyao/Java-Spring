package mod2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Капитанская дочка")
    private String name;

    @Value("А.С. Пушкин")
    private String author;

    @Value("1836")
    private int year;

    public String getName() {

        return name;
    }

    public String getAuthor() {

        return author;
    }

    public int getYear() {

        return year;
    }
}
