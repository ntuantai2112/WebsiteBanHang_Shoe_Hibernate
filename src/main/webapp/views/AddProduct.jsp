<%--
  Created by IntelliJ IDEA.
  User: LENOVO T560
  Date: 17/11/2023
  Time: 03:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zay Shop - AddProduct </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="../assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.ico">

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/templatemo.css">
    <link rel="stylesheet" href="../assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="../assets/css/fontawesome.min.css">


</head>
<body>

<!-- Header -->
<jsp:include page="Header.jsp"></jsp:include>

<div class="container mb-3">
    <div class="card mt-5">
        <div class="card-header">Thêm mới sản phẩm</div>
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label for="">Product Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Tên sản phẩm">
                </div>

                <div class="form-group">
                    <label for="">Image</label>
                    <input type="file" class="form-control" name="image" placeholder="image">
                </div>

                <div class="form-group">
                    <label for="">Price</label>
                    <input type="text" class="form-control" name="name" placeholder="Giá sản phẩm">
                </div>

                <div class="form-group">
                    <label for="">Title</label>
                    <input type="text" class="form-control" name="title" id="" placeholder="Tiêu đề">
                    <label for="" ng-if="" class="text-denger"></label>
                </div>

                <div class="form-group">
                    <label for="">Description</label>
                    <div class="mb-3">
                        <textarea class="form-control" name="description" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="">Category</label>

                    <select name="category" class="form-select" aria-label="Default select example">
                        <c:forEach items="${listC}" var="category">

                            <option name="lop" value="${category.name}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="text-center mt-3">
                    <button type="reset" class="btn  btn-outline-secondary">Reset</button>
                    <button type="submit" class="btn btn-success">Thêm</button>
                </div>

            </form>

        </div>
    </div>
</div>


<!-- Start Footer -->
<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>
