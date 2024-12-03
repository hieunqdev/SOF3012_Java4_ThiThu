<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css"
    />
<link href="https://cdn.datatables.net/2.1.8/css/dataTables.bootstrap5.css">
</head>
<body>
	<div class="container">
		<form class="row g-3" action="NhanVienServlet" method="post">
			<h1 class="text-center">Quản lý nhân viên</h1>
			<div class="col-6">
				<label for="ma" class="form-label">Mã</label> 
				<input type="text" name="ma" class="form-control" id="ma" required>
			</div>
			<div class="col-6">
				<label for="diachi" class="form-label">Địa chỉ</label> 
				<input type="text" name="diachi" class="form-control" id="diachi" required>
			</div>
			<div class="col-6">
				<label for="ten" class="form-label">Tên</label> 
				<input type="text" name="ten" class="form-control" id="ten" required>
			</div>
			<div class="col-6">
				<label class="form-label"> Giới tính </label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gioitinh"
						id="flexRadioDefault1" value="male" checked> <label
						class="form-check-label" for="flexRadioDefault1"> Nam </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gioitinh"
						id="flexRadioDefault2" value="female"> <label
						class="form-check-label" for="flexRadioDefault2"> Nữ </label>
				</div>
			</div>

			<div class="col-auto">
				<button type="submit" name="action" value="create" class="btn btn-primary mb-3" >Thêm</button>
			</div>
		</form>

		<table class="table" id="myTable">
			<thead>
				<tr>
					<th scope="col">STT</th>
					<th scope="col">Mã bạn</th>
					<th scope="col">Tên bạn</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">Giới tính</th>
					<th scope="col">Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${nvList}" varStatus="status">
				<tr>
					<th scope="row">${status.count}</th>
						<td>${item.maNV}</td>			
						<td>${item.tenNV}</td>			
						<td>${item.diaChi}</td>			
						<td>${item.gioiTinh == true ? "Nam": "Nữ"}</td>	
					<form action="NhanVienServlet" method="POST">		
						<td><button name="action" value="delete" class="btn btn-danger">Xóa</button></td>
						<input type="hidden" name="maNV" value="${item.maNV}">
					</form>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- DataTables JS -->
    <script
      type="text/javascript"
      src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"
    ></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $("#myTable").DataTable({
          paging: true, // Bật phân trang
          pageLength: 5, // Số dòng trên mỗi trang
          lengthMenu: [5, 10, 25, 50], // Tùy chọn số dòng trên mỗi trang
          pagingType: "full_numbers", // Kiểu phân trang đầy đủ
        });
      });
    </script>
</body>
</html>