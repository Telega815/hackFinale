<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gur01
  Date: 28.09.2019
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ListCat</title>
    <meta charset="UTF-8">
    <meta name="yandex-verification" content="77b6136cd597cb51"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles1.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <ul class="tasks">
        <c:forEach items="${votes}" var="vote" varStatus="status">
            <li>
                <a href="${pageContext.request.contextPath}/Vote?vote=${vote.id}" class="taskName">
                    <img class="taskImg" src="${pageContext.request.contextPath}/resources/media/tasks.png" alt="">
                    <span class="taskText">${vote.votename}</span>
                </a>
            </li>
        </c:forEach>
        <%--<li>--%>
            <%--<a href="#" class="taskName">--%>
                <%--<img class="taskImg" src="${pageContext.request.contextPath}/resources/media/tasks.png" alt="">--%>
                <%--<span class="taskText">Банкноты и монеты Банка России</span>--%>
            <%--</a>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<a href="#" class="taskName">--%>
                <%--<img class="taskImg" src="${pageContext.request.contextPath}/resources/media/tasks.png" alt="">--%>
                <%--<span class="taskText">Памятные и инвестиционные монеты</span>--%>
            <%--</a>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<a href="#" class="taskName">--%>
                <%--<img class="taskImg" src="${pageContext.request.contextPath}/resources/media/tasks.png" alt="">--%>
                <%--<span class="taskText">Денежные знаки в иностранной валюте</span>--%>
            <%--</a>--%>
        <%--</li>--%>
    </ul>
</main>
</body>
</html>
