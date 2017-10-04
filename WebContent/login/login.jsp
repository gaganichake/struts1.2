<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<bean:include id="headlink" page="/include/head_link.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
</head>

<body>
<bean:write name="headlink" filter="false" />

<logic:messagesPresent>
   <ul>
   <html:messages id="errors">
      <li><bean:write name="errors"/></li>
   </html:messages>
</ul
></logic:messagesPresent>

With custom JavaBean using ActonForm
<html:form action="login-submit"><!--No need to and <code>.do</code>, automatically add as defined in web.xml-->
<!--<form action="login-submit.do" method="post" enctype="application/x-www-form-urlencoded" target="_self">--><!--Need to manually add <code>.do</code>--> 
<table width="300" border="1" cellpadding="0" cellspacing="1" bordercolor="#000000">
  <tr>
    <td colspan="2" bgcolor="#666666"><strong>Login</strong></td>
  </tr>
  <tr>
    <td width="90"><strong>Username</strong></td>
    <td><strong>
      <input type="text" name="username" id="username" value="" />
    </strong></td>
    </tr>
  <tr>
    <td><strong>Password</strong></td>
    <td><strong>
      <input type="password" name="password" id="password" value="" />
    </strong></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="login" id="login" value="Login" /></td>
  </tr>
</table>
<!--</form>-->
</html:form>
<hr/>
Using DynaActionForm<br />
(If you do not supply an initial attribute, numbers will be initialized to 0 and objects to null. )
<form action="login-submit-dyna.do" method="post" enctype="application/x-www-form-urlencoded" target="_self"><!--Need to manually add <code>.do</code>--> 
<table width="300" border="1" cellpadding="0" cellspacing="1" bordercolor="#000000">
  <tr>
    <td colspan="2" bgcolor="#666666"><strong>Login</strong></td>
  </tr>
  <tr>
    <td width="90"><strong>Username</strong></td>
    <td><strong>
      <input type="text" name="username" id="username" value="" />
    </strong></td>
    </tr>
  <tr>
    <td><strong>Password</strong></td>
    <td><strong>
      <input type="password" name="password" id="password" value="" />
    </strong></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="login" id="login" value="Login" /></td>
  </tr>
</table>
</form>
<hr/>
<form action="login-submit-js.do" method="post" enctype="application/x-www-form-urlencoded" target="_self">
  <!--Need to manually add <code>.do</code>--> 
Using ValidatorForm
<table width="300" border="1" cellpadding="0" cellspacing="1" bordercolor="#000000">
  <tr>
    <td colspan="2" bgcolor="#666666"><strong>Login</strong></td>
  </tr>
  <tr>
    <td width="90"><strong>Username</strong></td>
    <td><strong>
      <input type="text" name="username" id="username" value="" />
    </strong></td>
    </tr>
  <tr>
    <td><strong>Password</strong></td>
    <td><strong>
      <input type="password" name="password" id="password" value="" />
    </strong></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="login" id="login" value="Login" /></td>
  </tr>
</table>
</form>

<hr/>
<form action="login-submit-validate.do" name="loginValidatorForm" method="post" enctype="application/x-www-form-urlencoded" target="_self"  onsubmit="return validateLoginValidatorForm(this);">
<!--Need to manually add <code>.do</code>--> 
Using JavaScript Client (Client side) validation
<table width="300" border="1" cellpadding="0" cellspacing="1" bordercolor="#000000">
  <tr>
    <td colspan="2" bgcolor="#666666"><strong>Login</strong></td>
  </tr>
  <tr>
    <td width="90"><strong>Username</strong></td>
    <td><strong>
      <input type="text" name="username" id="username" value="" />
    </strong></td>
    </tr>
  <tr>
    <td><strong>Password</strong></td>
    <td><strong>
      <input type="password" name="password" id="password" value="" />
    </strong></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="login" id="login" value="Login" /></td>
  </tr>
</table>
</form>
<html:javascript formName="loginValidatorForm"/>
</body>
</html>
