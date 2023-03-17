import java.util.regex.Pattern;

public class ValidUsername {

    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,}$";
    private static final Pattern pattern = Pattern.compile(USERNAME_REGEX);

    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        return pattern.matcher(username).matches();
    }

}
