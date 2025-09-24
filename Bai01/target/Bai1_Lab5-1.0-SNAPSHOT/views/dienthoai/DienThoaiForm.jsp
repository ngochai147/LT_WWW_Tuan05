<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2f7;
        }
        .container {
            max-width: 550px;
            margin: 50px auto;
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #2c3e50;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 12px 0 6px;
            color: #444;
        }
        input, textarea, select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            transition: border 0.3s, box-shadow 0.3s;
        }
        input:focus, textarea:focus, select:focus {
            border-color: #007BFF;
            box-shadow: 0 0 5px rgba(0,123,255,0.3);
            outline: none;
        }
        textarea {
            resize: vertical;
            min-height: 80px;
        }
        .btn-home {
            display: inline-block;
            margin-bottom: 20px;
            padding: 8px 15px;
            background: #6c757d;
            color: white;
            border-radius: 8px;
            text-decoration: none;
            transition: background 0.3s;
        }
        .btn-home:hover {
            background: #5a6268;
        }
        button {
            width: 100%;
            padding: 14px;
            background: #28a745;
            border: none;
            border-radius: 10px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-top: 18px;
            transition: background 0.3s, transform 0.2s;
        }
        button:hover {
            background: #218838;
            transform: translateY(-2px);
        }
        .error {
            color: red;
            font-size: 13px;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="${pageContext.request.contextPath}/views/index.jsp" class="btn-home">🏠 Trang chủ</a>
    <h2>➕ Thêm sản phẩm điện thoại</h2>
    <form action="dienthoai-form" method="post" enctype="multipart/form-data">
        <label>Tên điện thoại</label>
        <input type="text" name="tenDT" value="${dienthoai.tenDT}" />
        <c:forEach items="${errors}" var="err">
            <c:if test="${err.propertyPath eq 'tenDT'}">
                <span class="error">${err.message}</span>
            </c:if>
        </c:forEach>

        <label>Năm sản xuất</label>
        <input type="text" name="namSX" value="${dienthoai.namSX}" />
        <c:forEach items="${errors}" var="err">
            <c:if test="${err.propertyPath eq 'namSX'}">
                <span class="error">${err.message}</span>
            </c:if>
        </c:forEach>

        <label>Cấu hình</label>
        <textarea name="cauHinh">${dienthoai.cauHinh}</textarea>
        <c:forEach items="${errors}" var="err">
            <c:if test="${err.propertyPath eq 'cauHinh'}">
                <span class="error">${err.message}</span>
            </c:if>
        </c:forEach>

        <label>Nhà cung cấp</label>
        <select name="mancc">
            <c:forEach items="${listNhaCungCap}" var="ncc">
                <option value="${ncc.maNCC}"
                        <c:if test="${dienthoai.nhaCungCap != null && dienthoai.nhaCungCap.maNCC == ncc.maNCC}">selected</c:if>>
                        ${ncc.tenNhaCC}
                </option>
            </c:forEach>
        </select>

        <label>Ảnh sản phẩm</label>
        <input type="file" name="hinhAnh" value="${dienthoai.hinhAnh}" />
        <c:forEach items="${errors}" var="err">
            <c:if test="${err.propertyPath eq 'hinhAnh'}">
                <span class="error">${err.message}</span>
            </c:if>
        </c:forEach>

        <button type="submit">➕ Thêm sản phẩm</button>
    </form>
</div>
</body>
</html>
