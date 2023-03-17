import org.testng.annotations.Test;

public class ConditionCase {


//    Kiểm tra xem Customer name có được nhập hay không
//    Nếu có trả về true, rỗng thì trả về false
    public boolean checkRequire(String Var){
        boolean result = !Var.isEmpty() && !Var.trim().isEmpty();
        return  result;
    }

//    If the product changes, the cart must update the changed product
    public void testUpdateProduct(Product oldProduct, Product newProduct , Cart cart ) {
        cart.addProduct(oldProduct);
        // Act
        cart.updateProduct(oldProduct, newProduct);
    }


    public double testDeleteProduct( Cart cart, int index ) {
             cart.deleteProduct(1);
             return  cart.getTotal();
    }
    public double testAddProduct( Cart cart, Product newProduct ) {
        cart.addProduct(newProduct);
        return cart.getTotal();
    }
    public boolean testOldPass( String oldpass, String oldpassconfirm ) {
         boolean result = oldpass == oldpassconfirm;
         return  result;
    }


}
