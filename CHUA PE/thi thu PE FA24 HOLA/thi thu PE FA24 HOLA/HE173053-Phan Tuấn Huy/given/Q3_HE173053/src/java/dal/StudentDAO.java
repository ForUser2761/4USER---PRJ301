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
import model.Student;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class StudentDAO extends DBContext {

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select*from Students inner join Subjects on Students.SubjectID=Subjects.SubjectID";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(7));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Student> getStudentBySubID(String id) {
        List<Student> list = new ArrayList<>();
        String sql = "select * from Students inner join Subjects on Students.SubjectID=Subjects.SubjectID where Students.SubjectID LIKE ?";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(7));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public Student getStudentByID(String id) {
        String sql = "select * from Students inner join Subjects on Students.SubjectID=Subjects.SubjectID where Students.StudentID LIKE ?";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student s = new Student(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(7));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        StudentDAO sd = new StudentDAO();
        List<Student> li = sd.getAll();
        System.out.println(li.get(0).getStid());
    }

}
