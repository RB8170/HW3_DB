
// === OwnerDAO.java ===
import java.sql.*;

public class OwnerDAO {
    public int addOwner(Owner owner) {
        String sql = "INSERT INTO Owner(name, phone) VALUES (?, ?) RETURNING id";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, owner.getName());
            stmt.setString(2, owner.getPhone());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
