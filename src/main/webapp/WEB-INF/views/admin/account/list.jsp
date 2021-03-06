<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title>Trips Management System - Admin Page</title>
<%@ include file="../common/head.jsp"%>
</head>
<body>
	<%@ include file="../common/topAndLeft.jsp"%>

	<div id="main-content">
		<div class="center-content">
			<div class="user-detail">
				<div class="list shadow-all">
					<div id="creator-subheader">
						<div class="creator-subheader-content">
							<h2>Danh sách tài khoản</h2>
							<span id="creator-subheader-item-count" class="badge-creator">100</span>
						</div>
						<div class="creator-subheader-controls">
							<form action="<c:url value="/admin/account/search"/>"
								method="GET">
								<div class="input-group">
									<input id="search-text" type="text"
										class="form-control clear-border-radius" name="q"
										placeholder="Search...">
									<div class="input-group-btn">
										<button class="btn btn-default clear-border-radius"
											type="submit">
											<i class="glyphicon glyphicon-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="clear"></div>
					<hr>
					<div>
						<div class="pull-right">
							<a href="<c:url value="/admin/account/create"/>"
								class="btn btn-success"> <span
								class="glyphicon glyphicon-plus"></span> Thêm tài khoản mới
							</a>
						</div>
						<div class="pull-left">
							<c:if test="${not empty success}">
								<div class="alert alert-success alert-dismissable"
									id="success-msg">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> <strong>Success!</strong>
									${success}
								</div>
							</c:if>
						</div>
					</div>
					<table class="table table-hover tablesorter" id="myTable">
						<thead>
							<tr>
								<!--  
								<th><input type="checkbox" name="select-all" value="">
									<div class="btn-group">
										<button type="button" class="btn btn-default select-action">Action</button>
										<button type="button"
											class="btn btn-default dropdown-toggle caret-action"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Delete</a></li>
											<li><a href="#">More</a></li>
										</ul>
									</div></th>-->
								<th>#</th>
								<th>Email</th>
								<th>Tên</th>
								<th>Số điện thoại</th>
								<th>Địa chỉ</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty requestScope.paging}">
									<h3>Danh sách tài khoản rỗng</h3>
								</c:when>
								<c:otherwise>
									<c:if test="${not empty param.page}">
										<c:set var="count"
											value="${(param.page - 1) * (paging.maxRecordPerPage)}"
											scope="page" />
									</c:if>
									<c:if test="${empty param.page}">
										<c:set var="count" value="${0}" scope="page" />
									</c:if>
									<c:forEach items="${requestScope.paging.resultList}"
										var="resultList">
										<tr>
											<c:set var="count" value="${count + 1}" />
											<td>${count}</td>
											<td>${resultList.email}</td>
											<td>${resultList.name}</td>
											<td>${resultList.phoneNumber}</td>
											<td>${resultList.address}</td>
											<td><a
												href="<c:url value="/admin/account/${resultList.accountId}/edit"/>"><span
													class="glyphicon glyphicon-pencil"></span></a></td>
											<td><a
												href="<c:url value="/admin/account/${resultList.accountId}/delete"/>"
												onclick="return confirm('Bạn muốn xóa tài khoản có id là ${account.accountId}')"><span
													class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					
					<div class="pull-right">
						<div class="pagination">
							<c:if test="${not empty param.page}">
								<c:set var="currentPage" value="${param.page}" />
							</c:if>
							<c:if test="${empty param.page}">
								<c:set var="currentPage" value="${1}" />
							</c:if>
							<c:set var="baseUrl" value="/admin/account/list" />
							<c:if test="${currentPage > 1}">
								<c:url var="firstPageUrl" value="${baseUrl}">
									<c:param name="page" value="1" />
								</c:url>
								<a href="${firstPageUrl}">Đầu</a>
								<c:url var="previousPageUrl" value="${baseUrl}">
									<c:param name="page" value="${currentPage - 1}" />
								</c:url>
								<a href="${previousPageUrl}">&laquo;</a>
							</c:if>

							<c:forEach items="${paging.indexPageList}" var="indexPage">
								<c:url var="currentUrl" value="${baseUrl}">
									<c:param name="page" value="${indexPage}" />
								</c:url>
								<a href="${currentUrl}"
									class="${indexPage == currentPage ? 'active' : ''}">${indexPage}</a>
							</c:forEach>

							<c:set var="lastPage" value="${paging.totalPage}" />
							<c:if test="${currentPage < lastPage}">
								<c:url var="lastPageUrl" value="${baseUrl}">
									<c:param name="page" value="${lastPage}" />
								</c:url>
								<c:url var="nextPageUrl" value="${baseUrl}">
									<c:param name="page" value="${currentPage + 1}" />
								</c:url>
								<a href="${nextPageUrl}">&raquo;</a>
								<a href="${lastPageUrl}">Cuối</a>
							</c:if>
						</div>
					</div>
					
				</div>
			</div>
		</div>

		<!--<div style=" background-color: #1abb9c; height: 500px; margin: 20px;">-->

		<!--</div>-->

	</div>

	<%@ include file="../common/footer.jsp"%>

</body>
</html>