package pl.coderslab.controller;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newGroup")
public class NewGroupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newGroupName = req.getParameter("newGroupName");

        UserGroup userGroup = new UserGroup(newGroupName);
        UserGroupDao.addToDb(userGroup);

        resp.sendRedirect("/groups");
    }
}
