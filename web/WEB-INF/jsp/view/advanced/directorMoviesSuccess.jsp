<spring:message code="title.successDirectorMovies" var="pageTitle" />
<spring:message code="date.pattern" var="datePattern" />
<template:main htmlTitle="${pageTitle}" bodyTitle="${pageTitle}">

  <jsp:attribute name="navigationContent"><br/>
	<a href="<c:url value="/backHome" />"><spring:message code="index.backHome"/></a><br/>
  </jsp:attribute>
  
  <jsp:attribute name="displayContent"><br/>
	
	<spring:message code="advancedQueries.directorMoviesSuccess">
		<spring:argument value="${firstName}"/>
		<spring:argument value="${lastName}"/>
	</spring:message>
	<br/><br/>

	<c:forEach items="${movies}" var="movie">
                <spring:message code="movie.title"/>: ${movie.title}<br />
                <spring:message code="movie.releaseDateDisplay"/>: <fmt:formatDate value="${movie.releaseDate}" pattern="${datePattern}" type="date" /><br />
                <spring:message code="movie.director"/>: ${movie.directorName}<br />                
                <spring:message code="movie.runningTime"/>:
                <spring:message code="movie.runningTimeDisplay">
                	<spring:argument value="${movie.runningTime}"/>
                </spring:message>
                <br /><br />                        
    </c:forEach>
		           
  </jsp:attribute>
  
</template:main>