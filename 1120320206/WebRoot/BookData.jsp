<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookData.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  <table width="800" border="1" height="95">
   <tr>
   <td> ISBN</td>
   <td> Title</td>
   <td> AuthorID</td>
   <td> publisher</td>
   <td> PublishDate</td>
   <td> Price</td>
   <td> choice</td>
   </tr>
   <tr>
  <td><%="ISBN"%></td>
 
  
   <input type="text" name="IsSBN">
   <input type="text" name="Title">
  </tr>
    
  </body>
</html>
