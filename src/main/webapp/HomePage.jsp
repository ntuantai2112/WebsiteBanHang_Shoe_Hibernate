<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop Shoe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href=" assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <%--    CDN sử dụng AJAX--%>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>


    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>


    <style>
        .image_link {
            width: 415px;
            height: 300px;
            object-fit: cover;
        }

        .card_title {
            display: -webkit-box;
            /*-webkit-line-clamp: 2 ;*/
            -webkit-box-orient: vertical;
            overflow: hidden;
        }

        .product_name {
            color: black;
            font-size: 50px;
            font-weight: 700;
            text-decoration: none;
        }

        .product_name:hover {
            color: #198754;
        }
    </style>
</head>

<body>
<!--Header -->
<jsp:include page="views/Header.jsp"></jsp:include>


<!-- Modal -->
<div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="w-100 pt-1 mb-5 text-right">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <%-- Tìm kiếm sản phẩm        --%>
        <form action="search" method="post" class="modal-content modal-body border-0 p-0">
            <div class="input-group mb-2">
                <input type="text" value="${keyword}" class="form-control" id="inputModalSearch" name="keyword"
                       placeholder="Search ...">
                <button type="submit" class="input-group-text bg-success text-light">
                    <i class="fa fa-fw fa-search text-white"></i>
                </button>
            </div>
        </form>
    </div>
</div>


<!-- Start Banner Hero -->
<div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
    <ol class="carousel-indicators">
        <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
        <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
        <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <div class="container">
                <div class="row p-5">
                    <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                        <img class="img-fluid" src="assets/img/giay_Adidas05.jpg" alt="">
                    </div>
                    <div class="col-lg-6 mb-0 d-flex align-items-center">
                        <div class="text-align-left align-self-center">
                            <h1 class="h1 text-success"><b>Zay</b> Shoes</h1>
                            <h3 class="h2">Giày Nike</h3>
                            <p>
                                Sau hơn 50 năm hình thành và phát triển, chất lượng, mẫu mã sản phẩm của Nikekhông ngừng
                                thay đổi. Giờ đây, Nike đã trở thành thương hiệu “quyền lực nhất trong vương quốc thể
                                thao”. Một điều chắc chắn ai trong chúng ta cũng đã từng tận mắt nhìn thấy hoặc đã từng
                                sở hữu một đôi Nike cho riêng mình.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <div class="container">
                <div class="row p-5">
                    <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                        <img class="img-fluid" src="assets/img/giay_Adidas06.png" alt="">
                    </div>
                    <div class="col-lg-6 mb-0 d-flex align-items-center">
                        <div class="text-align-left">
                            <h1 class="h1">Giày Adidas </h1>
                            <h3 class="h2">Aliquip ex ea commodo consequat</h3>
                            <p>
                                Adidas là một công ty đa quốc gia đến từ Đức, chuyên sản xuất giày dép, quần áo và phụ
                                kiện. Tiền thân của công ty là Gebruder Dassler Schuhfabrik, được thành lập vào năm 1924
                                bởi anh em nhà Dassler là Adi Dassler và Rudolf.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <div class="container">
                <div class="row p-5">
                    <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                        <img class="img-fluid" src="assets/img/giay_conver01.jpg" alt="">
                    </div>
                    <div class="col-lg-6 mb-0 d-flex align-items-center">
                        <div class="text-align-left">
                            <h1 class="h1">Giày Connverse</h1>
                            <p>
                                We bring you 100% free CSS templates for your websites.
                                If you wish to support TemplateMo, please make a small contribution via PayPal or tell
                                your friends about our website. Thank you.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel"
       role="button" data-bs-slide="prev">
        <i class="fas fa-chevron-left"></i>
    </a>
    <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel"
       role="button" data-bs-slide="next">
        <i class="fas fa-chevron-right"></i>
    </a>
</div>
<!-- End Banner Hero -->


<!-- Start Categories of The Month -->
<section class="container py-5">
    <%--    Các sản phẩm--%>
    <div class="row text-center pt-3">
        <div class="col-lg-6 m-auto">
            <h1 class="h1">Categories of The Month</h1>
            <p>
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                deserunt mollit anim id est laborum.
            </p>
        </div>
    </div>


    <div class="row">
        <div class="col-12 col-md-4 p-5 mt-3">
            <a href="#"><img src="assets/img/Giay_Bitis02.jpg" class="rounded-circle img-fluid border"></a>
            <h5 class="text-center mt-3 mb-3">Bitis</h5>
            <p class="text-center"><a class="btn btn-success" href="/store/hien-thi">Go Shop</a></p>
        </div>
        <div class="col-12 col-md-4 p-5 mt-3">
            <a href="#"><img src="./assets/img/category_img_02.jpg" class="rounded-circle img-fluid border"></a>
            <h2 class="h5 text-center mt-3 mb-3">Nike</h2>
            <p class="text-center"><a class="btn btn-success" href="/store/hien-thi">Go Shop</a></p>
        </div>
        <div class="col-12 col-md-4 p-5 mt-3">
            <a href="#"><img src="./assets/img/giay_conver01.jpg" class="rounded-circle img-fluid border"></a>
            <h2 class="h5 text-center mt-3 mb-3">Converse</h2>
            <p class="text-center"><a class="btn btn-success" href="/store/hien-thi">Go Shop</a></p>
        </div>
    </div>
</section>
<!-- End Categories of The Month -->


<!-- Start Featured Product -->
<section class="bg-light">
    <div class="container py-5">
        <div class="row text-center py-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Sản phẩm bán chạy</h1>
                <p>
                    Reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                    Excepteur sint occaecat cupidatat non proident.
                </p>
            </div>
        </div>
        <div id="content" class=" row">
            <c:forEach items="${listDetailProduct}" var="p">
                <div class="product col-12 col-md-4 mb-4">
                    <div class="card h-100 card_title">
                        <a href="/store/detail?pid=${p.sanPham.id}" class="">
                            <img src="${p.sanPham.hinhAnh}" class="card-img-top image_link" alt="...">
                        </a>
                        <div class="card-body">
                            <a href="/store/detail?pid=${p.sanPham.id}" class="product_name">
                                <h4 class="">${p.sanPham.ten}</h4>
                            </a>
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right fw-bold text-danger"> ${p.giaBan} $</li>
                            </ul>
                            <a href="/detail?pid=" class="product_name  fs-3  "></a>
                            <div class="row d-flex justify-content-between align-items-center">
                                <div class="col-7">
                                    <p class="text-muted">Reviews (24)</p>
                                </div>
                                <div class="col-5">
                                    <a href="/views/GioHang.jsp">
                                        <button type="submit" class="btn btn-success btn-lg" name="submit"
                                                value="addtocard">Add To Cart
                                        </button>
                                    </a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>

        <%--         Thêm sản phẩm--%>
        <div class="">
            <button type="submit" onclick="loadMore()" class="btn btn-primary ">Load More</button>
        </div>


    </div>
</section>
<!-- End Featured Product -->


<!-- Start Footer -->
<jsp:include page="views/Footer.jsp"></jsp:include>
<!-- End Footer -->

<!-- Start Script -->
<script src="assets/js/jquery-1.11.0.min.js"></script>
<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/templatemo.js"></script>
<script src="assets/js/custom.js"></script>
<!-- End Script -->
<script>

    function loadMore() {

        var amount = document.getElementsByClassName("product").length;


        $.ajax({
            url: "/load-more",  // Đường dẫn đến API hoặc file xử lý
            method: "GET",  // Phương thức HTTP (GET, POST, PUT, DELETE, v.v.)
            data: {
                exits: amount
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;

            },
            error: function (xhr, status, error) {
            }
        });

    }


</script>

</body>


</html>
