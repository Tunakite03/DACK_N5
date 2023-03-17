
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class gender {
    // kiểm tra xem giới tính có bằng rỗng không
    public boolean checkgender(String gender) {
        if (gender == null || gender.isEmpty()) {
            return false;
        }else{
            return true;
        }
    }
}

