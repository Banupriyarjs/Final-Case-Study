 <section>
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
    </form>