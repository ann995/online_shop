package Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsDao {

    private static List<Product> allProducts = new ArrayList<>();

    public static List<Product> getAllProducts(){
        return allProducts;
    }

    public static Product getProductById(int id){
        return allProducts.stream().filter(p->p.getId()==id).findFirst().orElse(null);
    }

    public static void addProduct(Product addProduct){
        allProducts.add(addProduct);
    }
}