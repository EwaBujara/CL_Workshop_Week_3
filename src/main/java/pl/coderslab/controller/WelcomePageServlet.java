package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head");
        out.println("<title></title>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        out.println("<div class=\"p-3 mb-2 bg-dark text-white\">");
        out.println("<a class=\"btn btn-info\" href=\"login.jsp\">Sign In</a>");
        out.println("<a class=\"btn btn-info\" href=\"http://localhost:8080/newUser\">Sign Up</a>");
        out.println("</div>");
        out.println("</head>");
        out.println("<body class=\"p-3 mb-2 bg-info text-white\">");

        out.println("<h1 class=\"text-center\">Welcome in Programming School</h1>");
        out.println("</body>");
        out.println("<footer class=\"page-footer p-3 mb-2 bg-dark text-white\">\n" +
                "    <p class=\"text-center\">mail to: contact@programming-school.com</p>\n" +
                "</footer>");
        out.println("</html>");

    }
}
