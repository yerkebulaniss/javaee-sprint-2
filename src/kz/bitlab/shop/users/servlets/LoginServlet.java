package kz.bitlab.shop.users.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.shop.users.service.UserService;

import java.io.IOException;

@WebServlet("/signIn")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Long id = UserService.login(email, password);

        if (id == null) {
            resp.sendRedirect("/signIn?invalidCredentials");
            return;
        }

        resp.sendRedirect("/profile?id=" + id);
    }
}
