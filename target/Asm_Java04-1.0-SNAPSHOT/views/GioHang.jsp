<%--
  Created by IntelliJ IDEA.
  User: LENOVO T560
  Date: 04/11/2023
  Time: 04:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <title>Zay Shop - Giỏ Hàng</title>
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


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>


</header>
<body>
<!-- Header -->
<jsp:include page="Header.jsp"></jsp:include>


<%--Body--%>
<div class="container">
    <div class="row mt-4">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Sản phẩm</th>
                <th scope="col">Đơn giá</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>20$</td>
                <td>
                    <div class="col-md-2">
                        <input type="number" value="1" min="1">
                    </div>
                </td>
                <td>
                    <a href="">
                        <button class="btn btn-danger">Xóa</button>
                    </a>
                </td>
            </tr>

            </tbody>
        </table>
    </div>

    <div class="row">
        <div class="col-6">
            <h1>Voucher</h1>
            <form action="">
                <div class="col-auto">
                    <div class="input-group mb-2">
                        <input type="text" class="form-control bg-white border-light" id="subscribeEmail"
                               placeholder="Nhập voucher">
                        <div class="input-group-text btn-success text-light">Sử dụng</div>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-6 ">
            <h1>Thành tiền</h1>
            <div class="row ">
                <p>Tổng tiền hàng</p>
                <span class="float-end">20$</span>
            </div>
            <div class="row ">
                <p>Phí vận chuyển</p>
                <span class="float-end">20$</span>
            </div>
            <div class="row ">
                <p>VAT</p>
                <span class="float-end">20$</span>
            </div>
            <div class="row ">
                <p>Tổng thanh toán</p>
                <span class="float-end">20$</span>
            </div>
            <div class="row">
                <button class="btn btn-success form-control mb-5">Mua hàng</button>
            </div>
        </div>
    </div>
</div>

<!-- Start Footer -->
<jsp:include page="Footer.jsp"></jsp:include>

<!-- End Footer -->


</body>
</html>
