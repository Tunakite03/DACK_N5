
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class TestConditionCase {
    ConditionCase con = new ConditionCase();


        //    C24 - Verify Cart - If the product changes, the cart must update the changed product
      @Test
         public void testCalculate24( ) {
              Cart cart = new Cart();
              Product  oldProduct = new Product("Apple", 1.99);
              Product newProduct = new Product("Banana", 0.99);
              con.testUpdateProduct(oldProduct, newProduct, cart);
              assertEquals(1, cart.getSize(), "So luong phan tu trong cart lon hon 1");
              assertEquals(newProduct, cart.getProduct(0), "Chua duoc cap nhat");
         }


            // C25 Verify Cart - If add new product , the cart must update amount money
            @Test
            public void testCalculate25( ) {
                Cart cart = new Cart();
                Product newProduct = new Product("Banana", 0.99);
                double total= cart.getTotal();        //0
                double totalAdd =  con.testAddProduct( cart, newProduct);
                assertEquals(newProduct.price, totalAdd - total, "Chua duoc cap nhat");
            }


            // C26 Verify Cart - If there are two or more products, the cart must update the total amount of 2 products
            @Test
            public void testCalculate26( ) {
                Cart cart = new Cart();
                Product Product = new Product("Apple", 1.99);
                Product Product2 = new Product("Banana", 0.99);
                cart.addProduct(Product);
                cart.addProduct(Product2);
                double total = cart.getTotal();
                double totalDelete= con.testDeleteProduct(cart, 1);
                assertFalse(total==totalDelete, "gio hang chua duoc cap nhat");
            }

            // C27 - Verify Change Password - Old Password is not be blank
            @Test
            public void testCalculate27a( ) {
             boolean result1 = con.checkRequire("   ");
             assertFalse(result1,"Kí tự cách được chấp nhận");
            }
            @Test
            public void testCalculate27b( ) {
                boolean result1 = con.checkRequire("");
                assertFalse(result1,"");
            }     @Test
            public void testCalculate27c( ) {
                boolean result1 = con.checkRequire("user1");
                assertTrue(result1);
            }

         // C28 - Verify Change Password - New Password is not be blank
        @Test
        public void testCalculate28( ) {
            boolean result1 = con.checkRequire("   ");
            assertFalse(result1);
        }
        //    C29 - Verify Change Password - Old Password is valid, if invalid display show error
        @Test
        public void testCalculate29( ) {
          String oldPass= "abc123";
          String newPass = "abc1234";
            boolean result = con.testOldPass(oldPass, newPass);
            assertFalse(result);
        }

    //    C30 - Verify Change Password - the new password not matches the old password
    @Test
    public void testCalculate30( ) {
        String pass= "abc123";
        String passconfirm = "abc1234";
        boolean result = con.testOldPass(pass, passconfirm);
        assertFalse(result);
    }


}

