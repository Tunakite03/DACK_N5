import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmail {

    private static final String EMAIL_REGEX =
                    "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);


        //Check Email có hợp lệ hay không
        public static boolean isValidEmail(String email) {
            Matcher matcher = pattern.matcher(email);
            boolean result = !email.isEmpty() && matcher.matches();
            return result;
        }

        //Check Email có tồn tại không
        public boolean isExistEmail(String email) {
            String[] Array = {"123@gmail.com", "aaa@gmail.com", "abc@gmail.com"};
            for (String ele:Array) {
                if(email.equals(ele))
                    return true;
            };
            return false;
        }
}
