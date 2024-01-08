<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
 <div class="container">
        <form action="" id="form">
            <h1>Sign Up</h1>
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username">
                <div class="error"></div>
            </div>
            <div class="input-group">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" >
                <div class="error"></div>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password">
                <div class="error"></div>
            </div>
            <div class="input-group">
                <label for="cpassword">Confirm Password</label>
                <input type="password" id="cpassword" name="cpassword">
                <div class="error"></div>
            </div>
            <div class="btn">
            <button type="submit"   id="submit" name="submit" >Register</button>
            </div>
        </form>
    </div>
   </section>