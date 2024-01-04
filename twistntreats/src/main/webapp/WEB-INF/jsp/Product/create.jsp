<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<section >
  <form method="post" action="/product/createSubmit"  enctype="multipart/form-data">
         <input type="hidden" name="id" value="${form.id}">

 <div class="wrapper">
    <div class="container main" id="regmain">
        <div class="row" id="prodgrow">

            <div class="col-md-6 side-image">

                           <!-------------      image     ------------->


                       </div>
                       <div class="col-md-6 right">

                <div class="input-box">

                   <header>Create Product</header>
                       <div class="mt-3">
                         <label for="productName" class="form-label">Product Name</label>
                        <input type="text" class="form-control" id="productName" name="productName" value="${form.productName}">

                    </div>
                   <div class="mt-3">
                          <label for="productDescription" class="form-label">Product Description</label>
                        <input type="text" class="form-control" id="productDescription" name="productDescription" value="${form.productDescription}">

                    </div>
                      <div class="mt-3">
                        <label for="category" class="form-label">Select Category</label>
                        <select name="categoryId" id="categoryId" class="form-control" align="center" >
                           <option value="0">(Please select a Category)</option>
                                <c:if test="${not empty categoryList}">
                                     <c:forEach items="${categoryList}" var="list">
                                      <option value="${list.id}" text="${list.id}" ${list.id eq form.categoryId ? 'selected' : ''}>${list.categoryName}</c.if>
                                       <c.out value="${list.id}" />
                                     </option>
                                    </c:forEach>
                                  </c:if>
                           </select>
                      </div>
                 <div class="mt-3">
                  <label for="price" class="form-label">Price</label>
                     <input type="text" class="form-control" id="price" name="price" value="${form.price}">

                  </div>
               <c:if test="${not empty form.productUrl}">
                    <div class="mt-3">
                    <label for="product" class="form-label">Product Image </label>
                     <img id="image" src="${form.productUrl}" alt="Image" style="width:100px">
                   </div>
                </c:if>
             <div class="mt-4">
                 <label for="imageUrl" class="form-label">Product URL</label>
                <input type="file" class="form-control" id="file"  name="file" src="${form.productUrl}" />
              </div>

               <div class="input-field mt-5" style="align-items: center;">
                        <input type="submit" class="submit" value="Save">
               </div>

                </div>
            </div>
        </div>
    </div>
</div>
</form>
</section>




<jsp:include page="../include/footer.jsp"/>