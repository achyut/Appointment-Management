<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />

<% 
 String message = (String)session.getAttribute("message");
%>
<div class="container">
	<div class="jumbotron">
<label for="message"><font color="#e67e22" size="4">
<% if (message != null) { %>
	<%=message%>
	
	<%
	session.setAttribute("message","");
}
	%>
	</font></label>
		<h1><font style="color: #e67e22"> MavAppoint </font></h1>
	</div>
</div>
<%@include file="templates/footer.jsp"%>