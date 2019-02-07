package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/newExercise")
public class NewExerciseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newExerciseName = req.getParameter("newExerciseName");
        String newExerciseContent = req.getParameter("newExerciseContent");
        LocalDate newExerciseCreated = LocalDate.now();

        HttpSession session = req.getSession(false);
        String newExerciseUserName = (String) session.getAttribute("currentUserName");

        if(newExerciseUserName != null) {
            User user= UserDao.getByName(newExerciseUserName);
            Exercise exercise = new Exercise(newExerciseName, newExerciseContent, newExerciseCreated, user);
            ExerciseDao.addToDb(exercise);
            resp.sendRedirect("/exercises");
        }
        else {
            resp.getWriter().println("You must Sign In to add a new exercise");
        }
    }
}
