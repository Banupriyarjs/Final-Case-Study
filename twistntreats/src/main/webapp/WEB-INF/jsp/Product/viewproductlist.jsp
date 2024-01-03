
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp"/>

<section class="product">
    <c:if test="${not empty categoryList}" >
    <c:forEach items="${categoryList}" var="category">

        <div class="container py-5">
             <h1 class="text-center">${category.categoryName}</h1>
             <div class="row row-cols-1 row-cols-md-4 g-4 ">
                  <c:if test="${not empty productList}" >
                    <c:forEach items="${productList}" var="product">
                          <c:if test="${category.id == product.categoryId }">
                             <div class="col">
                                  <div class="card" style="width: 18rem;">
                                    <img style="max-height:200px" src="${product.productUrl}" class="card-img-top" alt="...">
                                        <div class="card-body text-center">
                                            <h5 class="card-title"><a href="/cart/detail?id=${product.id}">${product.productName}</a></h5>

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

<jsp:include page="../include/footer.jsp"/>