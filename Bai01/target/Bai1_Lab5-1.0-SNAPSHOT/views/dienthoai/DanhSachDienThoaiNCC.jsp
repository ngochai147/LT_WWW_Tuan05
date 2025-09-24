<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background: #007BFF;
            padding: 12px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin-right: 15px;
            font-weight: bold;
        }
        .navbar a:hover {
            text-decoration: underline;
        }
        h2 {
            text-align: center;
            margin: 25px 0;
            color: #333;
        }
        .filter-bar {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-bottom: 20px;
        }
        select, input[type="text"] {
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 3px 8px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #eee;
            padding: 12px;
            text-align: center;
        }
        th {
            background: #007BFF;
            color: white;
        }
        tr:hover {
            background: #f1f1f1;
        }
        img {
            height: 80px;
            object-fit: cover;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <div>
        <a href="${pageContext.request.contextPath}/views/index.jsp">🏠 Trang chủ</a>
        <a href="${pageContext.request.contextPath}/nha-cung-cap">🏢 Nhà cung cấp</a>
    </div>
</div>

<h2>📱 Danh sách điện thoại</h2>

<form action="dien-thoai" method="post">
    <div class="filter-bar">
        <select name="nhaCC" onchange="this.form.submit()">
            <option value="default">-- Chọn Nhà Cung Cấp --</option>
            <c:forEach items="${listNhaCungCap}" var="nhaCC">
                <option value="${nhaCC.tenNhaCC}"
                        <c:if test="${tenNhaCC == nhaCC.tenNhaCC}">selected</c:if>>
                        ${nhaCC.tenNhaCC}
                </option>
            </c:forEach>
        </select>
    </div>
</form>

<table>
    <thead>
    <tr>
        <th>Mã Điện thoại</th>
        <th>Hình ảnh</th>
        <th>Tên điện thoại</th>
        <th>Năm sản xuất</th>
        <th>Cấu hình</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDienThoai}" var="dienThoai">
        <tr>
            <td>${dienThoai.maDT}</td>
            <td>
                <img src="${pageContext.request.contextPath}/images/${dienThoai.hinhAnh}" alt="ảnh"/>
            </td>
            <td>${dienThoai.tenDT}</td>
            <td>${dienThoai.namSX}</td>
            <td style="text-align: left;">${dienThoai.cauHinh}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
