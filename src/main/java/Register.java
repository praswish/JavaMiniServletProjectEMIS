import com.praswish.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String uname=req.getParameter("uname");
        String newpwd1=req.getParameter("newpwd1");
        String newpwd2=req.getParameter("newpwd2");

        LoginDao dao= new LoginDao();
        //HttpSession session  = req.getSession();
        //String username =(String) session.getAttribute("username");


        if(dao.checkUser(uname)){
            req.setAttribute("errorMessage", "User Name already exist");
            RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
            rd.forward(req,resp);
        }
        else if (!newpwd1.equals(newpwd2)) {
            req.setAttribute("errorMessage", "Password doesn't match");
            RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
            rd.forward(req,resp);
        }
        else if (dao.register(uname,newpwd1)){
            HttpSession session  = req.getSession();
            session.setAttribute("username",uname);
            RequestDispatcher rd= req.getRequestDispatcher("welcomepage.jsp");
            rd.forward(req,resp);

        }

    }

}
