package action;
import java.io.Serializable;

public class LoginAction implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String login;
    private String password;
    private String name;
    private String departmentNum;

    public int getId() { return id; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getDepartmentNum() { return departmentNum; }

    public void setId(int id) { this.id = id; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String name) { this.name = name; }
    public void setDepartmentNum(String departmentNum) { this.departmentNum = departmentNum; }
}