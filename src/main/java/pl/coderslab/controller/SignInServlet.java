package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String userName = req.getParameter("userName");
      String userPassword = req.getParameter("userPassword");

        User currentUser = UserDao.getByName(userName);

        boolean password_verified = BCrypt.checkpw(userPassword, currentUser.getPassword());
        if(userName.equals(currentUser.getUsername()) && password_verified){
            HttpSession session = req.getSession();
            session.setAttribute("currentUser",currentUser);
            session.setAttribute("currentUserName",currentUser.getUsername());
            resp.sendRedirect("/");
        }
        else{
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head");
            out.println("<title></title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
            out.println("<div class=\"p-3 mb-2 bg-dark text-white\">");
            out.println("<a class=\"btn btn-info\" href=\"login.jsp\">Back to SigIn Page</a> ");
            out.println("</div>");
            out.println("</head>");
            out.println("<body class=\"p-3 mb-2 bg-info text-white\">");

            out.println("<h3 class=\"text-center\">Wrong login or password!</h3>");
            out.println("</body>");
            out.println("<footer class=\"page-footer p-3 mb-2 bg-dark text-white\">\n" +
                    "    <p class=\"text-center\">mail to: contact@programming-school.com</p>\n" +
                    "</footer>");
        }
    }

}
