<%@page import="org.apache.struts.tiles.taglib.GetAttributeTag"%>
<%@ page import = "mywebapp.java.main.persistance.daoimpl.QuestionDAO" %>
<%@ page import = "mywebapp.java.main.persistance.object.QuestionDO" %>
<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<html:html>
<head>
<title>Affichage des questions</title>
<meta http-equiv="refresh" content="${time};affichageQuestion.jsp"/>
<html:base/>
</head>

<body>
<div style="margin-left:45%;" >
<div style="width:100px;height:100px;">
<%-- <img src="image.jsp?idQuestion=<%= request.getAttribute("numQuestion") %>&idSerie=<%= request.getAttribute("numSerie") %>" width="200" height="200"/> --%>
<img src="image.jsp?idQuestion=${numQuestion}&idSerie=${numSerie}" width="200" height="200"/>
</div>
<div style="margin-top:100px;">
${enonce}
</div>
</div>
</body>
<%

HttpSession mySession = request.getSession();
final QuestionDAO daoQuestion = new QuestionDAO();
final String numeroSerie = (String)mySession.getAttribute("numSerie");
final String numeroQuestion = (String)mySession.getAttribute("numQuestion");
int numeroQuestionSuivante = Integer.parseInt(numeroQuestion) + 1;
final QuestionDO question = daoQuestion.recupererQuestion(numeroQuestionSuivante,
		Integer.parseInt(numeroSerie));
mySession.setAttribute("enonce", question.getEnonce());
mySession.setAttribute("numQuestion", Integer.toString(numeroQuestionSuivante));
mySession.setAttribute("numSerie",numeroSerie);
	mySession.setAttribute("time", Integer.toString(question.getTemps()));
%>
</html:html>