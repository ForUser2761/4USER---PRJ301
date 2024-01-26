/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    public List<Product> findAll() {
        List<Product> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnection();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM [dbo].[Product]";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                String name = resultSet.getString("name").trim();
                double price = resultSet.getDouble("price");
                Product product = new Product(id, name, quantity, price);

                listFound.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }

    public List<Product> findByName(String keyword) {
        List<Product> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnection();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM [dbo].[Product] where name like ?";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            statement.setString(1, "%" + keyword + "%");
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                String name = resultSet.getString("name").trim();
                double price = resultSet.getDouble("price");
                Product product = new Product(id, name, quantity, price);

                listFound.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }
}
