<%--
  Created by IntelliJ IDEA.
  User: Telega
  Date: 27.09.2019
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Центральный банк Российской Федерации</title>
    <meta charset="UTF-8">
    <meta name="yandex-verification" content="77b6136cd597cb51"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <main>
        <div class="logo">
            <img class="logoImg" src="${pageContext.request.contextPath}/resources/media/logo.png">
            <span class="logoText">Центральный банк<br>Российской Федерации</span>
        </div>
        <form class="login">
            <input class="loginInputs" placeholder="Имя">
            <input class="loginInputs" placeholder="Пароль">
            <input class="signUp" type="button" value="Войти">
            <input class="signUp" type="button" value="Зарегестрироваться" onclick="location.href='/registration'">
        </form>
    </main>
</body>
</html>
