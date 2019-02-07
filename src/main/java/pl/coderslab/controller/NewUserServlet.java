package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/newUser")
public class NewUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> groups = new ArrayList<>();

        //req.setAttribute("groups", groups);
        //req.getRequestDispatcher("/newUser.jsp");
       resp.sendRedirect("/newUser.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUserName = req.getParameter("newUserName");
        String newUserEmail = req.getParameter("newUserEmail");
        String newUserPassword = req.getParameter("newUserPassword");
        String newUserGroupName = req.getParameter("newUserGroupName");

        UserGroup userGroup = UserGroupDao.getByName(newUserGroupName);
        User user = new User(newUserName, newUserPassword, newUserEmail, userGroup);
        UserDao.addToDb(user);

        HttpSession session = req.getSession();
        session.setAttribute("currentUser",user);
        session.setAttribute("currentUserName",user.getUsername());
        resp.sendRedirect("/");
    }
}