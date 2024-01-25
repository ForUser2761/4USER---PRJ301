/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class DBContext {

    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    /**
     * get an connection
     *
     * @return connection or null
     * @throws ClassNotFoundException
     */
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=4USER_CRUD_WITH_DB";
            String user = "sa";
            String password = "12345678";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error " + e.getMessage() + " at DBContext");
            return null;
        }
    }

    public static void main(String[] args) {
        DBContext test = new DBContext();
        test.connection = test.getConnection();
        System.out.println(test.connection);
    }
}
