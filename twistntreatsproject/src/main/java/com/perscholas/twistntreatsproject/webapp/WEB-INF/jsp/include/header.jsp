<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Twist 'n' Treats </title>

    <link href="/pub/css/global-style.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <!-- DataTable CSS  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0-alpha3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.1/css/responsive.bootstrap5.min.css">

     <!-- Added for Add To Cart Page -->
     <link href="/pub/css/cart.css" rel="stylesheet">
         <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
             <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/auth/login">Login</a>
                </li>
           <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/auth/register">Sign up</a>
                </li>
             </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link" href="/category/create">Add Category</a>
                </li>
                 <li class="nav-item">
                                <a class="nav-link" href="/category/search">Search Category</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/product/create">Add Product</a>
                </li>
            <li class="nav-item">
                   <a class="nav-link" href="/product/search">Search Product</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="/product/viewproductlist">Menu</a>
              </li>
              <li class="nav-item">
                   <a class="nav-link" href="/cart/viewcart">Cart</a>
               </li>
             <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                  <a class="nav-link" href="/auth/logout">Logout</a>
               </li>

             </sec:authorize>
            </ul>
        </div>
    </div>
</nav>