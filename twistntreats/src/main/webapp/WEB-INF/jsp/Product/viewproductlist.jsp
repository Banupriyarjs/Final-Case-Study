
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp"/>
<main class="classicMain">
<c:if test="${empty categoryList}">
<section >
<div class="container" align="center">
    <div class="message-container col-7 py-5 mt-7" align="center" >
        <h1>No products found with the given search term !</h1>
        <p><b>Please try again.</b></p>

    </div>
</div>
</section>
</c:if>
<section class="product">
    <c:if test="${not empty categoryList}" >
    <c:forEach items="${categoryList}" var="category">
        <div class="container py-5" >
             <h1 class="text-center">${category['categoryName']}</h1><br>
             <div class="row row-cols-1 row-cols-md-4 g-4 ">
                  <c:if test="${not empty productList}" >
                    <c:forEach items="${productList}" var="product">
                          <c:if test="${category['Id'] == product['categoryId'] }">
                             <div class="col">
                                  <div class="card" style="width: 18rem;">
                                    <img style="max-height:200px" src="${product['productUrl']}" class="card-img-top" alt="...">
                                        <div class="card-body text-center">
                                            <h6 class="card-title"><a href="/cart/detail?id=${product['Id']}">${product['productName']}</a></h6>

                                        </div>

                                    </div>
                            </div>

                        </c:if>
                         </c:forEach>
                    </c:if>
                </div>
            </div>

      </c:forEach>
   </c:if>

  </section>
</main>
<jsp:include page="../include/footer.jsp"/>