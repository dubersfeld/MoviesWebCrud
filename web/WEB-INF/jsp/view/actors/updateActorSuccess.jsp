<spring:message code="title.successUpdateActor" var="pageTitle" />
<spring:message code="date.pattern" var="datePattern" />
<template:main htmlTitle="${pageTitle}" bodyTitle="${pageTitle}">

 <jsp:attribute name="navigationContent"><br/>
	<a href="<c:url value="/backHome" />"><spring:message code="index.backHome"/></a><br/>
  </jsp:attribute>
  
  <jsp:attribute name="displayContent"><br/>
  
  	<h2><spring:message code="actor.actorData"/></h2>
   	<table>
    <tr>
        <td><spring:message code="personal.firstName"/></td>
        <td>${actor.firstName}</td>
    </tr>
    <tr>
        <td><spring:message code="personal.lastName"/></td>
        <td>${actor.lastName}</td>
    </tr>
    <tr>
        <td><spring:message code="personal.birthDateDisplay"/></td>
        <td><fmt:formatDate value="${actor.birthDate}" pattern="${datePattern}" type="date" /></td>
    </tr>
    <tr>
        <td><spring:message code="personal.id"/></td>
        <td>${actor.id}</td>
    </tr>
	</table>  
 
  </jsp:attribute>
  
</template:main>