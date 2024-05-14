/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import model.Customers;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO extends GenericDAO<Customers> {

    @Override
    public List<Customers> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Customers t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        for (Customers customers : new CustomerDAO().findAll()) {
            System.out.println(customers);
        }
    }

    public void deleteByID(String id) {
        String sql = "DELETE FROM [dbo].[Customers]\n"
                + "      WHERE CustomerID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", id);
        deleteGenericDAO(sql);
    }

    public List<Customers> findByName(String name) {
        String sql = "SELECT *\n"
                + "  FROM [Customers]\n"
                + "  where CustomerName like ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", "%" + name + "%");
        return queryGenericDAO(sql);
    }

}
