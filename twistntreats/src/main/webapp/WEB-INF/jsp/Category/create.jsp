<jsp:include page="../include/header.jsp"/>


<section >
  <form method="get" action="/category/createSubmit" >
  <input type="hidden" name="id" value="${form.id}">
 <div class="wrapper">
    <div class="container main" id="lgmain">
        <div class="row" id="lgrow">
            <div class="col-md-6 side-image">

                <!-------------      image     ------------->


            </div>
            <div class="col-md-6 right">

                <div class="input-box">

                   <header>Add Category</header>
                       <div class="mt-5">
                          <label for="categoryname" class="form-label">Category Name</label>
                           <input type="text" class="form-control" id="categoryName" name="categoryName" value="${form.categoryName}" required="">
                       </div>
                   <div class="mt-5">
                      <label for="description" class="form-label">Description</label>
                     <input type="text" class="form-control" id="categoryDescription" name="categoryDescription" value="${form.categoryDescription}"  required="">
                   </div>
                   <div class="input-field mt-5" style="align-items: center;">

                        <input type="submit" class="submit" value="Submit">
                   </div>

                </div>
            </div>
        </div>
    </div>
</div>
</form>
</section>

<jsp:include page="../include/footer.jsp"/>