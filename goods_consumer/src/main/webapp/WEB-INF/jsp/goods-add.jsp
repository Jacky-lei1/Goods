<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品信息添加</title>
    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"/findAllType",
                dataType:"json",
                success:function (data) {
                    var str = "商品类型:<select name='typeid'>";
                    str+="<option value='0'>所有类型</option>";
                    for (var i=0;i<data.length;i++){
                        str+="<option value='"+data[i].typeid+"'>"+data[i].typename+"</option>";
                    }
                    str+="</select>";
                    var element = document.getElementById("goodsType");
                    element.innerHTML = str;
                }
            });
        });
    </script>
</head>
<body>
<div align="center">
        <br>
        <h1>添加商品</h1>
        <br>
        <hr>
    <%--multipart/form-data：是指表单数据有多部分构成，既有文本数据，又有文件等二进制数据的意思。
        默认情况下，enctype的值是application/x-www-form-urlencoded，不能用于文件上传，
        只有使用了multipart/form-data，才能完整的传递文件数据。
    --%>
    <form action="/addGoods" method="post" enctype="multipart/form-data">
        <table cellpadding="10px" border="2px" style="border: solid 2px palevioletred">
            <tr>
                <td>商品名称：</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>商品类型：</td>
                <td id="goodsType"></td>
            </tr>
            <tr>
                <td>商品品牌：</td>
                <td><input type="text" name="brand"></td>
            </tr>
            <tr>
                <td>商品型号：</td>
                <td><input type="text" name="model"></td>
            </tr>
            <tr>
                <td>商品单价：</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>商品图片：</td>
                <td><input type="file" name="multipartFile"></td>
            </tr>
            <tr>
                <td>商品描述：</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <%--表示合并两列，并居中显示--%>
                <td colspan="2" align="center"><input type="submit" value="发布"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>