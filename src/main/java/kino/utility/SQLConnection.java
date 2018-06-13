package kino.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dave on 14/03/2017.
 */

public class SQLConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_USER = "sql11163745";
    private static final String DB_PASSWORD = "RuWhCUG8xz";
    private static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11163745";

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection != null) {
          return connection;

        }
        else {
            try {
                Class.forName(JDBC_DRIVER);

                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
            catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            catch (ClassNotFoundException ex2) {
                ex2.printStackTrace();
            }
        }
        return connection;
    }

}
