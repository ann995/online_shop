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


@WebServlet("/addProduct")

public class AddProductServlet extends HttpServlet {
    @EJB
    ProductsDao productsDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        productsDao.addProduct(new Product(0,name,category,description,Double.parseDouble(price)));
        resp.sendRedirect(resp.encodeRedirectURL("addProduct.jsp?successfully="));
    }
}
