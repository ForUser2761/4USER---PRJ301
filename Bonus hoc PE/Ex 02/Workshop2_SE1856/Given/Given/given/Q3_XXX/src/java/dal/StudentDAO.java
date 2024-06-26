/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author ADMIN
 */
import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DBContext {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT s.StudentID, s.StudentName, s.BirthDate, s.Gender, m.MajorName "
                + "FROM Students s JOIN Major m ON s.MajorID = m.MajorID";
        try (Connection conn = new DBContext().connection; PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("StudentID");
                String name = rs.getString("StudentName");
                String dob = rs.getString("BirthDate");
                String gender = rs.getString("Gender");
                String major = rs.getString("MajorName");
                students.add(new Student(id, name, dob, gender, major));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(String studentId) {
        String query = "SELECT s.StudentID, s.StudentName, s.BirthDate, s.Gender, m.MajorName "
                + "FROM Students s JOIN Major m ON s.MajorID = m.MajorID "
                + "WHERE s.StudentID = ?";
        try (Connection conn = new DBContext().connection; PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString("StudentID");
                    String name = rs.getString("StudentName");
                    String dob = rs.getString("BirthDate");
                    String gender = rs.getString("Gender");
                    String major = rs.getString("MajorName");
                    return new Student(id, name, dob, gender, major);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentsByMajor(String majorName) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT s.StudentID, s.StudentName, s.BirthDate, s.Gender, m.MajorName "
                + "FROM Students s JOIN Major m ON s.MajorID = m.MajorID "
                + "WHERE m.MajorName = ?";
        try (Connection conn = new DBContext().connection; PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, majorName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("StudentID");
                    String name = rs.getString("StudentName");
                    String dob = rs.getString("BirthDate");
                    String gender = rs.getString("Gender");
                    String major = rs.getString("MajorName");
                    students.add(new Student(id, name, dob, gender, major));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
