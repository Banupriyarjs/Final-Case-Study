<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
<form action="/product/search">
   <main class="table" id="customers_table" align=center>
          <section class="table-header">
              <h1>Products</h1>
              <div class="inputgroup">
               <input type="text" name="productname"  id="inputsearch"  >

                <a href="/product/search"> <img src="/pub/images/search.png" alt="" ></a>
              </div>

          </section>
          <c:if test="${not empty products}">
          <section class="table-body">
              <table >
                  <thead>
                      <tr>
                          <th> No. </th>
                          <th>Product </th>
                          <th> Product Name </th>
                          <th> Description </th>
                          <th> Category </th>
                          <th> Price </th>
                          <th>Edit</th>
                           <th>Delete</th>
                      </tr>
                  </thead>
                  <tbody>
                       <c:forEach var="row" items="${products}" varStatus="counter">
                        <tr>
                        <td>${counter.count}</td>
                            <td><img  style="max-width:70px;max-height:70px;align:center" src="${row['productUrl']}" }></td>

                          <td>${row['productName']}</td>
                           <td style="max-width:200px ">${row['productDescription']}</td>
                              <td>${row['categoryName']}</td>
                              <td>$${row['price']}</td>
                              <td><a href="/product/edit/${row['productId']}">Edit</td>
                               <td><a href="/product/delete/${row['productId']}">Delete</td>
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