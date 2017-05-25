<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<i:html>
    <h1>Решение</h1>
    <input type="hidden" id="xAnswer" value="${xAnswer}">
    <input type="hidden" id="yAnswer" value="${yAnswer}">
    <input type="hidden" id="x" value="${x}">
    <input type="hidden" id="y" value="${y}">
    <input type="hidden" id="yPoints" value="${yPoints}">
    <input type="hidden" id="y1" value="${y1}">
    <input type="hidden" id="yy" value="${yy}">
    <c:if test="${drawable == true}">
        <div class="workspace container-fluid">
            <div id="placeholder" style="width: 700px; height: 300px;"></div>
        </div>
    </c:if>
    <label for="answer">Ответ: </label>
    <p class="text-success text-left" id="answer">${answer}</p>

    <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/jquery.flot.js"></script>
    <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/answerGraphic.js"></script>

</i:html>