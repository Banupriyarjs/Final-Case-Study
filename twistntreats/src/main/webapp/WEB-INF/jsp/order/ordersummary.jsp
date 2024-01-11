<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
<form action="/order/ordersummary">
   <main class="table" id="products_table" align=center>
    <c:if test="${empty ordersummary}">
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
              <h1>Order Summary</h1>


          </section>
          <c:if test="${not empty ordersummary}">
          <section class="table-body">
              <table >
                  <thead>
                      <tr>
                          <th> No. </th>
                          <th> Order # </th>
                          <th> Order Date </th>
                          <th> Total Price </th>

                      </tr>
                  </thead>
                  <tbody>
                       <c:forEach var="row" items="${ordersummary}" varStatus="counter">
                        <tr>
                        <td>${counter.count}</td>
                           <td><a href="/order/orderdetail/${row['orderId']}">${row['orderId']}</td>

                          <td style="max-width:100px ">${row['orderDate']}</td>
                           <td style="max-width:100px ">$${row['totalPrice']}</td>

                         </tr>
                      </c:forEach>
                  </tbody>

              </table>
          </section>
           </c:if>
      </main>
   </form>
   <section>



  <script src="/pub/js/search.js"></script>
<jsp:include page="../include/footer.jsp"/>