<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="vi">
<head>

    <title>Week Schedule Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/common.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/home.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/loader.css">
    <script src="${pageContext.request.contextPath}/resources/js/loader.js"></script>
</head>

<body>

<div id="loader-container">
    <div id="loader"></div>
</div>
<div class="wrapper" style="display: none;">
    <%@ include file="../common/header.jsp" %>

    <div class="container">
        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">Thông tin chuyến</div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Điểm đầu</th>
                            <th>Điểm cuối</th>
                            <th>Loại xe</th>
                            <th>Biển số</th>
                            <th>Ngày</th>
                            <th>Giờ</th>
                        </tr>
                        </thead>
                        <c:set var="count" value="${0}"/>
                        <tbody>
                            <tr>
                                <c:set var="count" value="${count + 1}"/>
                                <td>${count}</td>
                                <td>${weekSchedule.route.origin}</td>
                                <td>${weekSchedule.route.destination}</td>
                                <td>${weekSchedule.car.carType}</td>
                                <td>${weekSchedule.car.licensePlate}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${weekSchedule.dateTime}"/></td>
                                <td><fmt:formatDate pattern="HH:mm:ss" value="${weekSchedule.dateTime}"/></td>
                            </tr>
                        </tbody>
                    </table>
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
    <%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>