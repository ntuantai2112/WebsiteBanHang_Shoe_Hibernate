<%--
  Created by IntelliJ IDEA.
  User: LENOVO T560
  Date: 04/11/2023
  Time: 04:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--            <thead>--%>
            <tr>
                <th scope="col">Sản phẩm</th>
                <th scope="col">Đơn giá</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Tổng tiền</th>
                <th scope="col">Xóa</th>
            </tr>
<%--            </thead>--%>
<%--            <tbody>--%>

            <c:forEach items="${sessionScope.cart}" var="entry">
                <tr>
                    <td scope="row">${entry.value.chiTietSanPham.sanPham.ten}
                        <img src="${entry.value.chiTietSanPham.sanPham.hinhAnh}" alt="" style="width: 100px; height: 100px">
                   </td>
                    <td>${entry.value.donGia}</td>
                    <td>
                        ${entry.value.soLuong}
    <%--                    <ul class="list-inline pb-3">--%>
    <%--                        <li class="list-inline-item"><span class="btn btn-success"--%>
    <%--                                                           id="btn-minus">-</span></li>--%>
    <%--                        <li class="list-inline-item"><span class="badge bg-secondary"--%>
    <%--                                                           id="var-value">1</span></li>--%>
    <%--                        <li class="list-inline-item"><span class="btn btn-success"--%>
    <%--                                                           id="btn-plus">+</span></li>--%>
    <%--                    </ul>--%>
                    </td>
                    <td>${entry.value.donGia} </td>
                    <td>
                        <a href="">
                            <button class="btn btn-danger">Xóa</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
<%--            </tbody>--%>
        </table>
    </div>

    <div class="row">
        <div class="col-7">
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



            <form>
                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="exampleInputPassword1" class="form-label">Họ và tên</label>
                        <input type="text" class="form-control" placeholder="Họ và tên" required>
                    </div>

                    <div class="mb-3 col-6">
                        <label for="exampleInputPassword1" class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" required placeholder="Số điện thoại">
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="exampleInputPassword1" class="form-label" >Địa chỉ</label>
                        <input type="text" class="form-control" placeholder="Địa chỉ" required>
                    </div>

                    <div class="mb-3 col-6">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email"  required aria-describedby="emailHelp">
                    </div>
                </div>

            </form>


        </div>
        <div class="col-5">
            <h1>Thành tiền</h1>
            <div class="row">
                <p class="col-6">Tổng tiền hàng</p>
                <p class="col-6 text-end">20$</p>
            </div>
            <hr class="my-2">
            <div class="row">
                <p class="col-6">Phí vận chuyển</p>
                <span class="col-6 text-end">Free Ship</span>
            </div>
            <hr class="my-2">
            <div class="row ">
                <p class="col-6">VAT</p>
                <span class="col-6 text-end">0$</span>
            </div>
            <hr class="my-2">
            <div class="row ">
                <p class="col-6">Tổng thanh toán</p>
                <span class="col-6 text-end">20$</span>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <a href="/store/hien-thi"><button class="btn btn-outline-success form-control mb-5">Tiếp tục mua sắm</button></a>
                </div>
                <div class="col-6">
                    <a href="/AddOrderController"> <button class="btn btn-success form-control mb-5" type="submit"> Mua hàng</button></a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Start Footer -->
<jsp:include page="Footer.jsp"></jsp:include>

<!-- End Footer -->
<script src="../assets/js/jquery-1.11.0.min.js"></script>
<script src="../assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../assets/js/bootstrap.bundle.min.js"></script>
<script src="../assets/js/templatemo.js"></script>
<script src="../assets/js/custom.js"></script>
<!-- End Script -->

<!-- Start Slider Script -->
<script src="../assets/js/slick.min.js"></script>
<script>
    $('#carousel-related-product').slick({
        infinite: true,
        arrows: false,
        slidesToShow: 4,
        slidesToScroll: 3,
        dots: true,
        responsive: [{
            breakpoint: 1024,
            settings: {
                slidesToShow: 3,
                slidesToScroll: 3
            }
        },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 3
                }
            }
        ]
    });
</script>

</body>
</html>
