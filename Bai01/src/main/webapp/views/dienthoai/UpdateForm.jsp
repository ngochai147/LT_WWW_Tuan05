<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }
        .container {
            max-width: 500px;
            margin: 40px auto;
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            position: relative;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
            color: #444;
        }
        input, textarea, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }
        textarea {
            resize: vertical;
            min-height: 70px;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #4CAF50;
            border: none;
            border-radius: 8px;
            color: white;
            font-size: 15px;
            cursor: pointer;
            margin-top: 15px;
        }
        button:hover {
            background: #43a047;
        }
        img {
            max-height: 120px;
            margin: 10px 0;
            display: block;
        }
        /* Nút trang chủ */
        .home-btn {
            position: absolute;
            top: 15px;
            left: 15px;
            background: #007BFF;
            color: white;
            padding: 8px 15px;
            border-radius: 6px;
            text-decoration: none;
            font-size: 14px;
            transition: 0.3s;
        }
        .home-btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="../index.jsp" class="home-btn">🏠 Trang chủ</a>
    <h2>Cập nhật sản phẩm điện thoại</h2>
    <form action="${pageContext.request.contextPath}/quanly" method="post" enctype="multipart/form-data">
        <input type="hidden" name="maDT" value="${dienthoai.maDT}" />

        <label>Tên điện thoại</label>
        <input type="text" name="tenDT" value="${dienthoai.tenDT}" />

        <label>Năm sản xuất</label>
        <input type="text" name="namSX" value="${dienthoai.namSX}" />

        <label>Cấu hình</label>
        <textarea name="cauHinh">${dienthoai.cauHinh}</textarea>

        <label>Nhà cung cấp</label>
        <select name="mancc">
            <c:forEach items="${listNhaCungCap}" var="ncc">
                <option value="${ncc.maNCC}"
                        <c:if test="${dienthoai.nhaCungCap != null && dienthoai.nhaCungCap.maNCC == ncc.maNCC}">selected</c:if>>
                        ${ncc.tenNhaCC}
                </option>
            </c:forEach>
        </select>

        <label>Ảnh hiện tại</label>
        <c:if test="${not empty dienthoai.hinhAnh}">
            <img src="${pageContext.request.contextPath}/images/${dienthoai.hinhAnh}" alt="ảnh sản phẩm"/>
        </c:if>

        <label>Chọn ảnh mới (nếu muốn thay)</label>
        <input type="file" name="hinhAnh"/>

        <button type="submit" name="action" value="updateSave">Lưu cập nhật</button>
    </form>
</div>
</body>
</html>
