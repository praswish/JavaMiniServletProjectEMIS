import com.praswish.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String uname=req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        LoginDao dao= new LoginDao();

        if (dao.checklogin(uname,pwd)) {
            HttpSession session  = req.getSession();
            session.setAttribute("username",uname);
            resp.sendRedirect("welcomepage.jsp");
        }
        else
        {
            HttpSession session  = req.getSession();
            session.invalidate();
            req.setAttribute("errorMessage", "Invalid user or password");
            RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
            rd.forward(req,resp);
        }

    }
}
