<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách điện thoại</title>
    <style>
        body { font-family: Arial, sans-serif; }
        h2 { text-align: center; margin: 20px 0; }
        table { width: 80%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background: #007BFF; color: white; }
        tr:nth-child(even) { background: #f9f9f9; }
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
        .delete-btn:hover { background-color: #c0392b; }
    </style>
</head>
<body>
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
            <td>${dienThoai.hinhAnh}</td>
            <td>${dienThoai.tenDT}</td>
            <td>${dienThoai.namSX}</td>
            <td>${dienThoai.cauHinh}</td>
            <td>
                <form action="quanly" method="post"
                      onsubmit="return confirm('Bạn có chắc muốn hủy điện thoại này?');"
                      style="display:inline;">
                    <input type="hidden" name="maDT" value="${dienThoai.maDT}">
                    <button type="submit" class="delete-btn">Hủy</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
