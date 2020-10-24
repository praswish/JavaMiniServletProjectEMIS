<%@ page import="java.sql.*" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
    <%
        if(session.getAttribute("username")== null){
            response.sendRedirect("index.jsp");
        }
    %>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">EMIS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="addEmployee.jsp">Add</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="changepassword.jsp">Change Password</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button>
        </form>
    </div>
</nav>
    <h4>Welcome <%=session.getAttribute("username")%></h4>
    <%
        String url ="jdbc:mysql://localhost:3306/emis";
        String dbUser ="root";
        String dbPass ="nepal123";
        String sql = "SELECT * FROM emis.employee";
        Statement st = null;
        ResultSet rs = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,dbUser,dbPass);
            st=con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    %>

    <div class="container">
        <h2>Employee Management Information System</h2>
        <table class="table table-light table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Date of Birth</th>
                <th>Salary</th>
                <th></th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <%
                System.out.println(sql);
                rs = st.executeQuery(sql);
                while (rs.next()){
            %>
            <tr>
                <td><%=rs.getString("name")%></td>
                <td><%=rs.getString("address")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("dob")%></td>
                <td><%=rs.getString("salary")%></td>
                <td><button type="button" onclick ="document.location.href='editEmployee.jsp?id=' + <%=rs.getInt(1)%>" class="btn btn-success">Edit</button></td>
                <td><button type="button" onclick ="document.location.href='DeleteEmployee?id=' + <%=rs.getInt(1)%>" class="btn btn-danger">Delete</button></td>

            </tr>
            <%
                }
            %>
            </tbody>

        </table>
    </div>





<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
