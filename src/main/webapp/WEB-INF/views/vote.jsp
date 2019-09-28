<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.09.2019
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Голосование</title>
    <meta charset="UTF-8">
    <meta name="yandex-verification" content="77b6136cd597cb51"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vote.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/VoteScripts.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
    <main>
        <div style="margin: 45px 0 0 0;">


        <c:forEach items="${questions}" var="question" varStatus="status">

            <div class="imgVoteClip">
                <img class="voteImg" src="https://live.staticflickr.com/8043/8120326424_39a89602a5_b.jpg" alt="">
            </div>
        <div class="voteBlock">
            <form class="voteForm" action="handler.php">
                    <p class="question">${question.description}</p>
                    <div class="choice">
                        <c:forEach items="${answ.values().toArray()[question.id-1]}" var="answer" varStatus="status">
                            <p class="answerСhoice">${answer.description}<input onclick="answChoise(event)" class="answerForQ_${question.id}" id="answer_${answer.id}" type="radio" name="answer" value="a1"></p>
                        </c:forEach>
                    </div>
                <div style="padding: 80px 0 0 0;">
                    <input id="qSubmit_${question.id}" onclick="voteNow(event)" class="voteSubmit" type="button" value="Проголосовать">
                </div>
            </form>
        </div>

    </c:forEach>

            <%--<div class="imgVoteClip">--%>
                <%--<img class="voteImg" src="https://live.staticflickr.com/8043/8120326424_39a89602a5_b.jpg" alt="">--%>
            <%--</div>--%>
        <%--<div class="voteBlock">--%>
            <%--<form class="voteForm" action="handler.php">--%>
                <%--<p class="question">Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</p>--%>
                <%--<div class="choice">--%>
                    <%--<p class="answerСhoice">Офицерский состав<input type="radio" name="answer" value="a1"></p>--%>
                    <%--<p class="answerСhoice">Большой полосатый мух<input type="radio" name="answer" value="a2"></p>--%>
                    <%--<p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>--%>
                <%--</div>--%>
                <%--<div style="padding: 80px 0 0 0;">--%>
                    <%--<input class="voteSubmit" type="submit" value="Проголосовать">--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>

            <%--<div class="imgVoteClip">--%>
                <%--<img class="voteImg" src="https://f.sravni.ru/cms/KnowledgeBaseArticle/Picture/mat_68584.jpeg" alt="">--%>
            <%--</div>--%>
        <%--<div class="voteBlock">--%>
            <%--<form class="voteForm" action="handler.php">--%>
                <%--<p class="question">Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</p>--%>
                <%--<div class="choice">--%>
                    <%--<p class="answerСhoice">Офицерский состав<input type="radio" name="answer" value="a1"></p>--%>
                    <%--<p class="answerСhoice">Большой полосатый мух<input type="radio" name="answer" value="a2"></p>--%>
                    <%--<p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>--%>
                <%--</div>--%>
                <%--<div style="padding: 80px 0 0 0;">--%>
                    <%--<input class="voteSubmit" type="submit" value="Проголосовать">--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
        </div>
    </main>
</body>
</html>
