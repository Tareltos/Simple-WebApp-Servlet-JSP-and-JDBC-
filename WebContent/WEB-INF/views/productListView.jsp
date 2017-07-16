<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
 </head>
 <body>
 
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr style="color: red">
          <th>Code</th>
          <th>Article</th>
          <th>Group</th>
          <th>Brand</th>
          <th>Discount</th>
          <th>OptPrice</th>
          <th>RoznPrice</th>
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr style="color: white">
             <td>${product.code}</td>
             <td>${product.part_name}</td>
             <td>${product.group}</td>
             <td>${product.brand}</td>
             <td>${product.discount}</td>
             <td>${product.opt_price}</td>
             <td>${product.rzn_price}</td>
             
           
          </tr>
       </c:forEach>
    </table>
 
    <a href="createProduct" >Create Product</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>