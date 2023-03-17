import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestConditionCase1_8 {

    customer name = new customer();
    gender  gt = new gender();
    birthday bth = new birthday();
    @Test
    public void testcaseR1() {
        boolean result = name.checkName("   ");
        assertTrue(result);

    }
    @Test
    public void testcaseR2() {
        boolean result = name.checkSpecialCharacter("1234meoz@@");
        assertTrue(result);
    }
    @Test
    public void testcaseR3() {
        boolean result = name.checkspace("   1234@@");
        assertTrue(result);
    }
    @Test
    public void testcaseR4() {
        boolean result = name.checknumber("1234meoz");
        assertTrue(result);
    }
    @Test
    public void testcaseR5() {
        boolean result = gt.checkgender("    ");
        assertTrue(result);
    }
    @Test
    public void testcaseR6() {
        boolean result = bth.checkbirthday("   ");
        assertTrue(result);
    }
    @Test
    public void testcaseR7() {
        boolean result = bth.checkbirthdaynow("2023-03-17");
        assertTrue(result);
    }
    @Test
    public void testcaseR8() {
        boolean result = bth.checkbirthdayavile("1931-02-31");
        assertTrue(result);
    }
}
