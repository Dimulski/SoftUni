package servletDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("I am home");
        HttpSession session = req.getSession();
        String username = session.getAttribute("username").toString();
        if(username != null){
            pw.println("Username: " + username);
        }

        pw.print("html...");

        session.invalidate();

        req.getRequestDispatcher("home.html").forward(req, resp);
    }
}
