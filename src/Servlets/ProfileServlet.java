package Servlets;

import Users.User;
import Users.UsersDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profileServlet")
public class ProfileServlet extends HttpServlet {
    @EJB
            private UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("username");
        User user =  usersDao.getUserByLogin(login);

        req.setAttribute("user",user);
        req.getRequestDispatcher("userProfile.jsp").forward(req,resp);
    }

}
