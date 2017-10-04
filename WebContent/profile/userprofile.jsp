<%@ page contentType="text/html; charset=utf-8" language="java" import="gagan.struts.login.Contacts" errorPage="" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%
Contacts[] contacts = (Contacts[])request.getAttribute("contacts");
%>

<bean:include id="headlink" page="/include/head_link.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Profile</title>
</head>

<body>
<bean:write name="headlink" filter="false" />
My Profile<br/>
<% for(int i=0;i<contacts.length;i++){ %>
<%= contacts[i].getEmail() %><br/>
<% } %>
</body>
</html>
