package models;

import java.sql.*;

public class MyConnection {
    static private final String url="jdbc:mysql://localhost:3306/management_training_center_db";
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "Eya1996@+=");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        MyConnection.connection = connection;
    }

    public static Statement getStatement() throws SQLException {return connection.createStatement(); }

    public ResultSet executeGetQuery(String query) throws SQLException {
        if (query.contains("SELECT")){
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }
        return null;
    }

    public static int executeCreateQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        statement.close();
        return result;
    }

    public static int executeUpdateQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(query);
        statement.close();
        return result;
    }
}
