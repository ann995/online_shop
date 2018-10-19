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

@WebServlet("/changeUserData")
public class ChangeUserDataServlet extends HttpServlet {
    @EJB
    UsersDao usersDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("username");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String city = req.getParameter("city");
        int birthYear = Integer.parseInt(req.getParameter("birthYear"));
        User user = usersDao.getUserByLogin(login);

        if(user!=null){
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setCity(city);
            user.setBirthYear(birthYear);
            usersDao.updateUser(user);

            req.setAttribute("user",user);
            req.getRequestDispatcher("userProfile.jsp?update=").forward(req,resp);
        }
        else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("userProfile.jsp?error=").forward(req,resp);
        }
    }
}
