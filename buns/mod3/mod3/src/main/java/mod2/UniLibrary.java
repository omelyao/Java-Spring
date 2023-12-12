package mod2;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {
    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary " + book.getName());
        System.out.println("-------------------------------------------------");
    }

    public void getJournal() {
        System.out.println("Мы берем журнал из UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public void returnBook() {

        System.out.println("Мы возвращаем книгу в UniLibrary ");
    }

    public void returnJournal() {
        System.out.println("Мы возвращаем журнал в UniLibrary ");
    }

}
