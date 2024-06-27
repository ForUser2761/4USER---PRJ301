/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.model.tblFashion;
import pe.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class FashionDAO extends DBUtils {

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public List<tblFashion> findByProp(String prop, Object object) {
        String sql = "SELECT *\n"
                + "  FROM [tblFashion]\n"
                + "  where " + prop + " like ?";
        List<tblFashion> list = new ArrayList<>();
        try {
            //tao ket noi DB
            connection = DBUtils.getConnection();

            //chuan bi prepared statement
            statement = connection.prepareStatement(sql);
            //set parameter neu co 
            statement.setObject(1, "%" + object + "%");
            //tra ve du lieu
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tblFashion painting = new tblFashion();
                painting.setId(resultSet.getString("id"));
                painting.setName(resultSet.getString("name"));
                painting.setDescription(resultSet.getString("description"));
                painting.setSize(resultSet.getString("size"));
                painting.setPrice(resultSet.getFloat("price"));
                painting.setStatus(resultSet.getBoolean("status"));
                list.add(painting);
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
        return list;
    }

    public static void main(String[] args) {
        new FashionDAO().updateProp("creator", "FPT 3");
    }

    public void updateProp(String prop, Object object) {
        String sql = "UPDATE [tblFashion]\n"
                + "   SET \n"
                + "      [status] = 0\n"
                + " WHERE " + prop + " = ?";
        List<tblFashion> list = new ArrayList<>();
        try {
            //tao ket noi DB
            connection = DBUtils.getConnection();

            //chuan bi prepared statement
            statement = connection.prepareStatement(sql);
            //set parameter neu co 
            statement.setObject(1, object);
            //tra ve du lieu
            statement.executeUpdate();

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
    }

}
