<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Create Product</h1>
            </div>
        </div>
    </div>
</section>
<section class="pt-5 pb-5">
    <div class="container">
     <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
        <form method="post" action="/product/createSubmit"  enctype="multipart/form-data">
        <input type="hidden" name="id" value="${form.id}">
            <div class="mt-3">
                <label for="productName" class="form-label">Product Name</label>
                <input type="text" class="form-control" name="productName" id="productName"  >

            </div>

            <div class="mt-3">
               <label for="productDescription" class="form-label">Product Description</label>
               <input type="text" class="form-control" id="productDescription" name="productDescription" >
              </div>
               <div class="mt-3">
                    <label for="category" class="form-label">Select Category</label>
                       <select name="categoryId" id="categoryId" class="form-control">

                          <option value="0"><-------Select-------></option>
                          <c:if test="${not empty categoryList}">
                              <c:forEach items="${categoryList}" var="list">
                                  <option value="${list.id}" text="${list.id}">${list.categoryName}
                                   <c.out value="${list.id}" />
                                    </option>
                               </c:forEach>
                              </c:if>

                             </select>
                </div>

                <div class="mt-3">
                    <label for="city" class="form-label">Price</label>
                     <input type="text" class="form-control" id="price" name="price"  >
                </div>

                   <div class="mt-3">
                                     <label for="imageUrl" class="form-label">Image URL</label>
                                      <input type="file" name="file" />
                                 </div>

                <div align="center">
            <button type="submit" class="btn btn-primary" >Save</button>
             </div>
        </form>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>