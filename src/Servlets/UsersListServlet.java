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
import java.util.List;

@WebServlet("/usersList")
public class UsersListServlet extends HttpServlet {
    @EJB
    private UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = usersDao.getAllUsers();

        for(User user:allUsers){
            user.setPassword("");
        }

        req.setAttribute("users", allUsers);
        req.getRequestDispatcher("users.jsp").forward(req,resp);
    }
}
