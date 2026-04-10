package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // retourne le role si login OK, sinon null
    public String login(String username, String password) {

        String sql = "SELECT Role FROM Users "
                   + "WHERE LTRIM(RTRIM(Username)) = ? AND Password = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username.trim());
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("Role"); // ADMIN / USER
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
