package by.tolpawsta.servlests;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.sql.*;
import java.util.Properties;

/**
 * 14.06.2019
 * by.tolpawsta.servlests
 *
 * @author Talochka Pavel
 */
@WebServlet("/login")
public class LoingServlet extends HttpServlet {
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
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        try{
            Statement statement=connection.createStatement();
            String sqlSelectUser="SELECT firstname, lastname, birthdate FROM user WHERE user.login='"+login+"' AND user.password='"+password+"'";
            System.out.println(sqlSelectUser);
            ResultSet resultSet=statement.executeQuery(sqlSelectUser);
            if(resultSet.getRow()>0){
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
