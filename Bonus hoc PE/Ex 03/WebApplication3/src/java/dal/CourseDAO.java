/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import model.Courses;

/**
 *
 * @author ADMIN
 */
public class CourseDAO extends GenericDAO<Courses> {

    @Override
    public List<Courses> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Courses t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Courses> findsByInstructorId(String id) {
        //chuan bi ve cau lenh
        String sql = "select * from Courses\n"
                + "where ManageByInstructorID = ?";
        //chuan bi ve paramter map
        parameterMap = new LinkedHashMap<>();
        //set parameter( co the can) (optional)
        parameterMap.put("ManageByInstructorID", id);
        return queryGenericDAO(sql);
    }
    
    public static void main(String[] args) {
        System.out.println(new CourseDAO().findsByInstructorId("1"));
        
    }

}
