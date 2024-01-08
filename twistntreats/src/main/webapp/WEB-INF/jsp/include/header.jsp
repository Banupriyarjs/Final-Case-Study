<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Twist 'n' Treats</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

     <link href="https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Bungee+Spice&family=Nabla&family=Rubik:wght@300&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
     <link rel="stylesheet" href="/pub/css/index.css">
      <link rel="stylesheet" href="/pub/css/cart.css">
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="/pub/css/search.css">

  </head>
  <body style="min-height:100%">
  <section >
     <nav class="navbar navbar-expand-lg" id="nav-section">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Twist 'n' Treats</a>

              <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0" >
                  <li class="nav-item">
                    <a class="nav-link"  href="/">Home</a>
                  </li>

                         <sec:authorize access="!isAuthenticated()">
                                   <li class="nav-item">
                                       <a class="nav-link" href="/auth/login">Login</a>
                                  </li>
                              <!--   <li class="nav-item">
                                     <a class="nav-link" href="/auth/register">Sign up</a>
                                 </li> -->
                        </sec:authorize>
                         <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarCategory" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Category
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarCategory">

                                        <a class="dropdown-item" href="/category/create">Add</a>
                                        <a class="dropdown-item" href="/category/search">Search</a>
                                   </div

                              </li>
                               <li class="nav-item dropdown">
                                 <a class="nav-link dropdown-toggle" href="#" id="navbarProduct" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                   Product
                                 </a>
                                <div class="dropdown-menu" aria-labelledby="navbarProduct">
                                     <a class="dropdown-item" href="/product/create">Add</a>
                                      <a class="dropdown-item" href="/product/search">Search</a>
                                 </div

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
                <form class="d-flex" role="search" action="/product/viewproductlist">
                  <input class="px-2 search" type="text"  name="productName" value="${productName}" aria-label="Search">
                  <button class="btn0"  type="submit">Search</button>
                </form>
              </div>
            </div>
       </nav>
</section>
<!--
 <script>

      document.getElementById('search').addEventListener('click', function(event) {
         event.preventDefault();
         var addToCartUrl = "/product/viewproductlist";
         // Redirect to the addToCartUrl or use it as needed
        window.location.href = addToCartUrl;
        window.location.replace(addToCartUrl);
     });
  </script>
-->