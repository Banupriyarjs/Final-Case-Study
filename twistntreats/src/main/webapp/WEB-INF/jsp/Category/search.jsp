<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Category List</h1>
            </div>
        </div>
    </div>
</section>
<section>
<section class="pt-5 pb-5">
  <div class="container" align=center>


    <form action="/category/search">
      <label for="First Name">Category Name : </label>
         <input type="text" name="categoryname"  value="${categoryname}">
               <input class="btn btn-primary" type="submit" value="Submit">
    </form>

    <!-- Main Content -->
    <div class="container p-3 my-5 bg-light border border-primary">
        <!-- DataTable Code starts -->
      <c:if test="${not empty categories}">
        <table id="example" class="table table-striped nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>
            </thead>
            <c:forEach items="${categories}" var="category" varStatus="counter">
            <tbody>
                <tr>
                    <td>${counter.count}</td>
                    <td>${category.categoryName}</td>
                    <td>${category.categoryDescription}</td>
                    <td><a href="/category/edit/${category.id}">Edit</td>
                    <td><a href="/category/delete/${category.id}">Delete</td>
                    <td> <input class="btn btn-primary" type="submit" value="Edit"></td>
                     <td> <input class="btn btn-primary" type="submit" value="Delete"></td>

                </tr>
            </tbody>
          </c:forEach>
        </table>
    </div>
</c:if>
<div>
</section


<jsp:include page="../include/footer.jsp"/>