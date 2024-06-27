/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.model.tblUsers;
import pe.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends DBUtils {

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public tblUsers findByUserIdAndPassword(String userId, String password) {
        try {

            //tao ket noi DB
            connection = DBUtils.getConnection();
            //chuan bi cau lenh
            String sql = "SELECT *\n"
                    + "  FROM tblUsers\n"
                    + "where [userID] = ? and [password] = ?";
            //chuan bi prepared statement
            statement = connection.prepareStatement(sql);
            //set parameter neu co 
            statement.setObject(1, userId);
            statement.setObject(2, password);
            //tra ve du lieu
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tblUsers user = new tblUsers();
                user.setUserID(resultSet.getString("userID"));
                user.setFullName(resultSet.getString("fullName"));
                user.setRoleID(resultSet.getString("roleID"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng kết nối và các tài nguyên
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.err.println("4USER: Bắn Exception ở hàm query: " + e.getMessage());
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new UserDAO().findByUserIdAndPassword("12312321312", "1"));
    }
}
