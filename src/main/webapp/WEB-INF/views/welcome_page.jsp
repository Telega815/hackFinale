<%--
  Created by IntelliJ IDEA.
  User: Telega
  Date: 27.09.2019
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Центральный банк Российской Федерации</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="yandex-verification" content="77b6136cd597cb51"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/manifest.json">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/man.png">
</head>
<body>
<div class="bodyB">
    <main>
        <div class="logo">
            <img class="logoImg" src="${pageContext.request.contextPath}/resources/media/logo.png">
            <span class="logoText">Центральный банк<br>Российской Федерации</span>
        </div>
        <c:url value="/service/loginProcessing" var="loginUrl"/>
        <form:form id="inputForm" action="${loginUrl}" method="post" modelAttribute="user" class="login LoginWelPage">
            <form:input path="username" class="loginInputs" placeholder="Имя"/>
            <form:input path="pwd" class="loginInputs" placeholder="Пароль"/>
            <div id="regBlock">
                <input class="signUp regUp" type="button" value="Зарегестрироваться" onclick="location.href='/service/registration'">
                <input class="signUp regUpGo" type="submit" value="Войти">
            </div>
        </form:form>
    </main>
</div>
</body>
</html>
