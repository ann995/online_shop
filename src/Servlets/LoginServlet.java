package Servlets;

import Users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Users.UsersDao.getUserByLogin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = getUserByLogin(login);
        if(user!=null && user.getPassword().equals(password)){
            req.getSession().setAttribute("username",login);
            resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));
        }
        else{
            resp.sendRedirect(resp.encodeRedirectURL("login.jsp?invalidLogin=true"));
        }
    }
}
