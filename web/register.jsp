<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<body>

<%@include file="layout/header.jsp" %>


<div class="row mt-4 my-5">
    <div class="col-md-6 col-md-offset-3 text-center p-lg-4 mx-auto">
        <div class="form-group col-md-4 col-md-offset-2 mx-auto mt-5">
            <%
                String existsLogin = request.getParameter("login");
                if (existsLogin != null) {
            %>
            <div class="alert alert-info">
                Login <%=existsLogin%> already exists on this shop. Give a different login.
            </div>
            <%
                }
                String password = request.getParameter("password");
                if(password!=null){
            %>
            <div class="alert alert-info">
                The passwords are different. Try again
            </div>
            <%}%>

            <h1 class="display-4 font-weight-normal">Register!</h1>


            <form action="register" method="post" accept-charset="UTF-8">
                <label for="login">Login</label>
                <input type="text" class="form-control" name="login" id="login"
                       placeholder="Enter your  login..." required>

                <label for="password" class="mt-2">Password</label>
                <input type="password" class="form-control" name="password" id="password"
                       placeholder="Enter your password..." required>

                <label for="password2" class="mt-2">Repeat password</label>
                <input type="password" class="form-control" name="password2" id="password2"
                       placeholder="Reaped your password..." required>

                <label for="firstName">First name</label>
                <input type="text" class="form-control" name="firstName" id="firstName"
                       placeholder="Enter your first name..." required>

                <label for="lastName">Last name</label>
                <input type="text" class="form-control" name="lastName" id="lastName"
                       placeholder="Enter your last name..." required>

                <label for="city">City</label>
                <input type="text" class="form-control" name="city" id="city"
                       placeholder="Enter your city..." required>

                <label for="birthYear">Birth year</label>
                <input type="number" class="form-control" name="birthYear" id="birthYear"
                       placeholder="Enter your birth year..." required>


                <button type="submit" class="btn btn-outline-info mt-3">Register</button>
            </form>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
</body>
</html>
