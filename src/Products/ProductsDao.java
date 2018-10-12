package Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsDao {

    private static List<Product> allProducts = new ArrayList<>();

    public static List<Product> getAllProducts(){
        return allProducts;
    }

    public static void addProduct(Product addProduct){
        allProducts.add(addProduct);
    }

    static{
        allProducts.add(new Product("Hammer","Tools","Indestructible hammer!",30));
        allProducts.add(new Product("Hatchet","Tools","Handy hatchet!",45));
    }

}
