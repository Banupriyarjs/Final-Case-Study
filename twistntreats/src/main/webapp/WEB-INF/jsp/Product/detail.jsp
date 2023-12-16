<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">View Product</h1>
            </div>
        </div>
    </div>
<section>
<form method="get" >
        <input type="hidden" name="id" value="${product.id}">

     <section align="center">
     <table>
       <tr>
        <td >
              <div>
              <h1><p class="card-text">${product.productName}</p></h1>
              </div>
                <div  style="width: 18rem;">
                    <img class="card-img-top" style="max-height:200px" src="${product.productUrl}" alt="Card image cap">
                    <div class="card-body">


                         <p class="card-text">${product.productDescription}</p>
                        <p class="card-test">$${product.price}</p>
                        <a href="/product/addtocart?id=${product.id}" class="btn btn-primary">Add to Cart</a>
                    </div>
                </div>
             </td>

       </tr>
     </table>

   </section>

</section>

</form>

 <jsp:include page="../include/footer.jsp"/>