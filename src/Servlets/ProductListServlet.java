package Servlets;

import Products.Product;
import Products.ProductsDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    @EJB
    ProductsDao productsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> allProducts = productsDao.getAllProducts();

        req.setAttribute("allProducts", allProducts);
        req.getRequestDispatcher("products.jsp").forward(req,resp);
    }
}
