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

    <script src="${pageContext.request.contextPath}/resources/js/LoDash.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
    <main>
        <div style="margin: 45px 0 0 0;">


            <script type="text/template" id="questionTemplate">
                <jsp:include page="includes/question.jsp"/>
            </script>

    <c:forEach items="${questions}" var="question" varStatus="status">

        <c:set var="passed" value="0"/>
        <c:forEach items="${wached}" var="wat" varStatus="status">
            <c:if test="${question.id == wat.question.id}">
                <c:set var="passed" value="1"/>
            </c:if>
        </c:forEach>

        <c:if test="${passed == 1}">
            <div class="imgVoteClip">
                <img class="voteImg" src="${pageContext.request.contextPath}/resources/media/a (${question.id%6+1}).jpg" alt="">
            </div>
            <div class="voteBlock">
                <form class="voteForm">
                    <p class="question">${question.description}</p>
                    <div class="choice">
                        <c:forEach items="${question.answers.values()}" var="answer" varStatus="status">
                            <c:set var="percent" value="${String.format('%1$,.0f', answer.votecount/voteMap.get(question.id)*100)}"/>
                            <p class="answerСhoice" style="background: linear-gradient(to right, rgb(79,149,71) ${percent}%, rgb(56,56,56) ${percent}%);">
                                    ${answer.description}
                                <span>${percent}%</span>
                                    <%--<input type="radio" name="answer" value="a1">--%>
                            </p>
                            <%--<p class="answerСhoice">${answer.description}<input onclick="answChoise(event)" class="answerForQ_${question.id}" id="answer_${answer.id}" type="radio" name="answer" value="a1"></p>--%>
                        </c:forEach>
                    </div>
                    <div class="voiceAllPeople">
                        <span>Проголосовали ${voteMap.get(question.id)} человек</span>
                        <%--<input id="qSubmit_${question.id}" onclick="voteNow(event)" class="voteSubmit" type="button" value="Проголосовать">--%>
                    </div>
                </form>
            </div>
        </c:if>

        <c:if test="${passed == 0}">
            <div class="imgVoteClip">
                <img class="voteImg" src="${pageContext.request.contextPath}/resources/media/a (${question.id%6+1}).jpg" alt="">
            </div>
            <div class="voteBlock">
                <form class="voteForm">
                    <p class="question">${question.description}</p>
                    <div id="answers_${question.id}" class="choice">
                        <c:forEach items="${question.answers.values()}" var="answer" varStatus="status">
                            <p class="answerСhoice">${answer.description}<input onclick="answChoise(event)" class="answerForQ_${question.id}" id="answer_${answer.id}" type="radio" name="answer" value="a1"></p>
                        </c:forEach>
                    </div>
                    <div class="voiceAllPeople" id="qSubmitWrapper_${question.id}">
                        <input id="qSubmit_${question.id}" onclick="voteNow(event)" class="voteSubmit" type="button" value="Проголосовать">
                    </div>
                </form>
            </div>
        </c:if>

    </c:forEach>

            <%--<div class="imgVoteClip">--%>
                <%--<img class="voteImg" src="https://f.sravni.ru/cms/KnowledgeBaseArticle/Picture/mat_68584.jpeg" alt="">--%>
            <%--</div>--%>
        <%--<div class="voteBlock">--%>
            <%--<form class="voteForm" action="handler.php">--%>
                <%--<p class="question">Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</p>--%>
                <%--<div class="choice">--%>
                    <%--<p class="answerСhoice" style="background: linear-gradient(to right, rgb(79,149,71) 42%, rgb(56,56,56) 42%);">--%>
                        <%--Офицерский состав--%>
                        <%--<span>42%</span>--%>
                        <%--&lt;%&ndash;<input type="radio" name="answer" value="a1">&ndash;%&gt;--%>
                    <%--</p>--%>
                    <%--<p class="answerСhoice">Большой полосатый мух<input type="radio" name="answer" value="a2"></p>--%>
                    <%--<p class="answerСhoice">Операционная система<input type="radio" name="answer" value="a3"></p>--%>
                <%--</div>--%>
                <%--<div class="voiceAllPeople">--%>
                    <%--<input class="voteSubmit" type="submit" value="Проголосовать">--%>
                    <%--<span>Проголосовали 57 человек</span>--%>
                <%--</div>--%>
            <%--</form>--%>
        </div>
        </div>
    </main>
</body>
</html>
