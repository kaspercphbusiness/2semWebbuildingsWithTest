package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
The purpose of this class is to provide a database connection to the database.

- line oen
- line two

A single @see {@link DBConnection#getConnection()} returns the connection
*/
public final class DBConnection {

    private static String USER = "javapopulater";
    private static String USERPW = "dejligtlangt$82verylong";
    private static String DBNAME = "buildings01";
    private static String HOST = "46.101.253.149";

    /**
     * 
     * @return a connection or null
     */
    public static Connection getConnection(){
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection(url, USER, USERPW);
        } catch ( ClassNotFoundException | SQLException ex ) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );;
        }
        return null;
    }
}
