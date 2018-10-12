<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<body>

<%@include file="layout/header.jsp" %>

<div class="row mt-4">
    <div class="p-lg-5 mx-auto my-5 col-md-6 col-md-offset-3 text-center">
        <h1 class="display-4">Product name</h1>
        <p class="lead font-weight-normal">Category: some_category</p>
        <p class="lead font-weight-normal">Product description</p>
        <h4 >Price: <span class="badge badge-info">100 PLN</span> </h4>
        <a class="btn btn-outline-secondary" href="products.jsp">Back to all products</a>
        <a class="btn btn-outline-success" href="addToCart?productId=123">Add to cart</a>
    </div>
</div>


<%@include file="layout/footer.jsp" %>
</body>
</html>
