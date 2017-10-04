<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<bean:include id="headlink" page="/include/head_link.jsp" />
<html:html locale="true">
<head>
<title>Welcome</title>
<html:base/>
</head>
<body bgcolor="white">


<!--Display the contents returned by invoking /include/head_link.jsp directly, with no filtering.-->
<%= headlink %>


<!--Display the contents returned by invoking /include/head_link.jsp directly, with no filtering.-->
<bean:write name="headlink" filter="false" />


<!--Display the contents returned by invoking /include/head_link.jsp directly, with filtering.-->
<bean:write name="headlink" filter="true" />


<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">
    ERROR:  Application resources not loaded -- check servlet container
    logs for error messages.
  </font>
</logic:notPresent>

<h3><bean:message key="welcome.heading"/></h3>
<p><bean:message key="welcome.message"/></p>
<a href="login.do" title="Login" target="_self">Login</a>
</body>
</html:html>
