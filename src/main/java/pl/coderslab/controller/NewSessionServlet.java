package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

//import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logIn")
public class NewSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userId = req.getParameter("userId");
        int userIdValue = Integer.parseInt(userId);
        User currentUser = new  User(userIdValue, userName);
        User dbUser = UserDao.getByName(userName);

        if(dbUser.equals(currentUser)){
            HttpSession session = req.getSession(true);
            session.setAttribute("currentUser", currentUser);
            session.setAttribute("currentUserName", currentUser.getUsername());
            resp.sendRedirect("/"); //logged-in page
        }
    }
}
