/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import model.Coaches;

/**
 *
 * @author ADMIN
 */
public class CoachDAO extends GenericDAO<Coaches> {

    @Override
    public List<Coaches> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Coaches t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        System.out.println(new CoachDAO().findAll());
    }

    public Coaches findByID(String id) {
        String sql = "SELECT *\n"
                + "  FROM [Coaches]\n"
                + "  where CoachID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("vcxvxc", id);
        List<Coaches> list = queryGenericDAO(sql);
        return list.isEmpty() ? null : list.get(0);
    }

}
