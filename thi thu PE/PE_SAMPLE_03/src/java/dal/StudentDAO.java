/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Students;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class StudentDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Students> findBySBID(String subjectId) {
        List<Students> list = new ArrayList<>();
        try {
            //tao ra ket noi
            connection = new DBContext().connection;

            //chuan bi cau lenh sql
            String sql = "SELECT *\n"
                    + "  FROM [Students]\n"
                    + "  where SubjectID = ? ";
            statement = connection.prepareStatement(sql);
            //set parameter
            statement.setObject(1, subjectId);

            //thuc thi cau lenh
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String StudentID = resultSet.getString("StudentID");
                String StudentName = resultSet.getString("StudentName");
                Date BirthDate = resultSet.getDate("BirthDate");
                boolean Gender = resultSet.getBoolean("Gender");
                String SubjectID = resultSet.getString("SubjectID");

                Students obj = new Students();
                obj.setStudentID(StudentID);
                obj.setStudentName(StudentName);
                obj.setBirthDate(BirthDate);
                obj.setGender(Gender);
                obj.setSubjectID(SubjectID);
                //add vao trong list
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(String id) {
        try {
            //tao ra ket noi
            connection = new DBContext().connection;

            //chuan bi cau lenh sql
            String sql = "DELETE FROM [dbo].[Students]\n"
                    + "      WHERE StudentID = ?";
            statement = connection.prepareStatement(sql);
            //set parameter
            statement.setObject(1, id);

            //thuc thi cau lenh
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
