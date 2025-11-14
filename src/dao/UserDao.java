package dao;

import bean.User;

public interface UserDao {

    boolean insert(User user);

    User findByUserNum(Integer userNum);


    User findByLoginCredentials(Integer userNum, String password);

    boolean update(User user);

    boolean delete(Integer userNum);
}


