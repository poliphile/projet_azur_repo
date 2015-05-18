<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<title>Menu</title>
<html:base/>
</head>
<body bgcolor="white">
<html:form action="lancer" focus="nomUtilisateur">
<table border="0" align="center">
<tr>
<td align="right">
Numéro de la série :
</td>
<td>
<html:text property="numeroSerie" size="20" maxlength="20"/>
</td>
<td>
Temps avant départ ( en secondes)
</td>
<td>
<html:text property="tempsDepart" size="20" maxlength="20"/>
</td>
</tr>
<tr>
<td>
<html:submit property="submit" value="lancer"/>
</td>
</tr>
</table>
</html:form>
</body>
</html:html>