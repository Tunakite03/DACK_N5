import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionCase {

    // Kiểm tra xem nhập lại mật khẩu có trùng với mật khẩu không
    // Hàm kiểm tra xem hai chuỗi có trùng nhau không
    public boolean CheckMatch(String expect, String actual) {
        boolean result = !actual.isEmpty() && !expect.isEmpty() && actual.equals(expect);
        return  result;
    }


    // Hàm xét giá trị nhập vào
    // Kiểm tra xem phần Email có chứa khoảng trắng khong
    public boolean CheckBlank(String blank) {
        boolean result = !blank.isEmpty() && !blank.trim().isEmpty();
        return result;
    }


    //Kiểm tra xem giá tiền có được update khi sản phẩm thay đổi
    public boolean CheckCost(int cost, int quantity_old, int quantity_change, int newcost) {
        int price = cost / quantity_old * quantity_change;
        if(price == newcost) return  true;
        return false;
    }

}
