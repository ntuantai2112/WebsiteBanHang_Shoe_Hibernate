<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop - Product Listing Page</title>
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
    <!--

    TemplateMo 559 Zay Shop

    https://templatemo.com/tm-559-zay-shop

    -->
    <style>
        .card_title {
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            overflow: hidden;
        }


        .templatemo-accordion {
            border: 1px solid #ccc;
        }

        .templatemo-accordion li {
            border-bottom: 1px solid #ddd;
            padding-left: 10px;
            padding-top: 10px;
        }

        .templatemo-accordion li:hover {
            color: yellowgreen;
        }

        .name_product {
            color: black;
            text-decoration: none;
            transition: color 0.3s; /* Hiệu ứng chuyển đổi màu trong 0.3 giây */
        }

        /* CSS khi hover */
        .name_product:hover {
            color: yellowgreen;
        }

        .card-img {
            width: 300px;
            height: 280px;
            object-fit: cover;
        }

        .category_link {
            color: black;
            text-decoration: none;
            display: block;
            /*padding: 10px;*/
            transition: background-color 0.3s, color 0.3s; /* Hiệu ứng chuyển đổi màu nền và màu chữ trong 0.3 giây */
        }

        .category_link:hover {
            color: white;
        }

        .list-group-item:hover {
            background: #0b5ed7;

        }


        .name_product {
            color: black;
            font-size: 20px;
            font-weight: 600;
            text-decoration: none;
        }

        .name_product:hover {
            color: yellowgreen;
        }

        /* CSS khi hover */
        /*.category_link:hover {*/
        /*    background-color: blue; !* Màu nền khi hover *!*/
        /*    color: white; !* Màu chữ khi hover *!*/
        /*}*/
        /*.category_link:active {*/
        /*    background-color: blue; !* Màu nền khi hover *!*/
        /*    color: white; !* Màu chữ khi hover *!*/
        /*}*/


    </style>

</head>

<body>
<!-- Header-->
<jsp:include page="Header.jsp"></jsp:include>
<%--<jsp:useBean id="a" class="com.example.Assignment.dao.DAO_Product" scope="request"></jsp:useBean>--%>
<!-- Close Header -->

<!-- Modal -->
<div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="w-100 pt-1 mb-5 text-right">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <form action="/search" method="post" class="modal-content modal-body border-0 p-0">
            <div class="input-group mb-2">
                <input type="text" value="" class="form-control" id="inputModalSearch" name="keyword"
                       placeholder="Search ...">
                <button type="submit" class="input-group-text bg-success text-light">
                    <i class="fa fa-fw fa-search text-white"></i>
                </button>
            </div>
        </form>
    </div>
</div>


<!-- Start Content -->
<div class="container py-5">
    <div class="row">
        <%-- Các danh mục sản phẩm--%>

        <div class="col-lg-3">

            <h1 class="h2 pb-4"><a href="/shop" class="text-decoration-none" style="color: black;font-size: 30px">Categories</a>
            </h1>

            <ul class="list-group category_block">

                <c:forEach items="${categorys}" var="c">
                    <li class="pb-3 list-group-item text-white ${tag == c.id ? "active" : ""} ">

                        <a class="category_link text-decoration-none active" href="/store/store-category?cid=${c.id}">
                                ${c.ten}
                                <%--                        <i class="fa fa-fw fa-chevron-circle-down mt-1"></i>--%>
                        </a>
                    </li>
                </c:forEach>

            </ul>
        </div>

        <div class="col-lg-9">
            <%--  Các sản phẩm --%>

            <div class="row">

                <c:forEach varStatus="" items="${products}" var="p">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0 card_title">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="${p.hinhAnh}">
                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li><a class="btn btn-success text-white" href="/shop/hien-thi"><i
                                                class="far fa-heart"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="/detail?pid=${p.id}"><i
                                                class="far fa-eye"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="/views/GioHang.jsp"><i
                                                class="fas fa-cart-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                    <%--   Title --%>
                                <div class="row">
                                    <h3><a href="/detail?pid=${p.id}"
                                           class="h3 name_product  text-decoration-none">${p.ten}</a></h3>

                                        <%--                                    <p class="fw-bold mb-0">${p.price} $</p>--%>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>


            </div>
            <%--             Dòng phân  trang --%>
            <div div="row">
                <ul class="pagination pagination-lg justify-content-end">
                    <c:forEach begin="1" end="${countPage}" var="i">

                        <li class="page-item ">
                            <a class="page-link <c:if test="${i == index }">active</c:if>   rounded-0 mr-3 shadow-sm border-top-0 border-left-0"
                               href="/store/hien-thi?index=${i}" tabindex="-1" style="color: black">${i}</a>
                        </li>

                    </c:forEach>
                </ul>
            </div>


        </div>


    </div>

</div>
</div>
<!-- End Content -->

<!-- Start Brands -->
<section class="bg-light py-5">
    <div class="container my-4">
        <div class="row text-center py-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Our Brands</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    Lorem ipsum dolor sit amet.
                </p>
            </div>
            <div class="col-lg-9 m-auto tempaltemo-carousel">
                <div class="row d-flex flex-row">
                    <!--Controls-->
                    <div class="col-1 align-self-center">
                        <a class="h1" href="#multi-item-example" role="button" data-bs-slide="prev">
                            <i class="text-light fas fa-chevron-left"></i>
                        </a>
                    </div>
                    <!--End Controls-->

                    <!--Carousel Wrapper-->
                    <div class="col">
                        <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="multi-item-example"
                             data-bs-ride="carousel">
                            <!--Slides-->
                            <div class="carousel-inner product-links-wap" role="listbox">

                                <!--First slide-->
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End First slide-->

                                <!--Second slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End Second slide-->

                                <!--Third slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img"
                                                             src="../assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End Third slide-->

                            </div>
                            <!--End Slides-->
                        </div>
                    </div>
                    <!--End Carousel Wrapper-->

                    <!--Controls-->
                    <div class="col-1 align-self-center">
                        <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                            <i class="text-light fas fa-chevron-right"></i>
                        </a>
                    </div>
                    <!--End Controls-->
                </div>
            </div>
        </div>
    </div>
</section>
<!--End Brands-->


<!-- Start Footer -->
<jsp:include page="Footer.jsp"></jsp:include>

<!-- End Footer -->

<!-- Start Script -->
<script src="../assets/js/jquery-1.11.0.min.js"></script>
<script src="../assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../assets/js/bootstrap.bundle.min.js"></script>
<script src="../assets/js/templatemo.js"></script>
<script src="../assets/js/custom.js"></script>
<!-- End Script -->
</body>

</html>