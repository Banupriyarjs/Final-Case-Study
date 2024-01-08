<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<c:if test="${not empty cartlist}">
    <section id="cart" class="section-p1">
    <div id="divcart">
      <h3>Cart</h3>
       <table width="100%">
           <thead>
           <tr>
                <td>Treats</td>
                 <td>Name</td>
                  <td>Quantity</td>
                  <td>Price</td>
                  <td>Delete</td>
           </tr
           </thead>
           <tbody> <c:set var="totalPrice" value="0" />
             <c:forEach var="row" items="${cartlist}">
               <tr>
                <td><img src="${row['productUrl']}" style="max-width:100px"></td>
                 <td>${row['productName']}</td>
                    <td><input type=number value=${row['quantity']}></td>

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
    </c:if>

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

           <a href="/cart/placeorder?userId=${userId}" class="btn btn-primary">Place Order</a>

    </div>
    </section>
<jsp:include page="../include/footer.jsp"/>