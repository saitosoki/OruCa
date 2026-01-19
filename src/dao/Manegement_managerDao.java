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

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
    public List<Manegement_manager> findAll() {

        List<Manegement_manager> list = new ArrayList<>();

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        String sql = "SELECT NAME, DEPARTMENT_NUM FROM USER ORDER BY DEPARTMENT_NUM, NAME";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

        	while (rs.next()) {
                String deptNum = rs.getString("DEPARTMENT_NUM");
                String name = rs.getString("NAME");

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
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