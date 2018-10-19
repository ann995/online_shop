<%@ page import="Users.User" %>
<%@ page import="java.util.List" %>
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
            <%
                if ("admin".equals(request.getSession(false).getAttribute("username"))) {
            %>

            <h3 class="display-5 font-weight-normal">All users</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Login</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>City</th>
                    <th>Birth year</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<User> usersList = (List<User>) request.getAttribute("users");
                    for (User userList : usersList) {

                %>
                <tr>
                    <td><%=userList.getLogin()%>
                    </td>
                    <td><%=userList.getFirstName()%>
                    </td>
                    <td><%=userList.getLastName()%>
                    </td>
                    <td><%=userList.getCity()%>
                    </td>
                    <td><%=userList.getBirthYear()%>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <div class="alert alert-danger" role="alert">
                    You haven't permission!
                </div>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
