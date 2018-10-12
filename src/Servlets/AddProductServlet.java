package Servlets;

import Products.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Products.ProductsDao.addProduct;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        addProduct(new Product(name,category,description,Integer.parseInt(price)));
        resp.sendRedirect(resp.encodeRedirectURL("addProduct.jsp?successfully="));
    }
}
