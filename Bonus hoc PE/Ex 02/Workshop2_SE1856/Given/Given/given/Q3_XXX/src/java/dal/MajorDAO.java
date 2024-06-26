/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author ADMIN
 */
import entity.Major;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MajorDAO {
    private final DBContext dbContext = new DBContext();

    // Get all majors from the database
    public List<Major> getAllMajors() {
        List<Major> majors = new ArrayList<>();
        String query = "SELECT MajorID, MajorName FROM Major";
        try (Connection conn = new DBContext().connection;
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("MajorID");
                String name = rs.getString("MajorName");
                majors.add(new Major(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majors;
    }

    // Get major by ID
    public Major getMajorById(int majorID) {
        String query = "SELECT MajorID, MajorName FROM Major WHERE MajorID = ?";
        try (Connection conn = new DBContext().connection;
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, majorID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("MajorID");
                    String name = rs.getString("MajorName");
                    return new Major(id, name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Add a new major
    public boolean addMajor(Major major) {
        String query = "INSERT INTO Major (MajorName) VALUES (?)";
        try (Connection conn = new DBContext().connection;
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, major.getMajorName());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an existing major
    public boolean updateMajor(Major major) {
        String query = "UPDATE Major SET MajorName = ? WHERE MajorID = ?";
        try (Connection conn = new DBContext().connection;
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, major.getMajorName());
            ps.setInt(2, major.getMajorID());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a major by ID
    public boolean deleteMajor(int majorID) {
        String query = "DELETE FROM Major WHERE MajorID = ?";
        try (Connection conn = new DBContext().connection;
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, majorID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
