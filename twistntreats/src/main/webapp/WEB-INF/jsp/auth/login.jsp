<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<main>
<section >
<form method="post" action="/auth/loginSubmit">

  <c:if test="${param['error'] eq ''}">
      <section class="pt-5">
          <div class="container">
              <div class="row justify-content-center">
                  <div class="col-3">
                      <div class="alert alert-danger w-100 mb-0">Invalid Username or Password</div>
                  </div>
              </div>
          </div>
      </section>
  </c:if>

   <div class="wrapper">
    <div class="container main" id="lgmain">
        <div class="row" id="lgrow">
            <div class="col-md-6 side-image">

                <!-------------      image     ------------->


            </div>
            <div class="col-md-6 right">

                <div class="input-box">

                   <header>Login</header>
                   <div class="input-field mt-5">
                        <input type="text" class="input" id="username" name="username" required="" autocomplete="off">
                        <label for="email">Email</label>
                    </div>
                   <div class="input-field mt-5">
                        <input type="password" class="input" id="password" name="password" required="">
                        <label for="pass">Password</label>
                    </div>
                   <div class="input-field mt-5" style="align-items: center;">

                        <input type="submit" class="submit" value="Submit">
                   </div>
                   <div class="login">
                    <span>Don't have an account? <a  href="/auth/register">Register here</a></span>
                   </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</section>
</main>
<jsp:include page="../include/footer.jsp"/>