/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Teams;

/**
 *
 * @author ADMIN
 */
public class TeamDAo extends GenericDAO<Teams> {

    @Override
    public List<Teams> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Teams t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
