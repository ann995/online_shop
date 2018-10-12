package Servlets;

import Users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Users.UsersDao.addUser;
import static Users.UsersDao.getUserByLogin;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String city = req.getParameter("city");
        int birthYear = Integer.parseInt(req.getParameter("birthYear"));

        if (getUserByLogin(login) == null && password.equals(password2)) {
            User newUser = new User(login, password, firstName, lastName, city, birthYear, "USER");
            addUser(newUser);
            resp.sendRedirect(resp.encodeRedirectURL("login.jsp"));
        } else if (!password.equals(password2)) {
            resp.sendRedirect(resp.encodeRedirectURL("register.jsp?password="));
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("register.jsp?login=" + login));
        }
    }
}

