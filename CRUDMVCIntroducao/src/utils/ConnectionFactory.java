

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author internet
 */

public class ConnectionFactory {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/crud_mvc";

    /**
     * Connection to Oracle:
     * private final String driver = "oracle.jdbc.driver.OracleDriver";
     * private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
     */
    
    private final String usuario = "root";
    private final String senha = "";

    private static ConnectionFactory connectionFactory = null;

   /**
    * Performs the configuration for the connection.
    * @throws SQLException - In case of database error.
    */
    
    private ConnectionFactory() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("driver");
        }
    }

   /**
     * Make the connection, if successful.
     * @return Connection
     * @throws SQLException - In case of database error.
     */
    
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new SQLException(String.valueOf(e.getErrorCode()));
        }
        return conn;
    }

  /**
     * Return an instance from connection to use.
     * @return Connection
     * @throws SQLException - In case of database error.
     */
    
    public static ConnectionFactory getInstance() throws SQLException {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}    

