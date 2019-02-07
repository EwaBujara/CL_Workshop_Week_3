package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;
import sun.plugin.dom.html.HTMLTableCaptionElement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-users")
public class ShowUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getParameter("groupId");
        List<User> users = UserDao.loadAll(groupId);
        req.setAttribute("users", users);
        req.setAttribute("groupId", groupId);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}


