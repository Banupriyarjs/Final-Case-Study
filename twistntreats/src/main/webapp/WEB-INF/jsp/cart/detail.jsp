<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 ">
        <div class="row" id="product-row" align=center>
             <div class="col-12 product-image" >

                <h1 class="m-5 py-5">${product.productName}</h1>
            </div>
        </div>
    </div>
<section>
<form method="post" id="myform" >
        <input type="hidden" name="id" value="${product.id}">

  <section id="proddetails" class="section-p1">
        <!-- This section is for showing image-->
      <div class="single-pro-image">
        <!--<div class="single-pro-image" onclick="window.location.href='sproduct.html">-->
        <img src="${product.productUrl}" width="100%" id="MainImg" alt="">

        </div>
    </div>
      <!-- This section is for showing details-->
       <div class="single-pro-details">
       <!-- <h6>Donuts</h6> -->
        <h4>${product.productName}</h4>
        <h2>$${product.price}</h2>

        <input type="number" value="1" id="quantity" min="1" >

         <button class="normal" id="addToCartBtn">Add To Cart</button>
        <!-- <a href="#" id="addToCartBtn" class="btn btn-primary">Add to Cart</a> -->

        <h4>Product Details</h4>
        <span>${product.productDescription}</span>
       </div>
  </form>
    </section>

 <script>


    document.getElementById('addToCartBtn').addEventListener('click', function(event) {
        event.preventDefault();
         var quantityValue = document.getElementById('quantity').value;
         var productId = "${product.id}";
         var categoryId = "${product.categoryId}";
         var price = "${product.price}";
         var addToCartUrl = "/cart/addtocart?prodid=" + productId + "&catid=" + categoryId + "&price=" + price + "&quantity=" + quantityValue;


      //This is for hyperlink to direct
      //window.location.href = addToCartUrl;

       //This is for button control to redirect
        window.location.replace(addToCartUrl);

   });



  /*document.getElementById('myform').addEventListener('submit', function(event) {
           event.preventDefault();
          var quantityValue = document.getElementById('quantity').value;
          var productId = "${product.id}";
          var categoryId = "${product.categoryId}";
          var price = "${product.price}";
          var addToCartUrl = "/cart/addtocart?prodid=" + productId + "&catid=" + categoryId + "&price=" + price + "&quantity=" + quantityValue;
          // Redirect to the addToCartUrl or use it as needed
         //window.location.href = addToCartUrl;
         window.location.replace(addToCartUrl);
      });*/





 </script>
 <jsp:include page="../include/footer.jsp"/>