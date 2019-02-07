package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Solution> mostRecentSolutions = SolutionDao.loadAll(5);
        req.setAttribute("solutions", mostRecentSolutions);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp") .forward(req, resp);
    }
}
