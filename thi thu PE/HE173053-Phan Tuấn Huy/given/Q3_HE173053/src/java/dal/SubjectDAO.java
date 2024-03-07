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
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class SubjectDAO extends DBContext{
    public List<Subject> getAll() {
        List<Subject> list = new ArrayList<>();
        String sql = "select*from Subjects";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getString(1), rs.getString(2));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public static void main(String[] args) {
        SubjectDAO sjd = new SubjectDAO();
        List<Subject> li = sjd.getAll();
        System.out.println(li.get(0).getSubid());
    }
    
}
