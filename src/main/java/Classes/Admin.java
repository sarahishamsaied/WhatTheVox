package Classes;

public class Admin extends Person{
    String adminLoginId;
    String adminPassword;

    public Admin() {
        adminLoginId = "admin";
        adminPassword = "00000000";
    }

    public String getAdminLoginId() {
        return adminLoginId;
    }

    public void setAdminLoginId(String adminLoginId) {
        this.adminLoginId = adminLoginId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Admin(String adminLoginId, String adminPassword) {
        this.adminLoginId = adminLoginId;
        this.adminPassword = adminPassword;
    }

    public Admin(String name, int age, String adminLoginId, String adminPassword) {
        super(name, age);
        this.adminLoginId = adminLoginId;
        this.adminPassword = adminPassword;
    }
    public Admin(String name, int age, String adminLoginId) {
        super(name, age);
        this.adminLoginId = adminLoginId;
    }
}
