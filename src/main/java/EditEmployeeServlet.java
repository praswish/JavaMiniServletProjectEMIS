import com.praswish.Employee;
import com.praswish.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EditEmployee")
public class EditEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String dob=req.getParameter("dob");
        Double salary=Double.parseDouble(req.getParameter("salary"));

        Employee emp= new Employee(id,name,address,email,dob,salary);
        EmployeeService ES = null;
        try {
            ES = new EmployeeService();
            ES.editEmployee(emp);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher rd= req.getRequestDispatcher("welcomepage.jsp");
        rd.forward(req,resp);

    }
}
