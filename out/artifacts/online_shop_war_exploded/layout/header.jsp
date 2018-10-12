    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Movies Ninja</title>

        <%-- DOŁĄCZENIE CSSÓW BOOTSTRAPOWYCH--%>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="dist/css/bootstrap.min.css" crossorigin="anonymous">

        <%-- DOŁĄCZENIE CSS LAYOUTU --%>
        <link href="css/product.css" rel="stylesheet">
        </head>
        <body>
        <nav class="site-header sticky-top py-1">
        <div class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="py-2" href="index.jsp">
        <img class="logo" src="gfx/logo.png" alt="">
        </a>
        <a class="py-2 d-none d-md-inline-block" href="index.jsp">Home</a>
        <a class="py-2 d-none d-md-inline-block" href="products.jsp">All products</a>
        <a class="py-2 d-none d-md-inline-block" href="userProducts.jsp">My products</a>
        <a class="py-2 d-none d-md-inline-block" href="users.jsp">[ADMIN] Users</a>
        <a class="py-2 d-none d-md-inline-block" href="addProduct.jsp">[ADMIN] Add product</a>
        <a class="py-2 d-none d-md-inline-block" href="about.jsp">About</a>
        <a class="py-2 d-none d-md-inline-block" href="userProfile.jsp">User profile</a>
            <%String username = (String) request.getSession(false).getAttribute("username");
                if(username!= null) { %>
        <a class="py-2 d-none d-md-inline-block" href="logout">Logout (<%=username%>)</a>
            <%}%>
        </div>
        </nav>
        </body>
        </html>