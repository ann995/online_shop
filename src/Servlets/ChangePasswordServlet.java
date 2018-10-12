package Servlets;

import Users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Users.UsersDao.getUserByLogin;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession(false).getAttribute("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        User user = getUserByLogin(login);
        if(password1.equals(password2)){
            user.setPassword(password1);
            resp.sendRedirect(resp.encodeRedirectURL("userProfile.jsp?successfully="));
        }
        else{
            resp.sendRedirect(resp.encodeRedirectURL("userProfile.jsp?noPassword="));
        }
    }
}
