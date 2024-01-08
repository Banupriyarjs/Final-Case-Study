<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Login</h1>
            </div>
        </div>
    </div>
</section>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="post" action="/auth/loginSubmit">

                    <div class="mt-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username">
                    </div>

                    <div class="mt-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="text" class="form-control" id="password" name="password">
                    </div>

                    <button type="submit" class="btn btn-primary mt-4">Submit</button>
                </form>

            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>