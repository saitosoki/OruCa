package bean;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String email;
    private Integer departmentNum;
    private Integer userNum;
    private String password;


    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getDepartmentNum() {
        return departmentNum;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartmentNum(Integer departmentNum) {
        this.departmentNum = departmentNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}