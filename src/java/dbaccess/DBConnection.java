package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    public static String USER = "javapopulater";
    public static String USERPW = "dejligtlangt$82verylong";
    public static String DBNAME = "buildings01";
    public static String HOST = "46.101.253.149";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, USER, USERPW);
    }
}
