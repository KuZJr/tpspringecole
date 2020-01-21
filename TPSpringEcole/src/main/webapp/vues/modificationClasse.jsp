<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<form:form method="post" modelAttribute="modificationClasse"
	action="modifierClasseForm">
	<form:input path="id" type="hidden" />
	<b><i><form:errors path="id" cssclass="error" /></i></b>
	<br>
	<spring:message code="modification.prof.nom" />
	<form:input path="nom" />
	<b><i><form:errors path="nom" cssclass="error" /></i></b>
	<br>
	<form:select path="id_prof">
		<c:forEach items="${listeProfs}" var="prof">
		<form:option value="${prof.id}">${prof.nom}</form:option>
		</c:forEach>
	</form:select>
	<br>
	<input type="submit" />
</form:form>