<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<form:form method="post" modelAttribute="creationClasse"
	action="creerClasse">
	<form:input path="id" type="hidden" />
	<b><i><form:errors path="id" cssclass="error" /></i></b>
	<br>
	<spring:message code="creation.prof.nom" />
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
<table border="1">
	<thead>
		<tr>
			<th><spring:message code="colonne.nom" /></th>
			<th><spring:message code="colonne.prof" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listeClasses}" var="classe">
			<tr>
				<td><c:out value="${classe.nom}" /></td>
				<td><c:out value="${classe.prof.nom}" /></td>
				<td><c:url value="/supprimerClasse" var="url">
						<c:param name="idClasse" value="${classe.id}" />
					</c:url> <a href="${url}"> <spring:message
							code="suppression.supprimer.libelle" />
				</a>
				</td>
				<td><c:url value="/modifierClasse" var="url">
						<c:param name="idClasse" value="${classe.id}" />
					</c:url> <a href="${url}"> <spring:message
							code="modification.modifier.libelle" />
				</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>