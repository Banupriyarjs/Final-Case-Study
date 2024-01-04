<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="maincontent" >
 <form method="get" action="/auth/registerSubmit">
 <div class="wrapper">
    <div class="container main" id="regmain">
        <div class="row" id="regrow">

            <div class="col-md-6 side-image">

                           <!-------------      image     ------------->


                       </div>


             <div class="col-md-6 right">

                <div class="input-box">

                   <header>Sign Up</header>

                   <div class="mt-3">
                         <label for="firstName" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${form.firstName}">

                    </div>
                     <c:if test="${errors.hasFieldErrors('firstName')}">
                         <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('firstName')}" var="error">
                                 ${error.defaultMessage}<br>
                            </c:forEach>
                          </div>
                     </c:if>
                   <div class="mt-3">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">

                    </div>
                     <c:if test="${errors.hasFieldErrors('lastName')}">
                                             <div style="color:red">
                                                <c:forEach items="${errors.getFieldErrors('lastName')}" var="error">
                                                     ${error.defaultMessage}<br>
                                                </c:forEach>
                                              </div>
                                         </c:if>
                      <div class="mt-3">
                        <label for="address" class="form-label">Address</label>
                          <input type="text" class="form-control" id="address" name="address" value="${form.address}">

                      </div>
                <c:if test="${errors.hasFieldErrors('address')}">
                                        <div style="color:red">
                                           <c:forEach items="${errors.getFieldErrors('address')}" var="error">
                                                ${error.defaultMessage}<br>
                                           </c:forEach>
                                         </div>
                                    </c:if>
                 <div class="mt-3">
                  <label for="city" class="form-label">City</label>
                     <input type="text" class="form-control" id="city" name="city" value="${form.city}">

                  </div>
                  <c:if test="${errors.hasFieldErrors('city')}">
                                          <div style="color:red">
                                             <c:forEach items="${errors.getFieldErrors('city')}" var="error">
                                                  ${error.defaultMessage}<br>
                                             </c:forEach>
                                           </div>
                                      </c:if>
                <div class="mt-3">
                 <label for="areaCode" class="form-label">Area Code</label>
                   <input type="text" class="form-control" id="areaCode" name="areaCode" value="${form.areaCode}">

               </div>
                <c:if test="${errors.hasFieldErrors('areaCode')}">
                                        <div style="color:red">
                                           <c:forEach items="${errors.getFieldErrors('areaCode')}" var="error">
                                                ${error.defaultMessage}<br>
                                           </c:forEach>
                                         </div>
                                    </c:if>
               <div class="mt-3">
                   <label for="phone" class="form-label">Phone No.</label>
                  <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">

               </div>
                <c:if test="${errors.hasFieldErrors('phone')}">
                   <div style="color:red">
                   <c:forEach items="${errors.getFieldErrors('phone')}" var="error">
                     ${error.defaultMessage}<br>
                  </c:forEach>
                 </div>
              </c:if>
             <div class="mt-3">
             <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="${form.email}">

               </div>
                <c:if test="${errors.hasFieldErrors('email')}">
                     <div style="color:red">
                        <c:forEach items="${errors.getFieldErrors('email')}" var="error">
                          ${error.defaultMessage}<br>
                        </c:forEach>
                       </div>
                </c:if>
               <div class="mt-3">
               <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" name="password" value="${form.password}">

                </div>
               <c:if test="${errors.hasFieldErrors('password')}">
                 <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('password')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                  </div>
                </c:if>

                <div class="mt-3">
                 <label for="confirmPassword" class="form-label">Confirm Password</label>
                  <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="${form.confirmPassword}">

                  </div>
                 <c:if test="${errors.hasFieldErrors('confirmPassword')}">
                   <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('confirmPassword')}" var="error">
                         ${error.defaultMessage}<br>
                     </c:forEach>
                    </div>
                    </c:if>

                   <div class="input-field mt-5"  style="align-items: center;" >

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











