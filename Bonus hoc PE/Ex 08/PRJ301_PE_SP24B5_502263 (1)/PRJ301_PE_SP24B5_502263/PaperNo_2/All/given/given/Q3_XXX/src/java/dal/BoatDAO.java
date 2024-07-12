/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Boats;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BoatDAO extends GenericDAO<Boats> {

    @Override
    public List<Boats> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Boats t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Boats> findById(String departId) {
        String sql = "SELECT *\n"
                + "  FROM [Boats]\n"
                + "  where DepartPlaceID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", departId);
        return queryGenericDAO(sql);
    }

}
