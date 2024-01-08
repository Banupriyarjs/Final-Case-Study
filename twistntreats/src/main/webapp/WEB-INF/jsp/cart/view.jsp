<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<main >
 <c:if test="${empty cartlist}">
<section >
<div class="container" align="center">
    <div class="message-container col-6" align="center" >
        <h1>No Items in Cart</h1>
        <p>Your shopping cart is currently empty.</p>

    </div>
</div>
</section>
</c:if>
<section >
<form method="post" >
    <c:if test="${not empty cartlist}">
     <c:set var="totalPrice" value="0" />
       <div class="cartdetails">
        <h1>Shopping Cart</h1>
     <div class="project">
            <div class="shop">

         <c:forEach var="row" items="${cartlist}">
               <div class="box">
                <img src="${row['productUrl']}"  alt="">
                 <div  class="content">
                    <h3>${row['productName']}</h3>
                    <h5 >Price : </h5><span class="price" id="price_${row['productId']}">$${row['price']}</span>
                    <p class="unit"><h6>Quantity:
                                   <input class="number-input" min="1" type="number" id="quantity_${row['productId']}" onchange="updateQuantity(this)"
                               data-product-id="${row['productId']}" value="${row['quantity']}"></h6></p>
                    <c:set var="totalPrice" value="${totalPrice+row['quantity']*row['price']}" />
                    <c:set var="userId" value="${row['userId']}" />
                    <p class="btn-area">

                        <a style="color:white;" href="/cart/delete?orderId=${row['orderId']}&productId=${row['productId']}"> <i class="fa fa-trash"> Remove</i></a>
                    <!--   <a class="btn-primary" href="/cart/delete?orderId=${row['orderId']}&productId=${row['productId']}">Delete</a></td> -->

                    </p>
               </div>
           </div>
        </c:forEach>
     </div>
            <div class="right-bar">
                <p class="subtotal-paragraph"><span>Subtotal</span><span id="subtotal" >$${totalPrice}</span></p>
                <hr>
                <p > <span >Tax</span><span>Free</span></p>
                <hr>
                <p><span>Shipping</span><span>Free</span></p>
                <hr>
                <p><span><b>Total</b></span><span id="total"><b>$${totalPrice}</b></span></p>
                <a href="/cart/placeorder?userId=${userId}"><i class="fa fa-shopping-cart"></i> Place Order</a>


                <!-- <button class="btn-area" id="placeorder"> Place Order</button> -->
            </div>
 </div>
</div>
</c:if>
</form>
</section>

</main>



<script>
         function updateQuantity(input) {
                    var productId = input.dataset.productId;
                    var quantity = input.value;

                    //alert(productId);
                    //alert(quantity);



                    // Update price and total dynamically
                    var price = parseFloat(document.getElementById('price_' + productId).innerText.replace('$', ''));
                  // alert(price);
                    var subtotalElement = document.getElementById('subtotal');
                    var totalElement = document.getElementById('total');
                    //alert(subtotalElement);
                    //alert(totalElement);
                    var subtotal = quantity * price;
                    subtotalElement.innerText = '$' + subtotal.toFixed(2);

                    // Update total by recalculating the total of all products
                    var total = 0;
                    var quantityInputs = document.querySelectorAll('[id^="quantity_"]');
                    quantityInputs.forEach(function (quantityInput) {
                        var id = quantityInput.dataset.productId;
                        var price = parseFloat(document.getElementById('price_' + id).innerText.replace('$', ''));
                        total += parseFloat(quantityInput.value) * price;
                    });
                    totalElement.innerText = '$' + total.toFixed(2);


                }


        // addEventListener method to place order
         document.getElementById('placeorder').addEventListener('click', function(event) {
         event.preventDefault();
         window.location.href("/cart/placeorder?userId=${userId}");
     });
</script>

<jsp:include page="../include/footer.jsp"/>

