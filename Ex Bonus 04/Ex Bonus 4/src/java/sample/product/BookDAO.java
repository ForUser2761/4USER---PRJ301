/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import sample.product.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtils;

/**
 *
 * @author Tony
 */
public class BookDAO {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;

    public boolean deleteBook(String id) {
        String sql = "DELETE FROM BookStore WHERE SKU = ?;";
        boolean response = true;

        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }

        return response;
    }

    public boolean updateBook(String id, float price, String name, String brand) {
        String sql = "UPDATE BookStore SET price = ?, brand = ?, name = ? WHERE id = ?;";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, brand);
            ps.setString(3, name);
            ps.setString(4, id);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }

    public List<BookDTO> getAllBook() {
        List<BookDTO> BookList = new ArrayList<BookDTO>();
        BookDTO product;
        String sql = "select * from BookStore";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new BookDTO(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("Description"),
                        rs.getInt("Quantity")
                );
                BookList.add(product);

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return BookList;
    }

    public List<BookDTO> getAllByIdAndName(String description) {
        List<BookDTO> BookList = new ArrayList<BookDTO>();
        BookDTO product;
        String sql = "SELECT * FROM BookStore WHERE name LIKE ?;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + description + '%');

            rs = ps.executeQuery();
            while (rs.next()) {
                product = new BookDTO(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("Description"),
                        rs.getInt("Quantity")
                );

                BookList.add(product);

            }
        } catch (Exception ex) {
        }

        return BookList;
    }

    public boolean createBook(BookDTO product) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO [BookStore]\n"
                + "           ([SKU]\n"
                + "           ,[Name]\n"
                + "           ,[Price]\n"
                + "           ,[Description]\n"
                + "           ,[Quantity])\n"
                + "     VALUES\n"
                + "           (?, ? , ? , ? , ?)";
        boolean response = false;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                ps = connection.prepareStatement(sql);
                ps.setString(1, product.getSKU().trim());
                ps.setString(2, product.getName());

                ps.setFloat(3, product.getPrice());
                ps.setString(4, product.getDescription());
                ps.setObject(4, product.getQuantity());
                response = ps.executeUpdate() > 0;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return response;
    }
}
