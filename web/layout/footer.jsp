    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>

        <title>Title</title>
        </head>
        <body>

        <footer class="container py-5">
        <div class="row">
        <div class="col-12 col-md">
        <img class="logo mb-3" src="gfx/logo.png">
        <small class="d-block mb-3 text-muted">&copy; 2018-2018</small>
        <small class="d-block mb-3 text-muted">Created by</small>
        <a href="https://craftincode.com"><img class="logo mb-3" src="gfx/cc.png"></a>
        </div>
        <div class="col-6 col-md">
        <h5>Products</h5>
        <ul class="list-unstyled text-small">
        <li><a class="text-muted" href="products.jsp">All products</a></li>
        <li><a class="text-muted" href="productDetails.jsp?id=123">Product details (ID: 123)</a></li>
        <li><a class="text-muted" href="userProducts.jsp">Your products</a></li>
        </ul>
        </div>
        <div class="col-6 col-md">
        <h5>User</h5>
        <ul class="list-unstyled text-small">
        <li><a class="text-muted" href="userProducts.jsp">My products</a></li>
        <li><a class="text-muted" href="login.jsp">Login</a></li>
        <li><a class="text-muted" href="register.jsp">Register</a></li>
        <li><a class="text-muted" href="userProfile.jsp">Edit your profile</a></li>
        </ul>
        </div>
        <div class="col-6 col-md">
        <h5>Admin stuff</h5>
        <ul class="list-unstyled text-small">
        <li><a class="text-muted" href="addProduct.jsp">Add product</a></li>
        <li><a class="text-muted" href="users.jsp">All users</a></li>
        </ul>
        </div>
        <div class="col-6 col-md">
        <h5>About</h5>
        <ul class="list-unstyled text-small">
        <li><a class="text-muted" href="about.jsp">About application</a></li>
        </ul>
        </div>
        </div>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="dist/js/bootstrap.min.js"></script>
        <script>window.jQuery || document.write('<script
        src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>

        </body>
        </html>
