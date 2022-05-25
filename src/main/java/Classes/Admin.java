package Classes;

public class Admin extends Classes.Person{
    String adminLoginId;
    String adminPassword;

    public Admin() {
        adminLoginId = "admin";
        adminPassword = "00000000";
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
}
