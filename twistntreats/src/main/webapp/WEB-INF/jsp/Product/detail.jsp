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
<form method="post" >
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
                        <p id="Price" name="Price" class="card-test">${product.price}</p>

                         <div class="mt-3">
                              <label for="Quantity" class="form-label">Quantity</label>
                                <input type="number" value="1" class="form-control" id="quantity" name="quantity"  >

                           </div>

                            <a href="#" id="addToCartBtn" class="btn btn-primary">Add to Cart</a>


                    </div>
                </div>
             </td>

       </tr>
     </table>

   </section>

</section>

</form>
 <script>
     document.getElementById('addToCartBtn').addEventListener('click', function() {
         var quantityValue = document.getElementById('quantity').value;
         var productId = "${product.id}";
         var categoryId = "${product.categoryId}";
         var price = "${product.price}";

         var addToCartUrl = "/order/addtocart?prodid=" + productId + "&catid=" + categoryId + "&price=" + price + "&quantity=" + quantityValue;

         // Redirect to the addToCartUrl or use it as needed
         window.location.href = addToCartUrl;
     });
 </script>
 <jsp:include page="../include/footer.jsp"/>