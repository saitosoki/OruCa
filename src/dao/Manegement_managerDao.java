package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Manegement_manager;
import utils.DBUtil;

public class Manegement_managerDao {

    // ユーザー一覧（部署番号と名前）を取得
    public List<Manegement_manager> findAll() {

        List<Manegement_manager> list = new ArrayList<>();

        // ★ 修正ポイント: 列名の間にカンマを追加、単語の間にスペースを追加
        String sql = "SELECT NAME, DEPARTMENT_NUM FROM USER ORDER BY DEPARTMENT_NUM, NAME";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

        	while (rs.next()) {
                String deptNum = rs.getString("DEPARTMENT_NUM");
                String name = rs.getString("NAME");

                // 修正：空のコンストラクタで作ってから、セッターで値を入れる
                Manegement_manager bean = new Manegement_manager();
                bean.setDepartmentNum(deptNum);
                bean.setName(name);

                list.add(bean);
            }

        } catch (SQLException e) {
            System.out.println("DEBUG: Manegement_managerDaoでエラーが発生しました");
            e.printStackTrace();
        }

        return list;
    }
}