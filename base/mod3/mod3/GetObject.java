package mod3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetObject {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("main.omelio");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Course objects = (Course) ois.readObject();
            //Course kotlin = (Course) ois.readObject();

            System.out.println((objects));
            //System.out.println(kotlin);
            ois.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
