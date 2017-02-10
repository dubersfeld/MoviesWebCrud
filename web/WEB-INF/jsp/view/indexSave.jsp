<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>  
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="title.welcome" /></title>
  <link rel="stylesheet" href="/movies-web/resources/stylesheet/main.css" />
</head>
</head>
<body>
Language:<br/>
<a href="?locale=fr_FR">Français</a><br/>
<a href="?locale=en_US">English</a>
    

<h2><spring:message code="title.welcome" /></h2>

<a href="actorQueries"><spring:message code="index.basicActorQueries"/></a><br/>
   
<a href="directorQueries"><spring:message code="index.basicDirectorQueries"/></a><br/>

<a href="movieQueries"><spring:message code="index.basicMovieQueries"/></a><br/>

<a href="advancedQueries"><spring:message code="index.advancedQueries"/></a>
</body>
</html>