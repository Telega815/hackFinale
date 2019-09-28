<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.09.2019
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form class="login">
        <input class="loginInputs" placeholder="Имя пользователя">
        <input class="loginInputs" placeholder="Пароль">
        <input class="loginInputs" type="tel" class="loginInputs" placeholder="Телефон">
        <p  class="loginInputs"><input type="checkbox" name="a" value="юр лицо">юр лицо</p>
        <input class="signUp" type="button" value="Зарегестрироваться">
    </form>
</main>
</body>
</html>
