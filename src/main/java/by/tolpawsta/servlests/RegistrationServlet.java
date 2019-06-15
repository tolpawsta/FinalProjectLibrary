package by.tolpawsta.servlests;

import by.tolpawsta.models.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

/**
 * 14.06.2019
 * by.tolpawsta.servlests
 *
 * @author Talochka Pavel
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
   private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername=properties.getProperty("db.username");
            String dbPassword=properties.getProperty("db.password");
            String driverClassName=properties.getProperty("db.driverClassName");
            Class.forName(driverClassName);
            connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname=req.getParameter("firstname");
        String lastname=req.getParameter("lastname");
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        LocalDate birthdate=LocalDate.parse(req.getParameter("birthdate"));

        try(Statement statement=connection.createStatement()){

            String sqlInsertUser="INSERT INTO 'user' (firstname,lastname,login,password,birthdate) VALUES " +
                    "('"+firstname+"', '"+lastname+"', '"+login+"', '"+password+"', '"+birthdate+"')";
            if(statement.execute(sqlInsertUser)){
               // UserInfo user=new UserInfo(firstname,lastname,birthdate);
               // req.setAttribute("users",user);
                req.getServletContext().getRequestDispatcher("/jsp/account.jsp").forward(req,resp);

            }
            else{
                resp.sendRedirect("/jsp/registration.jsp");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
