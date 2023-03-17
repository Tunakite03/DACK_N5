import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
class birthday {
    // kiểm tra xem birthday có bằng rỗng không
    public boolean checkbirthday(String birthday) {
        if (birthday == null || birthday.isEmpty()) {
            return false;
        }else{
            return true;
        }

    }
    // kiểm tra xem birday có hợp lệ hay không
    public boolean checkbirthdayavile(String birthdayString) {
        LocalDate  birthday = LocalDate.parse(birthdayString);
        if (birthday == LocalDate.parse(birthdayString)) {
            return false;
        }else{
            return true;
        }

    }

    // kiểm tra xem birthday  có lớn hơn ngày hiện tại hay không
    public boolean checkbirthdaynow(String birthdayString) {
        LocalDate birthday = LocalDate.parse(birthdayString);
        if (birthday.isAfter(LocalDate.now())) {
            return false;
        }else{
            return true;
        }

    }

}

