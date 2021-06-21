package connection;

import java.sql.*;

public class Connector {
    private static Connection connect;
    public static Connection getConnect()
    {
        if(connect == null)
        {
            try {
                String url="jdbc:mysql://localhost/java_responsi";
                String username= "root";     
                String password= "";         
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
            }
        }
        return connect;
    }
}

