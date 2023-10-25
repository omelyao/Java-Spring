import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        DB db = new DB();
        try {
            //db.insertToOrders();
            db.getOrders();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}