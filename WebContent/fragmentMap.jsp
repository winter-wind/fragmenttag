<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cc.biibi.fordeom.Customers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="map" uri="http://www.biibi.cc/fragment/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br>
	<%
	
		List<Customers> customer = new ArrayList<Customers>();
		customer.add(new Customers(1,"aaa"));
		customer.add(new Customers(2,"bbb"));
		customer.add(new Customers(3,"ccc"));
		customer.add(new Customers(4,"ddd"));
		customer.add(new Customers(5,"eee"));
		
		request.setAttribute("customer", customer);
 
		Map<String,Customers> mapcust = new HashMap<String,Customers>();
		mapcust.put("1", customer.get(0));
		mapcust.put("2", customer.get(1));
		mapcust.put("3", customer.get(2));
		mapcust.put("4", customer.get(3));
		mapcust.put("5", customer.get(4));
			
		request.setAttribute("mapcust",mapcust);
	%>
	
	<c:forEach items="${mapcust }" var="mapc">
		${mapc.key }--${mapc.value.id }--${mapc.value.name }<br>
	</c:forEach>
	
	<map:forEachMap items="${mapcust }" var="mymap">
		${mymap.key }==${mymap.value.id }==${mymap.value.name }<br>
	</map:forEachMap>
	
	
</body>
</html>