/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author nnkha
 */
public class AccountDAO extends DBContext {

    public Account findByUserNamePassword(String username, String password) {
        //connect DB
        connection = getConnection();
        // Cbi cau lenh SQL
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "where username = ? and [password] = ?";
        try {
            //tao doi tuong PreperedStatement
            statement = connection.prepareStatement(sql);
            //set Parameter(optional)
            statement.setObject(1, username);
            statement.setObject(2, password);
            // Thuc thi cau lenh
            resultSet = statement.executeQuery();
            // tra ve ket qua
            while(resultSet.next()){
                String username_found = resultSet.getString("username").trim();
                String password_found = resultSet.getString("password").trim();

                Account account = new Account(username, password);
                return account;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
//    public static void main(String[] args) {
//        System.out.println(new AccountDAO().findByUserNamePassword("khanh", "12345"));
//    }
        public Account CheckAccount(String user) {
        //connect DB
        connection = getConnection();
        // Cbi cau lenh SQL
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "where [username] = ?";
        try {
            //tao doi tuong PreperedStatement
            statement = connection.prepareStatement(sql);
            //set Parameter(optional)
            statement.setObject(1, user);
            // Thuc thi cau lenh
            resultSet = statement.executeQuery();
            // tra ve ket qua
            while(resultSet.next()){
                String username_found = resultSet.getString("username").trim();
                Account account = new Account(username_found);
                return account;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
        public void SignUp(String user, String pass){
            String sql = "INSERT INTO ACCOUNT VALUES(?,?)";
            try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, user);
            statement.setObject(2, pass);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        }

}
