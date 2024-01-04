<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Products</h1>
            </div>
        </div>
    </div>
</section>

<section class="pt-5 pb-5">
  <div class="bg-light2 pt-5 pb-5" align=center>


    <form action="/product/search">
      <label for="Product Name Name">Product Name : </label>
         <input type="text" name="productname"   value="${productname}"  >
          <div class="input-field mt-5 col-2">

        <input type="submit" class="submit" value="Submit">
      </div>


    </form>

    <!-- Main Content -->
    <div class="container p-3 my-5 bg-light border border-primary">
        <!-- DataTable Code starts -->
      <c:if test="${not empty products}">
        <table id="example" class="table table-striped nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Product Name</th>
                    <th>Description</th>
                     <th>Category</th>
                     <th>Price</th>
                     <th>Product URL</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>
            </thead>


            <tbody>
             <c:forEach var="row" items="${products}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${row['productName']}</td>
                    <td style="max-width:200px ">${row['productDescription']}</td>
                    <td>${row['categoryName']}</td>
                   <td>${row['price']}</td>
                     <td><img  style="max-width:70px;max-height:70px;align:center" src="${row['productUrl']}" }></td>

                    <td><a href="/product/edit/${row['productId']}">Edit</td>
                    <td><a href="/product/delete/${row['productId']}">Delete</td>

                </tr>
                  </c:forEach>
            </tbody>
        </table>
   </c:if>
<div>
</section


<jsp:include page="../include/footer.jsp"/>