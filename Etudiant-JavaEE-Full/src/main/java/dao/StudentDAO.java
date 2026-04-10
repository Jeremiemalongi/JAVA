package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO Students(Name, Course, Fee, PhotoPath, Email) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setBigDecimal(3, s.getFee());
            ps.setString(4, s.getPhotoPath());
            ps.setString(5, s.getEmail());

            ps.executeUpdate();
        }
    }

    public void update(Student s) throws SQLException {
        String sql = "UPDATE Students SET Name=?, Course=?, Fee=?, PhotoPath=?, Email=? WHERE Id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setBigDecimal(3, s.getFee());
            ps.setString(4, s.getPhotoPath());
            ps.setString(5, s.getEmail());
            ps.setInt(6, s.getId());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Students WHERE Id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Student findById(int id) throws SQLException {
        String sql = "SELECT Id, Name, Course, Fee, PhotoPath, Email FROM Students WHERE Id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("Id"));
                    s.setName(rs.getString("Name"));
                    s.setCourse(rs.getString("Course"));
                    s.setFee(rs.getBigDecimal("Fee"));
                    s.setPhotoPath(rs.getString("PhotoPath"));
                    s.setEmail(rs.getString("Email"));
                    return s;
                }
            }
        }
        return null;
    }

    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT Id, Name, Course, Fee, PhotoPath, Email FROM Students ORDER BY Id DESC";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("Id"));
                s.setName(rs.getString("Name"));
                s.setCourse(rs.getString("Course"));
                s.setFee(rs.getBigDecimal("Fee"));
                s.setPhotoPath(rs.getString("PhotoPath"));
                s.setEmail(rs.getString("Email"));
                list.add(s);
            }
        }
        return list;
    }
}
