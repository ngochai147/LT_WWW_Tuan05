<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            text-align: center;
            margin: 20px 0;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background: #007BFF;
            color: white; }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        .delete-btn {
            background-color: #e74c3c;
            color: #fff;
            width: 80px;
            border: none;
            padding: 6px 12px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }
        .delete-btn:hover {
            background-color: #c0392b;
        }
        .update-btn {
            background-color: #4CAF50;
            color: white;
            width: 100px;
            border: none;
            padding: 6px 12px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }
        .btn-home {
            position: relative; top: 20px;left: 150px;
            background: #28a745; padding: 8px 15px;
            border-radius: 6px; text-decoration: none;
            color: white; font-size: 14px; transition: 0.3s;
        }
        .btn-home:hover { background: #218838; }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/views/index.jsp" class="btn-home">🏠 Trang chủ</a>
<h2>📢 Danh sách điện thoại</h2>
<table>
    <thead>
    <tr>
        <th>Mã</th>
        <th>Hình ảnh</th>
        <th>Tên</th>
        <th>Năm SX</th>
        <th>Cấu hình</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDienThoai}" var="dienThoai">
        <tr>
            <td>${dienThoai.maDT}</td>
            <td>
                <img style="height: 80px;object-fit: cover"  src="${pageContext.request.contextPath}/images/${dienThoai.hinhAnh}">
            </td>
            <td>${dienThoai.tenDT}</td>
            <td>${dienThoai.namSX}</td>
            <td>${dienThoai.cauHinh}</td>
            <td>
                <form action="quanly" method="post"
                      style="display:inline;">
                    <input type="hidden" name="maDT" value="${dienThoai.maDT}">
                    <button type="submit" name="action" class="delete-btn" value="delete">Hủy</button>
                    <button type="submit" name="action" class="update-btn" value="update">Cập nhật</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
