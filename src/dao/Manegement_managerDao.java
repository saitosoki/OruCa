package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Manegement_manager;   // ← ここが重要！
import utils.DBUtil;

public class Manegement_managerDao {

    // 部署 + 部下一覧を取得
    public List<Manegement_manager> findAll() {

        List<Manegement_manager> list = new ArrayList<>();

        String sql = "SELECT "
                   + "d.dept_id, "
                   + "d.dept_name, "
                   + "s.sub_id, "
                   + "s.sub_name "
                   + "FROM department d "
                   + "JOIN subordinate s "
                   + "ON d.dept_id = s.dept_id "
                   + "ORDER BY d.dept_id, s.sub_id";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int deptId = rs.getInt("dept_id");
                String deptName = rs.getString("dept_name");

                int subId = rs.getInt("sub_id");
                String subName = rs.getString("sub_name");

                // あなたの Bean に合わせて生成
                Manegement_manager bean =
                    new Manegement_manager(deptId, deptName, subId, subName);

                list.add(bean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
