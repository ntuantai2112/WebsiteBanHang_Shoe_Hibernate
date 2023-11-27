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

<div class="  ">

    <div class="card mt-5">
        <div class="card-header">Chi tiết nhân viên</div>
        <div class="card-body">
            <form action="/employee/update?id=${nvDetail.id}" method="post">
                <div class="form-group">
                    <label for="">ID nhân viên</label>
                    <input type="text" value="${nvDetail.id}" class="form-control" name="id" placeholder="ID nhân viên">
                </div>
                <div class="form-group">
                    <label for="">Mã nhân viên</label>
                    <input type="text" value="${nvDetail.ma}" class="form-control" name="ma" placeholder="Mã nhân viên">
                </div>

                <div class="form-group">
                    <label for="">Họ tên nhân viên</label>
                    <input type="text" value="${nvDetail.ho} ${nvDetail.tenDem} ${nvDetail.ten}"  class="form-control" name="ten" placeholder="Họ tên nhân viên">
                </div>


                <div class="form-group">
                    <label for="">Giới tính</label>
                    <div class="row">
                        <div class="col-auto">
                            <div class="form-check">
                                <input value="Nam" class="form-check-input" type="radio" name="gioiTinh"
                                <c:if test="${nvDetail.gioiTinh == 'Nam'}">checked</c:if>  >
                                <label class="form-check-label" for="">
                                   Nam
                                </label>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="form-check">
                                <input value="Nữ" class="form-check-input" type="radio" name="gioiTinh"
                                       <c:if test="${nvDetail.gioiTinh == 'Nữ'}">checked</c:if>  >
                                <label class="form-check-label" for="">
                                   Nữ
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <fmt:formatDate pattern="yyyy-MM-dd" value="${nvDetail.ngaySinh}" var="formattedDate" />
                <div class="form-group">
                    <label for="">Ngày sinh</label>
                    <input type="date" value="${formattedDate}" class="form-control" name="ngaySinh" placeholder="Ngày sinh">
                </div>

                <div class="form-group">
                    <%--@declare id=""--%><label for="">Địa Chỉ</label>
                    <input type="text" value="${nvDetail.diaChi}" class="form-control" name="diaChi" placeholder="Địa Chỉ">
                </div>

                <div class="form-group">
                    <label for="">Số điện thoại</label>
                    <input type="text" value="${nvDetail.sdt}" class="form-control" name="sdt" placeholder="Số điện thoại">
                </div>

                <div class="form-group">
                    <%--@declare id=""--%><label for="">Mật Khẩu</label>
                    <input type="password" value="${nvDetail.matKhau}" class="form-control" name="matKhau" placeholder="Mật Khẩu">
                </div>

                <div class="form-group">
                    <%--@declare id=""--%><label for="">Cửa Hàng</label>
                        <select class="form-select" aria-label="Default select example" name="cuaHang">
                            <c:forEach items="${listCH}" var="ch">
                            <option value="${ch.id}"
                                    <c:if test="${nvDetail.cuaHang.ten == ch.ten}">selected</c:if>  >${ch.ten}</option>
                            </c:forEach>
                        </select>
                </div>

                <div class="form-group">
                    <%--@declare id=""--%><label for="">Chức Vụ</label>
                        <select class="form-select" aria-label="Default select example" name="cv">
                            <c:forEach items="${listCV}" var="cv">
                                <option value="${cv.id}"  <c:if test="${nvDetail.cv.ten == cv.ten}">selected</c:if>  >${cv.ten}</option>
                            </c:forEach>
                        </select>
                </div>

                <div class="form-group">
                    <label for="">Trạng Thái</label>
                    <div class="row">
                        <div class="col-auto">
                            <div class="form-check">
                                <input value="1" class="form-check-input" type="radio" name="trangThai"
                                       <c:if test="${nvDetail.trangThai == 1}">checked</c:if>  >
                                <label class="form-check-label" for="">
                                    Đang Đi Làm
                                </label>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="form-check">
                                <input value="0" class="form-check-input" type="radio" name="trangThai"
                                       <c:if test="${nvDetail.trangThai == 0}">checked</c:if>  >
                                <label class="form-check-label" for="">
                                    Nghỉ Làm
                                </label>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="text-center mt-3">
                    <button type="reset" class="btn  btn-outline-secondary">Reset</button>
                    <button type="submit" class="btn btn-warning">Sửa</button>
                </div>

            </form>

        </div>
    </div>

</div>


<!-- Start Footer -->
<jsp:include page="Footer.jsp"></jsp:include>

<!-- End Footer -->
</body>
</html>