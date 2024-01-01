
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
                                            <h5 class="card-title"><a href="/product/details1?id=${product.id}">${product.productName}</a></h5>

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
<section class="product">
        <div class="container">
          <div class="row py-5 ">
                <div class="col-lg-5 m-auto text-center">
                    <h1>What's Trending</h1>
                    <h6 style="color:red;">Be Healthy Organic Food</h6>
                </div>
          </div>
            <div class="row">
                <div class="col-lg-3 text-center">
                    <div class="card border-0 bg-light">
                        <div class="card-body">
                            <img src="/pub/images/donut2.avif" class="img-fluid" alt="">
                        </div>
                    </div>
                    <h6>Donut</h6>
                    <p>$5.99</p>

                </div>
                <div class="col-lg-3 text-center">
                    <div class="card border-0 bg-light">
                        <div class="card-body">
                            <img src="/pub/images/glaced_strawberry.avif" class="img-fluid" alt="">
                        </div>
                    </div>
                    <h6>Glaced Strawberry</h6>
                    <p>$5.99</p>

                </div>
                <div class="col-lg-3 text-center">
                    <div class="card border-0 bg-light">
                        <div class="card-body">
                            <img src="/pub/images/glaced_strawberry.avif" class="img-fluid" alt="">
                        </div>
                    </div>
                    <h6>Brocoli</h6>
                    <p>$5.99</p>

                </div>
                <div class="col-lg-3 text-center">
                    <div class="card border-0 bg-light">
                        <div class="card-body">
                            <img src="/pub/images/donut2.avif" class="img-fluid" alt="">
                        </div>
                    </div>
                    <h6>Grapes</h6>
                    <p>$5.99</p>

                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 text-center m-auto">
                    <button class="btn1">Click For More</button>
                </div>
            </div>
        </div>

      </section>
<jsp:include page="../include/footer.jsp"/>