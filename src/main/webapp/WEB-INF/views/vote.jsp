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
</head>
<body>
<jsp:include page="header.jsp"/>
    <main>
        <div style="margin: 45px 0 0 0;">
            <div class="imgVoteClip">
                <img class="voteImg" src="https://live.staticflickr.com/8043/8120326424_39a89602a5_b.jpg" alt="">
            </div>
        <div class="voteBlock">
            <form class="voteForm" action="handler.php">
                <%--<p class="question">Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</p>--%>
                <%--<div class="choice">--%>
                    <%--<p class="answerСhoice">Офицерский состав<input type="radio" name="answer" value="a1"></p>--%>
                    <%--<p class="answerСhoice">Большой полосатый мух<input type="radio" name="answer" value="a2"></p>--%>
                    <%--<p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>--%>
                    <%--<p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>--%>
                    <%--<p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>--%>
                <%--</div>--%>
                    <p class="question">${questions.get(0).description}</p>
                    <div class="choice">
                        <c:forEach items="${answ.values().toArray()[0]}" var="answer" varStatus="status">
                            <p class="answerСhoice">${answer.description}<input type="radio" name="answer" value="a1"></p>
                        </c:forEach>
                    </div>
                <div style="padding: 80px 0 0 0;">
                    <input class="voteSubmit" type="submit" value="Проголосовать">
                </div>
            </form>
        </div>


            <div class="imgVoteClip">
                <img class="voteImg" src="https://live.staticflickr.com/8043/8120326424_39a89602a5_b.jpg" alt="">
            </div>
        <div class="voteBlock">
            <form class="voteForm" action="handler.php">
                <p class="question">Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</p>
                <div class="choice">
                    <p class="answerСhoice">Офицерский состав<input type="radio" name="answer" value="a1"></p>
                    <p class="answerСhoice">Большой полосатый мух<input type="radio" name="answer" value="a2"></p>
                    <p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>
                </div>
                <div style="padding: 80px 0 0 0;">
                    <input class="voteSubmit" type="submit" value="Проголосовать">
                </div>
            </form>
        </div>

            <div class="imgVoteClip">
                <img class="voteImg" src="https://f.sravni.ru/cms/KnowledgeBaseArticle/Picture/mat_68584.jpeg" alt="">
            </div>
        <div class="voteBlock">
            <form class="voteForm" action="handler.php">
                <p class="question">Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</p>
                <div class="choice">
                    <p class="answerСhoice" style="background: linear-gradient(to right, rgb(79,149,71) 42%, rgb(56,56,56) 42%);">
                        Офицерский состав
                        <span>42%</span>
                        <%--<input type="radio" name="answer" value="a1">--%>
                    </p>
                    <p class="answerСhoice">Большой полосатый мух<input type="radio" name="answer" value="a2"></p>
                    <p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>
                </div>
                <div class="voiceAllPeople">
                    <input class="voteSubmit" type="submit" value="Проголосовать">
                    <span>Проголосовали 57 человек</span>
                </div>
            </form>
        </div>
        </div>
    </main>
</body>
</html>
