<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Trips Management System - Main Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/common.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/home.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/i18n/defaults-*.min.js"></script>
    <!-- Bootstrap date picker plugin-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css">
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.vi.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/loader.css">
    <script src="${pageContext.request.contextPath}/resources/js/loader.js"></script>
</head>
<body>
<div id="loader-container">
    <div id="loader"></div>
</div>
<div class="wrapper" style="display: none;">
    <%@ include file="../common/header.jsp"%>

    <c:set var="bill" value="${bill}"/>

    <div class="container">
        <div class="alert alert-success">
            <c:if test="${not empty bill}">
                <c:if test="${bill.status == 1}">
                    <strong>Thành công!</strong> Bạn đã đặt vé thành công
                </c:if>
                <c:if test="${bill.status != 1}">
                    <strong>Đang chờ!</strong> Xe đã hết chỗ, đơn hàng đang chờ duyệt
                </c:if>
                <p>Mã đơn hàng của bạn là: ${bill.billId}</p>
            </c:if>
        </div>

        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">Thông tin đơn hàng</div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Mã đơn hàng</th>
                            <th>Tuyến</th>
                            <th>Ngày đặt</th>
                            <th>Trạm đầu</th>
                            <th>Trạm cuối</th>
                            <th>Tên</th>
                            <th>Số điện thoại</th>
                            <th>Ghế loại</th>
                            <th>Giá vé</th>
                            <th>Ngày</th>
                            <th>Giờ</th>
                            <th>Điểm đón</th>
                            <th>Điểm đưa</th>
                            <th>Trạng thái</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${bill.billId}</td>
                            <td>${bill.route.origin} - ${bill.route.destination}</td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${bill.dateTime}"/></td>
                            <td>${bill.stationByStationIdFirst.stationName}</td>
                            <td>${bill.stationByStationIdLast.stationName}</td>
                            <td>${bill.customerName}</td>
                            <td>${bill.customerPhone}</td>
                            <td>${bill.seatType}</td>
                            <td>
                            <c:if test="${bill.seatType == 1}">
                                ${bill.route.costSeatType1}
                            </c:if>
                            <c:if test="${bill.seatType != 1}">
                                ${bill.route.costSeatType2}
                            </c:if>
                            </td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${bill.weekSchedule.dateTime}"/></td>
                            <td><fmt:formatDate pattern="HH:mm:ss" value="${bill.weekSchedule.dateTime}"/></td>
                            <td>${bill.cusStartPoint}</td>
                            <td>${bill.cusEndPoint}</td>
                            <td>
                                <c:if test="${bill.status == 1}">
                                    Đặt thành công
                                </c:if>
                                <c:if test="${bill.status != 1}">
                                    Đang chờ
                                </c:if>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <c:set var="car" value="${bill.car}"/>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Thông tin xe
                                    </div>
                                    <div class="panel-body">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Loại xe</th>
                                                <th>Biển số</th>
                                                <th>Số ghế loại 1</th>
                                                <th>Số ghế loại 2</th>
                                                <th>Tài xế</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>${car.carType}</td>
                                                <td>${car.licensePlate}</td>
                                                <td>${car.numSeatType1}</td>
                                                <td>${car.numSeatType2}</td>
                                                <td>${car.driver.driverName}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="item-block text-center">
                    <div>
                        <img
                                src="${pageContext.request.contextPath}/resources/images/footer-customer.png"
                                alt="null">
                    </div>
                    <div>
                        <h5>Hơn 20 triệu lượt khách</h5>
                        <p>Nhà xe phục vụ hơn 20 triệu lượt khách/ bình quân 1 năm
                            trên toàn quốc</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="item-block text-center">
                    <div>
                        <img
                                src="${pageContext.request.contextPath}/resources/images/footer-customer.png"
                                alt="null">
                    </div>
                    <div>
                        <h5>Hơn 20 triệu lượt khách</h5>
                        <p>Nhà xe phục vụ hơn 20 triệu lượt khách/ bình quân 1 năm
                            trên toàn quốc</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="item-block text-center">
                    <div>
                        <img
                                src="${pageContext.request.contextPath}/resources/images/footer-customer.png"
                                alt="null">
                    </div>
                    <div>
                        <h5>Hơn 20 triệu lượt khách</h5>
                        <p>Nhà xe phục vụ hơn 20 triệu lượt khách/ bình quân 1 năm
                            trên toàn quốc</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../common/footer.jsp"%>
</div>
</body>