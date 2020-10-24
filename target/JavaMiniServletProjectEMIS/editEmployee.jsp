<%@ page import="com.praswish.Employee" %>
<%@ page import="com.praswish.EmployeeService" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%
    if(session.getAttribute("username")== null){
        response.sendRedirect("index.jsp");
    }
%>

<div class="container">
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeService EE= new EmployeeService();
        Employee emp = EE.returnEmployee(id);

    %>
    <h2>Edit Employee</h2>
    <form class="form-horizontal" action="/EditEmployee?id=<%=emp.getId()%>" method="post">
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-sm-2" for="id1">ID:</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="text" class="form-control" id="id1" name="id1" value="<%=emp.getId()%>" >--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="control-label col-sm-2" >Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" value="<%=emp.getName()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" >Address:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="address" value="<%=emp.getAddress()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" >Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email" value="<%=emp.getEmail()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" >Date of Birth:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="dob" value="<%=emp.getDob()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" >Salary:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="salary" value="<%=emp.getSalary()%>">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit"  class="btn btn-success">Save</button>
                <button type="button" onclick ="document.location.href='/welcomepage.jsp'" class="btn btn-default">Cancel</button>
            </div>
        </div>


    </form>
</div>

</body>
</html>

