<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>

    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link href="css/product.css" rel="stylesheet">
</head>
<body>

<div class="row mt-4 my-5">
    <div class="col-md-6 col-md-offset-3 text-center p-lg-4 mx-auto">
        <div class="form-group col-md-4 col-md-offset-2 mx-auto">

            <%
                String invalidLogin = request.getParameter("invalidLogin");
                if (invalidLogin != null) {
            %>
            <div class="alert alert-danger">
                Incorrect login data!
            </div>
            <%
                }
                String logout = request.getParameter("logout");
                if(logout!=null){
            %>
            <div class="alert alert-info">
               You are logged out! Log in again.
            </div>
            <%}%>
            <h1 class="display-4 font-weight-normal">Login!</h1>


            <form action="login" method="post">
                <label for="login">Login</label>
                <input type="text" class="form-control" name="login" id="login"
                       placeholder="Enter your  login...">

                <label for="password" class="mt-2">Password</label>
                <input type="password" class="form-control" name="password" id="password"
                       placeholder="Enter your password...">

                <button type="submit" class="btn btn-outline-info mt-3">Login</button>
            </form>

            <a href="register.jsp">
                <button class="btn btn-success">Register</button>
            </a>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
</body>
</html>
