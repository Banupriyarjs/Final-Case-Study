<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Add Category</h1>
            </div>
        </div>
    </div>
</section>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="get" action="/category/createSubmit" >
                  <input type="hidden" name="id" value="${form.id}">
                    <div class="mt-3">
                        <label for="categoryname" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="categoryName" name="categoryName" value="${form.categoryName}">
                    </div>

                    <div class="mt-3">
                        <label for="description" class="form-label">Description</label>
                        <input type="text" class="form-control" id="categoryDescription" name="categoryDescription" value="${form.categoryDescription}">
                    </div>

                    <button type="submit" class="btn btn-primary mt-4">Submit</button>
                </form>

            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>