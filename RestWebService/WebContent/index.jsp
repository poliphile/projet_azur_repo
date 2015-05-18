<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<title>Authentification</title>
<html:base/>
</head>
<body bgcolor="white">
<html:form action="login" focus="nomUtilisateur">
<table border="0" align="center">
<tr>
<td align="right">
Utilisateur :
</td>
<td align="left">
<html:text property="nomUtilisateur" size="20" maxlength="20"/>
</td>
</tr>
<tr>
<td align="right">
Mot de Passe :
</td>
<td align="left">
<html:password property="mdpUtilisateur" size="20" maxlength="20"
redisplay="false"/>
</td>
</tr>
<tr>
<td align="right">
<html:submit property="submit" value="Submit"/>
</td>
<td align="left">
<html:reset/>
</td>
</tr>
</table>
</html:form>
</body>
</html:html>