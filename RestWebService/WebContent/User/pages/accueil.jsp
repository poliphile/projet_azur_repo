<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Menu</title>
<base/>
</head>
<body bgcolor="white">
<s:form action="LancerSerieAction">
<table border="0" align="center">
<tr>
<td align="right">
<s:textfield label="Numéro de la série :" name="numserie" size="20" maxlength="20"/>
</td>
<td align="right">
<s:textfield label="Temps avant départ ( en secondes)" name="tempsDepart" size="20" maxlength="20"/>
</td>
</tr>
<tr>
<td align="right">
<s:submit value="Envoyer"/>
</td>
</tr>
</table>
</s:form>
</body>
</html>