
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Menu</h1>
            </div>
        </div>
    </div>
</section>
<!-- <h1> ${categoryList.size()} size</h1> -->
<section>
    <c:if test="${not empty categoryList}" >
    <c:forEach items="${categoryList}" var="category">
        <section>
            <div class="bg-light2 pt-5 pb-5">
                <div class="row">
                    <div class="col-12">
                        <h1 class="m-0">${category.categoryName}</h1>
                    </div>
                </div>
            </div>
        </section>
    <c:if test="${not empty productList}" >
     <section>
     <table>
       <tr>
         <c:forEach items="${productList}" var="product">
         <c:if test="${category.id == product.categoryId }">
            <td class="col-4" >
                <div  style="width: 18rem;">
                    <img class="card-img-top" style="max-height:200px" src="${product.productUrl}" alt="Card image cap">
                    <div class="card-body text-center" >
                        <h5 class="card-title"><a href="/product/detail?id=${product.id}">${product.productName}</a></h5>
                             </div>
                </div>
             </td>
         </c:if>
        </c:forEach>
       </tr>
     </table>
    </c:if>
   </c:forEach>
   </section>
 </c:if>
</section>
<jsp:include page="../include/footer.jsp"/>