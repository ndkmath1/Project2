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

    <form method="get" action="/booking-success">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Kiểm tra đơn hàng
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label>Mã đơn hàng</label>
                                    <input type="text" name="id" class="form-control">
                                    <button type="submit" class="btn btn-primary pull-right" style="margin-top: 10px;">Kiểm tra</button>
                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
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
