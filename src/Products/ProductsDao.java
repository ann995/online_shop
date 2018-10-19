package Products;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductsDao {
    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            String url = "jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "root";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                allProducts.add(resultSetFromProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    public Product resultSetFromProduct(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String category = rs.getString("category");
        String description = rs.getString("description");
        double price = rs.getDouble("price");

        return new Product(id, name, category, description, price);
    }

    public void addProduct(Product addProduct) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into products values (?,?,?,?,?)");
            preparedStatement.setInt(1, addProduct.getId());
            preparedStatement.setString(2, addProduct.getName());
            preparedStatement.setString(3, addProduct.getCategory());
            preparedStatement.setDouble(4, addProduct.getPrice());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Product getProductById(int id) {
        Product product = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from products where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return resultSetFromProduct(rs);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void updateProduct(Product product) {
        PreparedStatement preparedStatement;

        {
            try {
                preparedStatement = connection.prepareStatement("update products set name = ?, category = ?, description = ?, price = ? where id = ?");
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2,product.getCategory());
                preparedStatement.setString(3,product.getDescription());
                preparedStatement.setDouble(4,product.getPrice());
                preparedStatement.setInt(5,product.getId());

                preparedStatement.execute();

                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteProduct(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from products where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    public void clear(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
