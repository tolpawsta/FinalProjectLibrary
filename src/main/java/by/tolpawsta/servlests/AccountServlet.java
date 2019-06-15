package by.tolpawsta.servlests;

import by.tolpawsta.models.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * 14.06.2019
 * by.tolpawsta.servlests
 *
 * @author Talochka Pavel
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    public AccountServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname=req.getParameter("firstname");
        String lastname=req.getParameter("lastname");
        LocalDate birthdate=LocalDate.parse(req.getParameter("birthdate"));
        //UserInfo userinfo =new UserInfo(firstname,lastname,birthdate);
       // req.setAttribute("user",userinfo);

        req.getServletContext().getRequestDispatcher("/jsp/account.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
