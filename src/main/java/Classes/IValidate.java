package Classes;

public interface IValidate {
    boolean checkNumeric(String numAttempt);
    boolean validatePassword(String passwordAttempt);
    boolean validateEmail(String emailAttempt);
}
