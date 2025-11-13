package dao;

import java.util.List;

import bean.boyacatch;

public interface BoyaCatchDao {
    boolean insert(boyacatch entry);
    boyacatch findByCompositeKey(int userId, java.sql.Date date);

    List<boyacatch> findByUserId(int userId);
    boolean update(boyacatch entry);

    boolean delete(int userId, java.sql.Date date);
}