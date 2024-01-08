<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<main >
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
                    <h5 id="price">Price : $${row['price']}</h5>
                    <p class="unit"><h6>Quantity: <input type="number" id="quantity" value=${row['quantity']} ></h6></p>
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
                <p><span>Subtotal</span><span>$${totalPrice}</span></p>
                <hr>
                <p><span>Tax</span><span>Free</span></p>
                <hr>
                <p><span>Shipping</span><span>Free</span></p>
                <hr>
                <p><span><b>Total</b></span><span><b>$${totalPrice}</b></span></p>
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
       function handleInputChange() {
            var inputValue = document.getElementById('quantity').value;
            if(inputValue<=0)
            alert('Quantity must be greater than zero');
            alert(document.getElementById('price').innerText);

        }
      document.getElementById('placeorder').addEventListener('click', function(event) {
         event.preventDefault();
         window.location.href("/cart/placeorder?userId=${userId}");
     });
</script>
<jsp:include page="../include/footer.jsp"/>

