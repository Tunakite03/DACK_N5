import java.lang.reflect.Array;

class Product {
    // Attributes
    String name;
    double price;

    // Methods
    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class Cart {
    // Attributes
    Product[] products; // An array of products
    int size; // The number of products in the cart
    double total;
    // Methods
    // Constructor
    public Cart() {
        products = new Product[100]; // Create an array with a given capacity
        size = 0; // Initialize the size to zero
    }
    public int getSize() {
        return  size ;
    }
    public double getTotal(){
        return  total;
    }

    // A method to add a product to the cart
    public void addProduct(Product product) {
        if (size < products.length) { // Check if there is space in the array
            products[size] = product; // Add the product at the end of the array
            total += product.price;
            size++; // Increment the size by one
        } else {
            System.out.println("The cart is full."); // Print an error message if there is no space left
        }
    }
    // declare a method named deleteProduct
    public void deleteProduct(int index) {

        // check if the index is valid
        if (index >= 0 && index < products.length) {

            // create a new array with one less elemen
            Product[] newProducts = new Product[products.length - 1];
            total -= products[index].price;
            // copy all elements before the index
            System.arraycopy(products, 0, newProducts, 0, index);

            // copy all elements after the index
            System.arraycopy(products, index + 1, newProducts, index, products.length - index - 1);

            // assign the new array to products
            products = newProducts;



        }
    }
    public Product getProduct(int index) {
        // Check if the index is valid
        if (index >= 0 && index < size) {
            // Return the product at the given index
            return products[index];
        } else {
            // Print an error message and return null
            System.out.println("Invalid index.");
            return null;
        }
    }
    public boolean updateProduct(Product oldProduct, Product newProduct) {
        // find the index of the old product in the cart array
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (products[i].equals(oldProduct)) {
                index = i;
                break;
            }
        }
        // if the old product exists in the cart
        if (index != -1) {
            // replace it with the new product
            products[index] = newProduct;
            return true;
        } else {
            // print an error message
            System.out.println("The old product is not in the cart.");
            return false;
        }

    }
}
