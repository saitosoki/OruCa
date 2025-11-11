package dao;  // ★ DAOクラスなので dao パッケージに所属！

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Schedule;  // ★ Schedule は bean パッケージから

public class ScheduleDaoImpl implements ScheduleDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/oruca_db";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Schedule findById(int userNum, Date date) {
        String sql = "SELECT user_num, date, comment FROM schedule WHERE user_num = ? AND date = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userNum);
            ps.setDate(2, date);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Schedule(rs.getInt("user_num"), rs.getDate("date"), rs.getString("comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Schedule> findAll() {
        List<Schedule> list = new ArrayList<>();
        String sql = "SELECT user_num, date, comment FROM schedule ORDER BY date DESC";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Schedule(rs.getInt("user_num"), rs.getDate("date"), rs.getString("comment")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Schedule schedule) {
        String sql = "INSERT INTO schedule (user_num, date, comment) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, schedule.getUserNum());
            ps.setDate(2, schedule.getDate());
            ps.setString(3, schedule.getComment());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Schedule schedule) {
        String sql = "UPDATE schedule SET comment = ? WHERE user_num = ? AND date = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schedule.getComment());
            ps.setInt(2, schedule.getUserNum());
            ps.setDate(3, schedule.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int userNum, Date date) {
        String sql = "DELETE FROM schedule WHERE user_num = ? AND date = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userNum);
            ps.setDate(2, date);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

