<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<form:form method="post" modelAttribute="creationProf"
	action="creerProf">
	<form:input path="id" type="hidden" />
	<b><i><form:errors path="id" cssclass="error" /></i></b>
	<br>
	<spring:message code="creation.prof.nom" />
	<form:input path="nom" />
	<b><i><form:errors path="nom" cssclass="error" /></i></b>
	<br>
	<spring:message code="creation.prof.prenom" />
	<form:input path="prenom" />
	<b><i><form:errors path="prenom" cssclass="error" /></i></b>
	<br>
	<spring:message code="creation.prof.date" />
	<form:input type="date" path="date_naissance" />
	<b><i><form:errors path="date_naissance" cssclass="error" /></i></b>
	<br>
	<spring:message code="creation.prof.adresse" />
	<form:input path="adresse" />
	<b><i><form:errors path="adresse" cssclass="error" /></i></b>
	<br>
	<spring:message code="creation.prof.sexe" />
	<form:select path="sexe">
		<form:option value="HOMME" label="Homme" />
		<form:option value="FEMME" label="Femme" />
	</form:select>
	<br>
	<input type="submit" />
</form:form>
<table border="1">
	<thead>
		<tr>
			<th><spring:message code="colonne.nom" /></th>
			<th><spring:message code="colonne.prenom" /></th>
			<th><spring:message code="colonne.date" /></th>
			<th><spring:message code="colonne.adresse" /></th>
			<th><spring:message code="colonne.sexe" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listeProfs}" var="prof">
			<tr>
				<td><c:out value="${prof.nom}" /></td>
				<td><c:out value="${prof.prenom}" /></td>
				<td><c:out value="${prof.date_naissance}" /></td>
				<td><c:out value="${prof.adresse}" /></td>
				<td><c:out value="${prof.sexe}" /></td>
				<td><c:url value="/supprimerProf" var="url">
						<c:param name="idProf" value="${prof.id}" />
					</c:url> <a href="${url}"> <spring:message
							code="suppression.supprimer.libelle" />
				</a>
				</td>
				<td><c:url value="/modifierProf" var="url">
						<c:param name="idProf" value="${prof.id}" />
					</c:url> <a href="${url}"> <spring:message
							code="modification.modifier.libelle" />
				</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>