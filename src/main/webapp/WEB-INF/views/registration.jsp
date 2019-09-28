<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.09.2019
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <meta name="yandex-verification" content="77b6136cd597cb51"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<main>
    <p class="loginTittle">Регистрация</p>
    <form:form id="inputForm" modelAttribute="user" method="post" class="login">
        <form:input form="inputForm" path="username" class="loginInputs" placeholder="Имя пользователя"/>
        <form:input form="inputForm" path="pwd" class="loginInputs" placeholder="Пароль"/>
        <form:input form="inputForm" path="phoneNumber" type="tel" class="loginInputs" placeholder="Телефон"/>
        <p  class="loginInputs"><form:checkbox path="juristic" name="a" value="юр лицо"/>юр лицо</p>
        <input form="inputForm" class="signUp" type="submit" value="Зарегестрироваться">
    </form:form>
</main>
</body>
</html>
