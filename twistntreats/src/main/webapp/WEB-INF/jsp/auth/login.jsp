<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section >
<form method="post" action="/auth/loginSubmit">
 <div class="wrapper">
    <div class="container main" id="lgmain">
        <div class="row" id="lgrow">
            <div class="col-md-6 side-image">

                <!-------------      image     ------------->


            </div>
            <div class="col-md-6 right">

                <div class="input-box">

                   <header>Login</header>
                   <div class="input-field">
                        <input type="text" class="input" id="username" name="username" required="" autocomplete="off">
                        <label for="email">Email</label>
                    </div>
                   <div class="input-field">
                        <input type="password" class="input" id="password" name="password" required="">
                        <label for="pass">Password</label>
                    </div>
                   <div class="input-field">

                        <input type="submit" class="submit" value="Submit">
                   </div>
                   <div class="login">
                    <span>Don't have an account? <a href="#">Register here</a></span>
                   </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</section>
<jsp:include page="../include/footer.jsp"/>