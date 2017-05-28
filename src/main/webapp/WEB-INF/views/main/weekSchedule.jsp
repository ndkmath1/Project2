<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="vi">
<head>

    <title>Login Page</title>
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
                <div class="panel-heading">Lịch chạy tuần</div>
                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <c:forEach items="${map}" var="item1" begin="0" end="6" varStatus="i">
                            <li class="${i.count == 1 ? 'active' : ''}">
                                <a data-toggle="tab" href="#menu${i.count}">
                                    <c:forEach var="day" items="${item1.value}" begin="1" end="1">
                                        <fmt:formatDate pattern="E" value="${day.dateTime}"/>
                                    </c:forEach>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>

                    <div class="tab-content">
                        <c:forEach items="${map}" var="item2" begin="0" end="6" varStatus="j">
                            <div id="menu${j.count}" class="tab-pane fade in${j.count == 1 ? ' active' : ''}">
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
                                        <th>Đặt vé</th>
                                    </tr>
                                    </thead>
                                    <c:set var="count" value="${0}"/>
                                    <tbody>
                                    <c:forEach items="${item2.value}" var="item3">
                                        <tr>
                                            <c:set var="count" value="${count + 1}"/>
                                            <td>${count}</td>
                                            <td>${item3.route.origin}</td>
                                            <td>${item3.route.destination}</td>
                                            <td>${item3.car.carType}</td>
                                            <td>${item3.car.licensePlate}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item3.dateTime}"/></td>
                                            <td><fmt:formatDate pattern="HH:mm:ss" value="${item3.dateTime}"/></td>
                                            <td><a class="btn btn-primary">Đặt vé</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:forEach>
                        <%--</div>--%>
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
    <%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>
