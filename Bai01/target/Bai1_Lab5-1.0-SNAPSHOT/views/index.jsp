
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container{
            display: flex;
            flex-direction: column;
            height: 100%;
            justify-content:space-between;
        }
        img{
            width: 100%;
            object-fit: contain;
            height: 200px;

        }
        ul{
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        .header{
            border: solid 1px black;
            padding-top: 5px;
            padding-bottom: 5px;
        }
        .header ul li{
            text-decoration: underline;
            border-right: solid 1px black;
            padding-right: 5px;
            padding-left: 5px;
        }
        a{
            color: black;
            font-size: 20px
        }
        a:hover{
            color: blue;
        }
        ul li{
            padding-right: 5px;
            padding-left: 5px;
            font-size: 20px
        }
    </style>
</head>
<body>
<div class="container">
    <div>
        <img src="../images/tải%20xuống.jpeg" alt="home">
        <div class="header">
            <ul type="none">
                <li><a href="./dienthoai/DanhSachDienThoaiNCC.jsp">Danh sách sản phẩm</a></li>
                <li><a href="">Thêm mới sản phẩm</a></li>
                <li><a href="">Chức năng quản lý</a></li>
            </ul>
        </div>
    </div>
    <div style="border: 1px solid black">
        <ul type="none">
            <li>Nguyen Huynh Ngoc Hai - </li>
            <li>22687251 -</li>
            <li>DHKTPM18CTT</li>
        </ul>
    </div>
</div>
</body>
</html>
