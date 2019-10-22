<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品管理系统</title>
    <script src="../js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        /*表示隐藏的模块显示，显示的模块隐藏*/
        function showDetail(id){
            $("#"+id).toggle();
        }

        $(function () {
            $("#addButton").click(function () {
                window.location.href="/goods-add"
            });
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
            <br/>
            <h2>商品列表</h2>
            <br/>
        <form action="/findGoods" method="post">
            <table>
                <tr>
                    <th id="goodsType"></th>
                    <th>商品名称:<input type="text" name="name"/></th>
                    <th><input type="submit" id="queryButton" value="查询"/>&nbsp;<input type="button" id="addButton" value="添加商品"></th>
                </tr>
            </table>
        </form>
        <hr/>
        <table cellpadding="6px" border="2px" style="border: solid 2px palevioletred">
            <tr id="goodsTable">
                <th>商品名称</th>
                <th>商品类型</th>
                <th>品牌</th>
                <th>型号</th>
                <th>单价</th>
                <th>操作</th>
            </tr>
            <%--varStatus:封装了遍历的次数，第一次遍历就为1--%>
            <c:forEach items="${goods}" var="goods" varStatus="i">
                <tr>
                    <th>${goods.name}</th>
                    <th>
                        <c:forEach items="${types}" var="types">
                            <c:if test="${goods.typeid==types.typeid}">
                                ${types.typename}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>${goods.brand}</th>
                    <th>${goods.model}</th>
                    <th>${goods.price}</th>
                    <th>
                        <input type="button" value="详情" onclick="showDetail('detail${i.count}')" id="">
                    </th>
                </tr>
                <tr id="detail${i.count}" hidden>
                    <th>
                        <img src="${goods.picture}" alt="图片无法显示" width="200px" height="150px" align="middle">
                    </th>
                    <%--colspan表示当前行合并的列数--%>
                    <th colspan="5">
                            ${goods.description}
                    </th>
                </tr>
            </c:forEach>
        </table>
        <div>
            <span style="border: 5px red">${msg}</span>
        </div>
    </div>
</body>