
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class customer {
    // kiểm tra xem tên có bằng rỗng không
    public boolean checkName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }else{
            return true;
        }
    }
    // kiểm tra xem tên có ký tự đặt biệt không
    private static final String NAME_REGEX = ".*[^a-zA-Z0-9].*";

    private static final Pattern pattern = Pattern.compile(NAME_REGEX);
    public boolean checkSpecialCharacter(String name) {
        Matcher matcher = pattern.matcher(name);
        boolean result = !name.isEmpty() && matcher.matches();
        return result;
    }
    // kiểm tra xem tên có khoảng trắng ở đầu không
    public boolean checkspace(String name) {
        boolean result = !name.isEmpty() && !name.trim().isEmpty();
        return result;
    }
    // kiểm tra xem tên có chứa số hay không
    private static final String NAME_NUMBER = ".*\\d+.*";

    private static final Pattern pattern1 = Pattern.compile(NAME_NUMBER);
    public boolean checknumber(String name) {
        Matcher matcher = pattern1.matcher(name);
        boolean result = !name.isEmpty() && matcher.matches();
        return result;
    }

}