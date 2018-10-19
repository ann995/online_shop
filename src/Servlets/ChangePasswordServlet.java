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


@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @EJB
    private UsersDao usersDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        User user = usersDao.getUserByLogin(login);
        if(password1.equals(password2)){
            user.setPassword(password1);
            usersDao.updateUser(user);

            req.setAttribute("user",user);
            req.getRequestDispatcher("userProfile.jsp?successfully=").forward(req,resp);
        }
        else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("userProfile.jsp?noPassword=").forward(req,resp);
        }
    }
}
