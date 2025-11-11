package dao;

import java.sql.Date;
import java.util.List;

import bean.Schedule;   // ★ここが重要！ model ではなく bean にする

public interface ScheduleDao {
    Schedule findById(int userNum, Date date);
    List<Schedule> findAll();
    void insert(Schedule schedule);
    void update(Schedule schedule);
    void delete(int userNum, Date date);
}
