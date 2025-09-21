<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/09/2025
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tin tức</title>
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
            text-align: left;
        }
        th {
            background: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>📢 Danh sách điện thoại</h2>
<form>
    <div style="display: flex;justify-content: center;gap:10px">
        <label>Nhập mã nhà cung cấp</label>
        <input type="text" >
        <button type="submit">Tìm</button>
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
            <tr>
                <td style="width: 100px">a</td>
                <td style="width: 400px">a</td>
                <td style="width: 400px">a</td>
                <td style="width: 150px">a</td>
                <td style="width: 400px">a</td>
            </tr>

        </tbody>
    </table>

</body>
</html>

