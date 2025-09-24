<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Tìm kiếm Nhà Cung Cấp</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f4f6f9; }
    .container {
      max-width: 800px;
      margin: 30px auto;
      background: #fff;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      position: relative;
    }
    h2 { text-align: center; margin-bottom: 20px; color: #333; }
    label { display: block; margin-top: 10px; font-weight: bold; color: #444; }
    input {
      width: 100%; padding: 10px; margin-top: 5px;
      border-radius: 6px; border: 1px solid #ccc; font-size: 14px;
    }
    button {
      margin-top: 15px; padding: 10px; width: 100%;
      background: #007BFF; color: white; border: none;
      border-radius: 6px; cursor: pointer; font-size: 15px;
    }
    button:hover { background: #0056b3; }
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th, td {
      border: 1px solid #ddd; padding: 12px; text-align: center;
    }
    th { background: #007BFF; color: white; }
    tr:nth-child(even) { background: #f9f9f9; }

    /* Nút trang chủ */
    .home-btn {
      position: absolute; top: 20px; right: 20px;
      background: #28a745; padding: 8px 15px;
      border-radius: 6px; text-decoration: none;
      color: white; font-size: 14px; transition: 0.3s;
    }
    .home-btn:hover { background: #218838; }
    .no-result { text-align: center; margin-top: 20px; color: #888; font-style: italic; }
  </style>
</head>
<body>
<div class="container">
  <a href="../index.jsp" class="home-btn">🏠 Trang chủ</a>
  <h2>Tìm kiếm Nhà Cung Cấp</h2>

  <form action="nha-cung-cap" method="post">
    <label>Nhập thông tin cần tìm:</label>
    <input type="text" name="timKiem" placeholder="Nhập Mã NCC, Tên, Địa chỉ hoặc SĐT..."
           value="${timKiem}">
    <button type="submit">🔍 Tìm kiếm</button>
  </form>

  <h3>Danh sách nhà cung cấp</h3>
  <c:choose>
    <c:when test="${not empty listNCC}">
      <table>
        <thead>
        <tr>
          <th>Mã NCC</th>
          <th>Tên NCC</th>
          <th>Địa chỉ</th>
          <th>Số điện thoại</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ncc" items="${listNCC}">
          <tr>
            <td>${ncc.maNCC}</td>
            <td>${ncc.tenNhaCC}</td>
            <td>${ncc.diaChi}</td>
            <td>${ncc.soDienThoai}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:when>
    <c:otherwise>
      <p class="no-result">⚠ Không tìm thấy nhà cung cấp nào.</p>
    </c:otherwise>
  </c:choose>
</div>
</body>
</html>
