<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


    <form action="/category/search">
   <main class="table" id="categories_table" >
          <section class="table-header">
              <h1>Categories</h1>
              <div class="inputgroup">
               <input type="text" name="categoryname"  id="categoryname" value="${categoryname}" placeholder="Search Category...">

                <a href="/product/search"> <img src="/pub/images/search.png" alt="" ></a>

              </div>
 <!-- <input class="submit" type="submit" value="Submit"> -->
          </section>
          <c:if test="${not empty categoryList}">
          <section class="table-body">
              <table >
                  <thead>
                     <tr>
                       <th>No.</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Edit</th>
                         <th>Delete</th>

                    </tr>
                  </thead>

                 <c:forEach items="${categoryList}" var="category" varStatus="counter">
                  <tbody>
                       <tr>
                         <td>${counter.count}</td>
                         <td>${category.categoryName}</td>
                         <td>${category.categoryDescription}</td>
                         <td><a href="/category/edit/${category.id}">Edit</td>
                        <td><a href="/category/delete/${category.id}">Delete</td>
                      </tr>
                   </tbody>
                  </c:forEach>


              </table>
          </section>
           </c:if>
      </main>
   </form>

   <script src="/pub/js/search.js"></script>



<jsp:include page="../include/footer.jsp"/>