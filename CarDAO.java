
// === CarDAO.java ===
import java.sql.*;
import java.util.*;

public class CarDAO {
    public void addCar(Car car) {
        String sql = "INSERT INTO Car(license_plate, model, color, parked, owner_id, parked_by_worker_code) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, car.getLicensePlate());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getColor());
            stmt.setBoolean(4, car.isParked());
            stmt.setInt(5, car.getOwnerId());
            stmt.setString(6, car.getParkedByWorkerCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllParkedCars() {
        List<String> cars = new ArrayList<>();
        String sql = "SELECT c.license_plate, c.model, o.name, c.parked_by_worker_code FROM Car c JOIN Owner o ON c.owner_id = o.id WHERE c.parked = true";
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cars.add(rs.getString("license_plate") + " - " + rs.getString("model") + " (Owner: " + rs.getString("name") + ", Worker: " + rs.getString("parked_by_worker_code") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void removeCar(String licensePlate) {
        String sql = "UPDATE Car SET parked = false WHERE license_plate = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, licensePlate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
