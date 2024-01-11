<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
<form action="/order/orderdetail">
   <main class="table" id="products_table" align=center>
    <c:if test="${empty orderdetails}">
   <section >
   <div class="container" align="center">
       <div class="message-container col-6" align="center" >
           <h1>No Orders Yet</h1>
           <p></p>

       </div>
   </div>

   </section>
   </c:if>
          <section class="table-header">
              <h1>Order Details for Order # ${orderId}</h1>


          </section>
          <c:if test="${not empty orderdetails}">
          <c:set var="totalPrice" value="0" />
          <section class="table-body">
              <table >
                  <thead>
                      <tr>
                          <th> No. </th>
                          <th> Product </th>
                          <th> Product Name </th>
                          <th> Order Date </th>
                          <th> Quantity </th>
                           <th> Price </th>
                            <th> Total Price </th>
                      </tr>
                  </thead>
                  <tbody>
                       <c:forEach var="row" items="${orderdetails}" varStatus="counter">
                        <tr>
                        <td>${counter.count}</td>
                            <td><img style="max-width:200px" src="${row['productUrl']}" }></td>
                            <td style="max-width:100px ">${row['productName']}</td>
                             <td style="max-width:100px ">${row['orderDate']}</td>
                              <td style="max-width:100px ">${row['quantity']}</td>
                             <td style="max-width:100px ">${row['price']}</td>
                              <td style="max-width:100px ">${row['totalPrice']}</td>
                             <c:set var="totalPrice" value="${totalPrice+row['quantity']*row['price']}" />
                         </tr>
                      </c:forEach>

                  </tbody>

              </table>
              <div align="center" id="divTotal"><p id="total-price">Total Amount : $${totalPrice}</p></div>
          </section>
           </c:if>
      </main>
   </form>
   <section>



  <script src="/pub/js/search.js"></script>
<jsp:include page="../include/footer.jsp"/>