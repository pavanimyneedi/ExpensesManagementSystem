import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/simplegrocerymanagementsystem";
        private static final String USERNAME = "root";
        private static  final String PASSWORD = "";
        Connection connection = null;
        public Connection getConnection() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.getStackTrace();
                throw new SQLException("Failed to establish a database connection");
            }
            return connection;
        }
}
