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
            <h3 class="display-5 font-weight-normal">All users</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Login</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Birth year</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>jank</td>
                    <td>Jan</td>
                    <td>Nowak</td>
                    <td>1980</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
