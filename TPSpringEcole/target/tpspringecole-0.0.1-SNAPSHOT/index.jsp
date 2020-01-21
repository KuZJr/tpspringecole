<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<ul>
	<li>
		<c:url value="/afficherProfs" var="url"></c:url>
		<a href="${url}"> <spring:message code="affichage.afficher.profs" /></a>
	</li>
	<li>
		<c:url value="/afficherClasses" var="url"></c:url>
		<a href="${url}"> <spring:message code="affichage.afficher.classes" /></a>
	</li>
</ul>