<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="AjoutQuestionAction" enctype="multipart/form-data">
<div>
<p><s:textarea id="numeroSerie" label="Numéro de la série"></s:textarea></p>
<p><s:file name="upload"/></p>
<s:submit value="Ajouter"/>
</div>
</s:form>
</body>
</html>