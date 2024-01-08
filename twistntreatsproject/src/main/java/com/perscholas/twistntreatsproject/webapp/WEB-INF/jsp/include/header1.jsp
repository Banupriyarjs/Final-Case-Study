<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Twist 'n' Treats</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Bungee+Spice&family=Nabla&family=Rubik:wght@300&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
     <link rel="stylesheet" href="/pub/css/index.css">
  </head>
  <body>
     <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Twist 'n' Treats</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0" >
                  <li class="nav-item">
                    <a class="nav-link active"  href="#">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link"href="/auth/login">Login</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link"  href="/auth/register1">Sign up </a>

                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/category/create">Add Category</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/category/search">Search Category</a>
                  </li>
                </ul>
                <form class="d-flex" role="search">
                  <input class="px-2 search" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn0"  type="submit">Search</button>
                </form>
              </div>
            </div>
       </nav>