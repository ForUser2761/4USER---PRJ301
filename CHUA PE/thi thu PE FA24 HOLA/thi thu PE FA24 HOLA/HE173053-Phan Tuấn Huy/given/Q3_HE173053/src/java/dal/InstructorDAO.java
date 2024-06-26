/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Instructor;

/**
 *
 * @author ADMIN
 */
public class InstructorDAO extends DBContext {

    public List<Instructor> getAll() {
        List<Instructor> list = new ArrayList<>();
        String sql = "select * from Instructors";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Instructor s = new Instructor(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public static void main(String[] args) {
        InstructorDAO id = new InstructorDAO();
        List<Instructor> li = id.getAll();
        System.out.println(li.get(0).getInsid());
    }

}
