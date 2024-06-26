
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;


public class ProductDAO extends DBContext{
        public List<Product> findALl() {
        List<Product> listFound = new ArrayList<>();

        //connect DB
        connection = getConnection();
        // Cbi cau lenh SQL
        String sql = "SELECT * FROM [dbo].[Product] " ;
        try {
            //tao doi tuong PreperedStatement
            statement = connection.prepareStatement(sql);
            //set Parameter(optional)
            // Thuc thi cau lenh
            resultSet = statement.executeQuery();
            // tra ve ket qua
            while (resultSet.next()) {        
                String SKU = resultSet.getString("SKU").trim();
                String name = resultSet.getString("Name").trim();
                String description = resultSet.getString("Description");
                double price = resultSet.getDouble("Price");
                int quantity = resultSet.getInt("Quantity");
                
                Product product = new Product(SKU, name, price, description, quantity);
                listFound.add(product);     
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;

    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().findByUserNamePassword("khanh", "12345"));
    }
}
