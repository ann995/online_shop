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
    <div class="p-lg-5 mx-auto my-5 col-md-8 col-md-offset-2 text-center">
        <div class="table-responsive">
            <h3 class="display-5 font-weight-normal">Products</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>
                        Product name
                        <a href="products.jsp?sortByName">
                            <i class="fa fa-sort-alpha-asc"></i>
                        </a>
                    </th>
                    <th>
                        Product category
                        <a href="products.jsp?sortByCategory">
                            <i class="fa fa-sort-alpha-asc"></i>
                        </a></th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>Hammer</td>
                    <td><span class="badge badge-success">TOOLS</span></td>
                    <td>Indestructible hammer!</td>
                    <td>30 PLN</td>
                    <td>
                        <a href="productDetails.jsp?id=123" class="btn btn-primary d-inline-block">Details</a>
                        <a href="addToCart?productId=123" class="btn btn-success d-inline-block">Add to Cart</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
