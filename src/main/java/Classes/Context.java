package Classes;

public class Context {
    private Admin currentAdmin;
    private static Context context = null;
    public Admin getCurrentAdmin() {
        return currentAdmin;
    }
    public void setCurrentAdmin(Admin assignedAdmin) {
        currentAdmin = assignedAdmin;
    }
    private Context(){
    }
    public static Context getInstance()
    {
        if (context == null)
            context = new Context();
        return context;
    }
}
