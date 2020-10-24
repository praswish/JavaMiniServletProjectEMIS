import com.praswish.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String uname=req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String newpwd1=req.getParameter("newpwd1");
        String newpwd2=req.getParameter("newpwd2");
        LoginDao dao= new LoginDao();
        HttpSession session  = req.getSession();
        String username =(String) session.getAttribute("username");

        if (!username.equals(uname)){
            req.setAttribute("errorMessage", "Invalid user name");
            RequestDispatcher rd= req.getRequestDispatcher("changepassword.jsp");
            rd.forward(req,resp);
           //resp.sendRedirect("changepassword.jsp");
        }
        else if(! dao.checklogin(uname,pwd)){
            req.setAttribute("errorMessage", "Invalid user name or password");
            RequestDispatcher rd= req.getRequestDispatcher("changepassword.jsp");
            rd.forward(req,resp);
        }
        else if (!newpwd1.equals(newpwd2)) {
            req.setAttribute("errorMessage", "New password doesn't match");
            RequestDispatcher rd= req.getRequestDispatcher("changepassword.jsp");
            rd.forward(req,resp);
        }
        else if (username.equals(uname) && dao.checklogin(uname,pwd) && newpwd1.equals(newpwd2)){
            dao.changePassword(uname,pwd,newpwd1);
            resp.sendRedirect("welcomepage.jsp");
        }

    }
}
