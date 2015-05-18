<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import = "com.opensymphony.xwork2.ActionContext" %>
        <%@ page import = " mywebapp.java.main.persistance.object.QuestionDO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="CSS/main.css" />
<title>Insert title here</title>
</head>

 <script type="text/javascript">
 <% 
	String clock =(String)ActionContext.getContext().getSession().get("time") ;
 %>
    var timeoutHandle = null;
    var timeout = <%=clock%>;
    function startTimer() {
        if (timeout <= 0) {
           document.forms['formulaireQuestionSuivante'].submit();
        } else  {
            document.getElementById('sessionTimer').innerHTML = 'Il reste : ' + timeout  + ' secondes';
        }
        timeout=timeout -1;
        timeoutHandle = setTimeout(function () { startTimer();}, '1000');
    }
    function refreshTimer() {
        killTimer(timeoutHandle);
    }
  </script>
 
<body onload="startTimer()">
 <div id="sessionTimer"></div>
 <div  class="imageContainer">
<img alt="" src="data:image/jpg;base64,<%= ((QuestionDO)ActionContext.getContext().getSession().get("Question")).getBitArrayString()%>"/>
</div>
<div style="display: none;">
<s:form action="AfficherQuestionSuivanteAction" id="formulaireQuestionSuivante">
<s:submit id="submitButton"/>
</s:form>
</div>
</body>
</html>