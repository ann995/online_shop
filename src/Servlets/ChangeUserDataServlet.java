package Servlets;

import Users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Users.UsersDao.getUserByLogin;
import static Users.UsersDao.updateUser;

@WebServlet("/changeUserData")
public class ChangeUserDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession(false).getAttribute("username");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String city = req.getParameter("city");
        int birthYear = Integer.parseInt(req.getParameter("birthYear"));

        User user = getUserByLogin(login);

        if(user!=null){
            updateUser(user,firstName,lastName,city,birthYear);
            resp.sendRedirect("userProfile.jsp?update=");
        }
        else{
            resp.sendRedirect("userProfile.jsp?error=");
        }
    }
}
