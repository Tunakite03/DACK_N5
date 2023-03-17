import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestConditionCase17_23 {
    ConditionCase check = new ConditionCase();
    ValidEmail checkemail = new ValidEmail();

    @Test
    public void testcaseR17() {
        boolean result = check.CheckMatch("123456qwer@", "123456qwer@");
        assertTrue(result);
    }

    @Test
    public void testcaseL18() {
        boolean result = check.CheckBlank("      ");
        assertFalse(result);
    }

    @Test
    public void testcaseL19() {
        boolean result = checkemail.isValidEmail("1234qwe@.com");
        assertFalse(result);
    }

    @Test
    public void testcaseL20() {
        boolean result = checkemail.isExistEmail("hahah@gmail.com");
        assertFalse(result);
    }

    @Test
    public void testcaseL21() {
        boolean result = check.CheckBlank("     ");
        assertFalse(result);
    }

    @Test
    public void testcaseL22() {
        boolean result = check.CheckMatch("123456qwer@", "ohhlalaa");
        assertFalse(result);
    }

    @Test
    public void testcaseL23() {
        boolean result = check.CheckCost(2549000, 1, 3, 7647000);
        assertTrue(result);
    }
}
