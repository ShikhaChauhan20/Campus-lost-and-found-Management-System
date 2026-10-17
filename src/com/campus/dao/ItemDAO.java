package com.campus.dao;
import com.campus.connection.DBConnection;
import com.campus.model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ItemDAO {
	public boolean addItem(String name, String category, String desc, String loc, String status, int userId) {
        String query = "INSERT INTO items (item_name, category, description, location, status, user_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setString(3, desc);
            pst.setString(4, loc);
            pst.setString(5, status);
            pst.setInt(6, userId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String query = "SELECT * FROM items";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Item(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getString("description"),
                    rs.getString("location"),
                    rs.getString("status"),
                    rs.getInt("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Item> findPotentialMatches(String category, String keyword) {
        List<Item> list = new ArrayList<>();
        String query = "SELECT * FROM items WHERE category = ? AND (item_name LIKE ? OR description LIKE ?) AND status = 'FOUND'";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, category);
            pst.setString(2, "%" + keyword + "%");
            pst.setString(3, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Item(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getString("description"),
                    rs.getString("location"),
                    rs.getString("status"),
                    rs.getInt("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
