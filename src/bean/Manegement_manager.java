package bean;

public class Manegement_manager {
    private String name;
    private String email;
    private String departmentNum;
    private int id;

    public Manegement_manager() {}

    public Manegement_manager(String departmentNum, String name) {
        this.departmentNum = departmentNum;
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartmentNum() { return departmentNum; }
    public void setDepartmentNum(String departmentNum) { this.departmentNum = departmentNum; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserNum() { return id; }
    public void setUserNum(int userNum) { this.id = userNum; }
}