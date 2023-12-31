<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-..." crossorigin="anonymous"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- JS Bootstrap 4 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            /*color: ;*/
            background: white;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            /*background: #fff;*/
            padding: 20px 25px;
            border-radius: 3px;
            min-width: 1000px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            /*background: #fff;*/
            color: #fff;
            padding: 16px 30px;
            min-width: 100%;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
            color: #198754;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            /*border-color: #e9e9e9;*/
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            /*background-color: #fcfcfc;*/
        }

        table.table-striped.table-hover tbody tr:hover {
            /*background: #f5f5f5;*/
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }

        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
            font-size: 14px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }


    </style>
    <script>
        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function () {
                if (this.checked) {
                    checkbox.each(function () {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function () {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function () {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });
    </script>
</head>
<body>

<!-- Header -->
<jsp:include page="Header.jsp"></jsp:include>

<div class="">
    <div class="card mt-5">
        <div class="card-header">Thêm mới chi tiết sản phẩm</div>
        <div class="card-body">
            <form action="/detail-product/add" method="post">
                <div class="form-group">
                    <label for="">Sản Phẩm</label>
                    <select class="form-select" aria-label="Default select example" name="sanPham">
                        <c:forEach items="${listSP}" var="sp">
                            <option value="${sp.id}">${sp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="">Nhà Sản Xuất</label>
                    <select class="form-select" aria-label="Default select example" name="nhaSanXuat">
                        <c:forEach items="${listNSX}" var="nsx">
                            <option value="${nsx.id}">${nsx.ten}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="">Màu Sắc</label>
                    <select class="form-select" aria-label="Default select example" name="mauSac">
                        <c:forEach items="${listMS}" var="ms">
                            <option value="${ms.id}">${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="">Đồng Sản Phẩm</label>
                    <select class="form-select" aria-label="Default select example" name="dongSanPham">
                        <c:forEach items="${listDongSP}" var="dongSP">
                            <option value="${dongSP.id}">${dongSP.ten}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group">
                    <label for="">Năm Bảo Hành</label>
                    <input type="number" class="form-control" name="namBH" placeholder="Năm Bảo Hành">
                </div>

                <div class="form-group">
                    <%--@declare id=""--%><label for="">Mô Tả</label>
                    <input type="text" class="form-control" name="moTa" placeholder="Mô Tả">
                </div>

                <div class="form-group">
                    <label for="">Số Lượng Tồn</label>
                    <input type="number" class="form-control" name="soLuongTon" placeholder="Số Lượng Tồn">
                </div>

                <div class="form-group">
                    <label for="">Giá Nhập</label>
                    <input type="number" class="form-control" name="giaNhap" placeholder="Gía Nhập">
                </div>

                <div class="form-group">
                    <label for="">Giá Bán</label>
                    <input type="number" class="form-control" name="giaBan" placeholder="Giá Bán">
                </div>


                <div class="text-center mt-3">
                    <button type="reset" class="btn  btn-outline-secondary">Reset</button>
                    <button type="submit" class="btn btn-success">Thêm</button>
                </div>

            </form>

        </div>
    </div>

    <div class="">
        <div class="">
            <div class="table-title ">
                <div class="row text-center mt-4 mb-1">
                    <h2>Danh Sách Chi Tiết Sản Phẩm</h2>
                </div>
            </div>
            <table class="table bg-light ">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Sản Phẩm</th>
                    <th>Nhà Sản Xuất</th>
                    <th>Màu Sắc</th>
                    <th>Đồng Sản Phẩm</th>
                    <th>Năm Bảo Hàng</th>
                    <th>Mô Tả</th>
                    <th>Số Lượng Tồn</th>
                    <th>Giá Nhập</th>
                    <th>Giá Bán</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listDetailProduct}" var="sp">
                    <tr>
                        <td>${sp.id}</td>
                        <td>${sp.sanPham.ten}</td>
                        <td>${sp.nhaSanXuat.ten}</td>
                        <td>${sp.mauSac.ten}</td>
                        <td>${sp.dongSanPham.ten}</td>

                        <td>
                                ${sp.namBH}
                        </td>
                        <td>
                                ${sp.moTa}
                        </td>
                        <td> ${sp.soLuongTon}</td>
                        <td> ${sp.giaNhap}</td>
                        <td> ${sp.giaBan}</td>

                        <td>
                            <a href="/detail-product/detail?id=${sp.id}" class="edit" data-toggle="modal"><i
                                    class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="/detail-product/delete?id=${sp.id}" class="delete" data-toggle="modal"><i
                                    class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                        <div class="clearfix">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${countPage}" var="i">
                                    <li class="page-item ">
                                        <a class="page-link <c:if test="${i == index }">active</c:if>   rounded-0 mr-3 shadow-sm border-top-0 border-left-0"
                                           href="/manager-detail-product?index=${i}" tabindex="-1" style="color: black">${i}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
        </div>
    </div>
</div>


<!-- Start Footer -->
<jsp:include page="Footer.jsp"></jsp:include>

<!-- End Footer -->
</body>
</html>