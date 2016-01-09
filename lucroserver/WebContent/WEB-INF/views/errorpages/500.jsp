<%@ page isErrorPage="true" contentType="application/json" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	response.setContentType("application/json");
%>
<json:object>
	<json:property name="status" value="ERROR"/>
	<json:property name="message" value="500 - Internal Server Error"/>
	<json:property name="datetime">
		<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss Z" value="<%=java.util.Calendar.getInstance().getTime()%>"/>
	</json:property>
	<json:object name="response"/>
</json:object>