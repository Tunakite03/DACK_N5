import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestConditionCase9_16 {
    ConditionCase check = new ConditionCase();
    ValidEmail ValidEmail = new ValidEmail();
    ValidPassword ValidPassword = new ValidPassword();
    ValidUsername ValidUsername = new ValidUsername();
    @Test
    public void testcase9() {
        String email = "";
        boolean result = check.CheckBlank(email);
        assertFalse(result);
    }
    @Test
    public void testcase10() {
        boolean result = ValidEmail.isExistEmail("qqq@gmail.com");
        assertTrue(result);
    }
    @Test
    public void testcase11() {
        boolean result = ValidUsername.isValidUsername(" 1234meoz");
        assertFalse(result);
    }
    @Test
    public void testcase12() {
        boolean result = ValidEmail.isValidEmail("135wdfk");
        assertFalse(result);
    }
    @Test
    public void testcase13() {
        boolean result = ValidPassword.isValidPassword("123456qwer");
        assertFalse(result);
    }
    @Test
    public void testcase14() {
        boolean result = ValidPassword.isValidPassword("");
        assertFalse(result);
    }

    @Test
    public void testcase15() {
        boolean result = ValidPassword.isValidPassword("123456@");
        assertFalse(result);
    }
    @Test
    public void testcase16() {
        boolean result = ValidPassword.isValidConfirmPassword("123456qwer@", "");
        assertFalse(result);
    }

}
