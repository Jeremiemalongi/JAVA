package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO Students(Name, Course, Fee, Photo) VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setBigDecimal(3, s.getFee());
            ps.setString(4, s.getPhoto()); // ✅ peut être NULL

            ps.executeUpdate();
        }
    }

    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT Id, Name, Course, Fee, Photo FROM Students ORDER BY Id DESC";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("Id"));
                s.setName(rs.getString("Name"));
                s.setCourse(rs.getString("Course"));
                s.setFee(rs.getBigDecimal("Fee"));
                s.setPhoto(rs.getString("Photo")); // ✅
                list.add(s);
            }
        }
        return list;
    }

    public Student getById(int id) throws SQLException {
        String sql = "SELECT Id, Name, Course, Fee, Photo FROM Students WHERE Id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Course"),
                        rs.getBigDecimal("Fee"),
                        rs.getString("Photo")
                    );
                }
            }
        }
        return null;
    }

    public void update(Student s) throws SQLException {
        // ✅ update avec photo (si photo == null => garde l'ancienne)
        // Pour garder l'ancienne automatiquement, on fait 2 cas:
        if (s.getPhoto() == null || s.getPhoto().trim().isEmpty()) {
            String sql = "UPDATE Students SET Name=?, Course=?, Fee=? WHERE Id=?";
            try (Connection con = DBUtil.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, s.getName());
                ps.setString(2, s.getCourse());
                ps.setBigDecimal(3, s.getFee());
                ps.setInt(4, s.getId());
                ps.executeUpdate();
            }
        } else {
            String sql = "UPDATE Students SET Name=?, Course=?, Fee=?, Photo=? WHERE Id=?";
            try (Connection con = DBUtil.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, s.getName());
                ps.setString(2, s.getCourse());
                ps.setBigDecimal(3, s.getFee());
                ps.setString(4, s.getPhoto());
                ps.setInt(5, s.getId());
                ps.executeUpdate();
            }
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Students WHERE Id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

