<%@page import="cc.biibi.fordeom.Customers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.biibi.cc/fragment/core" prefix="fragment" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<fragment:fragment>helloworld</fragment:fragment>
	<fragment:printtag time="10">abcdefghijklmnopqrstuvwxyz</fragment:printtag>
	<br>
	<%
		List<Customers> customer = new ArrayList<Customers>();
		customer.add(new Customers(1,"aaa"));
		customer.add(new Customers(1,"bbb"));
		customer.add(new Customers(1,"ccc"));
		customer.add(new Customers(1,"ddd"));
		customer.add(new Customers(1,"eee"));
		
		request.setAttribute("customer", customer);
	%>
	<!-- 遍历 -->
	<c:forEach items="${requestScope.customer }" var="cust">
		${cust.id } -- ${cust.name }
		<br>
	</c:forEach>
	
	<!-- 自定义遍历 -->
	<h4>自定义遍历</h4>
	<br>
	<fragment:forEach items="${requestScope.customer }" var="cust1">
		
		${cust1.id } -- ${cust1.name }
	<br>
	</fragment:forEach>
	
</body>
</html>