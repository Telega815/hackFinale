<%--
  Created by IntelliJ IDEA.
  User: gur01
  Date: 27.09.2019
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="yandex-verification" content="77b6136cd597cb51"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_mainPage.css">
</head>
<body>
    <header>
        <div id="menu">
            <img src="${pageContext.request.contextPath}/resources/media/user_male.png" alt="">
        </div>
        <div id="search">
            <input id="searchInput" placeholder="   Поиск">
        </div>
        <div id="notification">
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
    </header>
<main>
    <div class="cat1">
        <div class="cat11"  onclick="location.href='/Category?votecategory=1'">
            <div class="cat1img">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <img src="${pageContext.request.contextPath}/resources/media/like_open.png" alt="" style="width: 25px; height: 25px;">
            </div>
            <span>jhdfgjhdfgtfd</span>
        </div>
        <div class="cat11" onclick="location.href='/Category?votecategory=2'">
            <div class="cat1img">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <img src="${pageContext.request.contextPath}/resources/media/like_close.png" alt="" style="width: 25px; height: 25px;">
            </div>
            <span>jhdfgjhdfgtfd</span>
        </div>
    </div>
    <div class="cat1">
        <div class="cat11" onclick="location.href='/Category?votecategory=3'">
            <div class="cat1img">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <img src="${pageContext.request.contextPath}/resources/media/like_close.png" alt="" style="width: 25px; height: 25px;">
            </div>
            <span>jhdfgjhdfgtfd</span>
        </div>
        <div class="cat11" onclick="location.href='/Category?votecategory=4'">
            <div class="cat1img">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <img src="${pageContext.request.contextPath}/resources/media/like_open.png" alt="" style="width: 25px; height: 25px;">
            </div>
            <span>sdfgsdfsdfsdf</span>
        </div>
    </div>
    <div id="historySpan">
        <span>История</span>
    </div>
    <div class="historyDiv">
        <div class="hist histbordup">
            <div class="histCent">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <span>Почему на банкнотах и монетах Банка России помещен герб Временного правительства 1917 года, а не герб Российской Федерации?</span>
            </div>
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
        <div class="hist">
            <div class="histCent">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <span>mxznhxzmhjfsdjhfkj</span>
            </div>
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
        <div class="hist">
            <div class="histCent">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <span>mxznhxzmhjfsdjhfkj</span>
            </div>
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
        <div class="hist">
            <div class="histCent">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <span>mxznhxzmhjfsdjhfkj</span>
            </div>
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
        <div class="hist">
            <div class="histCent">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <span>mxznhxzmhjfsdjhfkj</span>
            </div>
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
        <div class="hist histbordbottom">
            <div class="histCent">
                <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
                <span>mxznhxzmhjfsdjhfkj</span>
            </div>
            <img src="${pageContext.request.contextPath}/resources/media/asd.png" alt="">
        </div>
    </div>
</main>
</body>
</html>
