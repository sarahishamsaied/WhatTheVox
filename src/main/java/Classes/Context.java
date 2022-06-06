package Classes;

public class Context {
    private Admin currentAdmin;
    private static Context context = null;
    private User currentUser;
    private Movie movie = null;
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

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
