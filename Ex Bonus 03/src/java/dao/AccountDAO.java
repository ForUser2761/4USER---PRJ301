/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends DBContext{
    
    
    public Account getAccountByUsernameAndPassword(String username ,String password ) {
        //- connect with DB
        connection = new DBContext().connection;
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "where txtUser = ? and [txtPassword] = ?";
        try {
            //- Tạo đối tượng PrepareStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            statement.setObject(1, username);
            statement.setObject(2, password);
            //- Thực thi câu lệnh
            ResultSet resultSet = statement.executeQuery();
            //- trả về kết quả
            if (resultSet.next()) {
                String username_Found = resultSet.getString("txtUser").trim();
                String password_Found = resultSet.getString("txtPassword").trim();
                Account account = new Account(username_Found, password_Found);
                return account;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new AccountDAO().getAccountByUsernameAndPassword("xyz", "123"));
    }
}
