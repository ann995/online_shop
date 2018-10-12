<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<body>

<%@include file="layout/header.jsp" %>


<div class="row mt-4 my-5">
    <div class="col-md-6 col-md-offset-3 text-center p-lg-5 mx-auto">
        <div class="form-group col-md-4 col-md-offset-2 mx-auto">

            <%
                if (request.getParameter("successfully") != null) {
            %>
            <div class="alert alert-success" role="alert">
                Product added!
            </div>
            <%
                }
                if ("admin".equals(request.getSession(false).getAttribute("username"))) {
            %>
            <h3 class="display-5 font-weight-normal">Add new product!</h3>


            <form action="addProduct" method="post" accept-charset="UTF-8">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" id="name"
                           placeholder="Enter product name..." required>
                </div>

                <div class="form-group">
                    <label for="category">Category</label>
                    <input type="text" class="form-control" name="category" id="category"
                           placeholder="Enter product category..." required>
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" rows="5" cols="30" class="form-control" required>Enter product description...</textarea>
                </div>

                <label for="price">Price</label>
                <input type="number" class="form-control" name="price" id="price"
                       placeholder="Enter product price..." value="100" required>


                <button type="submit" class="btn btn-outline-info mt-3">Add product</button>
            </form>

            <%
            } else {
            %>
            <div class="alert alert-danger" role="alert">
                You haven't permission!
            </div>
            <%}%>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
</body>
</html>
