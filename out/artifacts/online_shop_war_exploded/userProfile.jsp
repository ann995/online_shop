<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
</head>
<body>

<%@include file="layout/header.jsp" %>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        ...
    </div>
</div>


<div class="row">
    <div class="p-lg-5 mx-auto my-5 col-md-6 col-md-offset-3 text-center">
        <div class="table-responsive">

            <h3 class="display-5 font-weight-normal">Edit profile (admin)</h3>
            <hr>
            <h4 class="display-6 font-weight-normal">Change password</h4>
            <div class="alert alert-success" role="alert">
                Password successfully changed!
            </div>
            <div class="alert alert-danger" role="alert">
                Passwords do not match!
            </div>

            <form action="changePassword" method="post">
                <input name="login" value="admin" type="hidden">
                <div class="form-group">
                    <label for="password1">New password</label>
                    <input id="password1" name="password1" type="password" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password2">New password (retype)</label>
                    <input id="password2" name="password2" type="password" class="form-control">
                </div>
                <input type="submit" class="btn btn-dark" value="Change password">
            </form>
            <hr>
            <h4 class="display-6 font-weight-normal">Edit data</h4>
            <div class="alert alert-success" role="alert">
                User data changed!
            </div>
            <div class="alert alert-danger" role="alert">
                Error occured while changing data :(
            </div>

            <form action="changeUserData" method="post">
                <input name="login" value="admin" type="hidden">
                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input id="firstName" name="firstName" type="text" class="form-control"
                           value="Jan">
                </div>
                <div class="form-group">
                    <label for="lastName">Last name</label>
                    <input id="lastName" name="lastName" type="text" class="form-control"
                           value="Nowak">
                </div>
                <div class="form-group">
                    <label for="birthYear">Birth year</label>
                    <input id="birthYear" name="birthYear" type="number" class="form-control"
                           value="1980">
                </div>
                <input type="submit" class="btn btn-dark" value="Save">
            </form>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
