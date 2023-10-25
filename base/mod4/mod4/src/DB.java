import java.sql.*;
import java.util.ArrayList;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connstr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.jdbc.Driver");

        dbConn = DriverManager.getConnection(connstr, LOGIN, PASS);
        return dbConn;
    }

    private ResultSet statementToCreate(String query) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        return statement.executeQuery(query);
    }

    public void insertToOrders() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> userID = new ArrayList<>();
        ArrayList<Integer> itemID = new ArrayList<>();

        ResultSet user = statementToCreate("SELECT * FROM users WHERE `login` = 'john'");

        while (user.next()) {
            userID.add(user.getInt("id"));
        }

        ResultSet item = statementToCreate("SELECT * FROM items WHERE `category` = 'hats'");

        while (item.next()) {
            itemID.add(item.getInt("id"));
        }


        if (userID.size() < itemID.size()) {
            for (int i = 1; i < itemID.size(); i++) {
                userID.add(userID.get(userID.size() - 1));
            }
        }

        for (int i = 0; i < itemID.size(); i++) {
            int currentUserID = userID.get(i);
            int currentItemID = itemID.get(i);

            PreparedStatement prSt = getDbConnection().prepareStatement("INSERT INTO `orders` (user_id, item_id) VALUES (?, ?)");
            prSt.setInt(1, currentUserID);
            prSt.setInt(2, currentItemID);

            prSt.executeUpdate();
        }
    }

    public void getOrders() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> usersOrders = new ArrayList<>();
        ArrayList<Integer> itemsOrders = new ArrayList<>();

        ResultSet orderSelection = statementToCreate("SELECT * FROM `orders`");

        while (orderSelection.next()) {
            usersOrders.add(orderSelection.getInt("user_id"));
            itemsOrders.add(orderSelection.getInt("item_id"));
        }

        System.out.println("Все заказы:\n");

        for (int i = 0; i < itemsOrders.size(); i++) {
            PreparedStatement userStatement = getDbConnection().prepareStatement("SELECT login FROM `users` WHERE id = (?)");
            userStatement.setInt(1, usersOrders.get(i));
            ResultSet resultUser = userStatement.executeQuery();

            while (resultUser.next()) {
                System.out.print(resultUser.getString("login") + " – ");
            }

            PreparedStatement itemStatement = getDbConnection().prepareStatement("SELECT title FROM `items` WHERE id = (?)");
            itemStatement.setInt(1, itemsOrders.get(i));
            ResultSet resultItem = itemStatement.executeQuery();

            while (resultItem.next()) {
                System.out.println(resultItem.getString("title"));
            }

        }
    }
}

