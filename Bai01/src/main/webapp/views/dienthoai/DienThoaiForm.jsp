<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm điện thoại</title>
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
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);}
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333; }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
            color: #444; }
        input, textarea, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px; }
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
        .error {
            color: red;
            font-size: 13px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Thêm sản phẩm điện thoại</h2>
    <form action="dienthoai-form" method="post">
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

        <label>Ảnh sản phẩm (đường dẫn)</label>
        <input type="text" name="hinhAnh" value="${dienthoai.hinhAnh}" />
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
