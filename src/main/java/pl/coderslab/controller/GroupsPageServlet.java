package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.Solution;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/groups")
public class GroupsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserGroup> groups = UserGroupDao.loadAll();
        req.setAttribute("groups", groups);
        req.getRequestDispatcher("/WEB-INF/views/groups.jsp").forward(req, resp);

    }

}
