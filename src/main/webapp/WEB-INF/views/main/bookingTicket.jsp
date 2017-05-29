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

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css">
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.vi.min.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>

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
                            <th>Giá ghế loại 1</th>
                            <th>Giá ghế loại 2</th>
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
                                <td>${weekSchedule.route.costSeatType1}</td>
                                <td>${weekSchedule.route.costSeatType2}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${weekSchedule.dateTime}"/></td>
                                <td><fmt:formatDate pattern="HH:mm:ss" value="${weekSchedule.dateTime}"/></td>
                            </tr>
                        </tbody>
                    </table>

                    <form method="get" action="/booking-ticket-processing" class="form-group">
                        <input type="hidden" value="${weekSchedule.weekScheduleId}" name="ws">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2">
                                <div class="panel-group">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <div>Thông tin đặt vé</div>
                                        </div>
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-5 col-md-offset-1">
                                                    <label>Trạm đầu</label>
                                                    <select name="stationIdFirst"
                                                            class="selectpicker" data-live-search="true"
                                                            data-width="100%">
                                                        <c:forEach items="${stationList}" var="station">
                                                            <c:if test="${station.order == 1}">
                                                                <option data-tokens="${station.stationName}" value="${station.stationId}">${station.stationName}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                    <label>Điểm đón</label>
                                                    <input type="text" name="cusStartPoint" class="form-control">
                                                    <label>Tên</label>
                                                    <input type="text" name="name" class="form-control" required="required">
                                                </div>
                                                <div class="col-md-5">
                                                    <label>Trạm cuối</label>
                                                    <select name="stationIdLast"
                                                            class="selectpicker" data-live-search="true"
                                                            data-width="100%">
                                                        <c:forEach items="${stationList}" var="station">
                                                            <c:if test="${station.order == 2}">
                                                                <option data-tokens="${station.stationName}" value="${station.stationId}">${station.stationName}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                    <label>Điểm đưa</label>
                                                    <input type="text" name="cusEndPoint" class="form-control">
                                                    <label>Số điện thoại</label>
                                                    <input type="text" name="phoneNumber" class="form-control" required="required">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4 col-md-offset-4">
                                                    <label>Loại ghế</label>
                                                    <select name="seatType"
                                                            class="selectpicker" data-live-search="true"
                                                            data-width="100%">
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row" style="margin-top: 20px;">
                                                <div class="col-md-6 col-md-offset-3">
                                                    <div class="list-group">
                                                        <a href="#" class="list-group-item disabled">Lộ trình</a>
                                                        <c:forEach items="${stopPointList}" var="stopPoint">
                                                            <a href="#" class="list-group-item">${stopPoint.stopPointName}</a>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-10 col-md-offset-1">
                                                    <i><b>Chú ý</b>: Nhà xe hỗ trợ đưa đón trong phạm vi 10km kể từ các trạm đầu và trạm cuối
                                                        , quý khách vui lòng chọn trạm và nhậm điểm đưa, đón để được hỗ trợ</i>
                                                </div>
                                            </div>
                                            <div class="row" style="margin-top: 30px">
                                                <div class="col-md-offset-9">
                                                    <button type="submit" class="btn btn-primary">Đặt vé</button>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

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