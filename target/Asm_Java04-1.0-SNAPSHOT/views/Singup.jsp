<%--<%@taglib uri="" prefix="c"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="form_login/Login.css">
    <!-- Nhúng Bootstrap từ CDN -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style type="text/css">
        .bg-dark {
            color: black;
            background: white;
        }

        .back {
            display: block;
            width: 100%;
            padding: 0.5rem 1rem;
            font-size: 1.25rem;
            line-height: 1.5;
            border-radius: 0.3rem;
        }

    </style>
</head>
<body>
<form action="" method="post">
    <section class="vh-100" style="background-color: #508bfc;">
        <div class="container py-5 h-100">
            <div
                    class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <h3 class="mb-5">Sign up</h3>

                            <div class="form-group">
                                <%--                                <mark class="bg-white text-black" style="background-color: white;">${loginStatus}</mark>--%>
                                <!-- -->

                            </div>

                            <div class="form-outline mb-4">
                                <input type="text" id="typeEmailX-2" name="username"
                                       value="" class="form-control form-control-lg"
                                       placeholder="Username"/>
                                <%--                                <label class="text-danger">${messUserName}</label>--%>


                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" id="typePasswordX-2" name="password"
                                       value=""
                                       class="form-control form-control-lg" placeholder="Password"/>
                                <%--                                <label class="text-danger">${messPass}</label>--%>

                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" id="typePasswordX-2" name="repeat password"
                                       value=""
                                       class="form-control form-control-lg" placeholder="Repeat Password"/>
                                <%--                                <label class="text-danger">${messPass}</label>--%>

                            </div>


                            <button class="btn btn-success btn-lg btn-block" type="submit">Sing up</button>

                            <hr class="my-4">

                            <a href="/login" class="back text-decoration-none btn btn-danger "> Back to Login</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</form>
</body>
</html>