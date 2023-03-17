import java.util.regex.Pattern;

public class ValidPassword {

    private static final String PASSWORD_REGEX = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_REGEX);

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return pattern.matcher(password).matches();
    }

    public boolean isValidConfirmPassword(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }

}
