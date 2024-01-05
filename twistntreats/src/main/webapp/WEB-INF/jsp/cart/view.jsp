<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
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
                    <h4>Price : $${row['price']}</h4>
                    <p class="unit">Quantity: <input type="number" id="quantity" value=${row['quantity']}></p>
                    <c:set var="totalPrice" value="${totalPrice+row['quantity']*row['price']}" />
                    <c:set var="userId" value="${row['userId']}" />
                    <p class="btn-area">

                        <a href="/cart/delete?orderId=${row['orderId']}&productId=${row['productId']}"> <i class="fa fa-trash"> Remove</i></a>
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
</section>

<!-- <section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Cart</h1>
            </div>
        </div>
    </div>
</section>

<c:if test="${empty cartlist}">
<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">No items in the cart</h1>
            </div>
        </div>
    </div>
</section>
</c:if>
<form method="post" >
<c:if test="${not empty cartlist}">
    <section id="cart" class="section-p1">

    <div id="divcart">
      <h3>Cart</h3>
       <table border="1" >
           <thead>
           <tr>
                <td>Treats</td>
                 <td>Name</td>
                  <td>Quantity</td>
                  <td>Price</td>
                  <td>Delete</td>
           </tr
           </thead>
           <tbody > <c:set var="totalPrice" value="0" />
             <c:forEach var="row" items="${cartlist}">
               <tr >
                <td><img src="${row['productUrl']}" style="max-width:100px;max-height:70px;align:center"></td>
                 <td>${row['productName']}</td>
                    <td><input type="number" id="quantity" value=${row['quantity']}></td>

                 <td>$${row['price']} </td>
                 <td><a href="/cart/delete?orderId=${row['orderId']}&productId=${row['productId']}">Delete</a></td>
                 <c:set var="totalPrice" value="${totalPrice+row['quantity']*row['price']}" />
            <c:set var="userId" value="${row['userId']}" />
              </tr>
             </c:forEach>

           </tbody>
       </table>
      </div>
    </section>

<section id="cart-add" class="section-p1">
        <div id="coupon">

        </div>
    <div id="subtotal">
        <h3>Cart Totals</h3>
        <table>
            <tr>
                <td>Cart SubTotals</td>
                <td>$${totalPrice} </td>
            </tr>
            <tr>
                <td>Tax</td>
                <td>Free</td>
            </tr>
            <tr>
                <td><strong>Total</strong></td>
                <td><strong>$${totalPrice} </strong></td>
            </tr>
        </table>
           <button class="normal" id="placeorder">Place Order</button>
           <a href="/cart/placeorder?userId=${userId}" class="btn btn-primary">Place Order</a>

    </div>
    </section>

    </c:if>
    </form> -->

 <script>

      document.getElementById('placeorder').addEventListener('click', function(event) {
         event.preventDefault();
         window.location.replace("/cart/placeorder?userId=${userId}");
     });
</script>
<jsp:include page="../include/footer.jsp"/>

