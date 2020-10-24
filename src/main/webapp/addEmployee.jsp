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
    <h2>Add New Employee</h2>
    <form class="form-horizontal" action="/AddEmployee" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="address">Address:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" placeholder="Enter address" name="address">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="dob">Date of Birth:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="dob" placeholder="Enter Date of Birth" name="dob">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="salary">Salary:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="salary" placeholder="Enter Salary" name="salary">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Add</button>
                <button type="button" onclick ="document.location.href='/welcomepage.jsp'" class="btn btn-default">Cancel</button>
            </div>
        </div>
        </div>
    </form>
</div>

</body>
</html>
