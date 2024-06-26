/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Instructors;

/**
 *
 * @author ADMIN
 */
public class InstructorDAO extends GenericDAO<Instructors>{

    @Override
    public List<Instructors> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Instructors t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        System.out.println(new InstructorDAO().findAll());
    }
    
}
