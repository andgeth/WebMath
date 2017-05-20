<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<i:html>
    <h1>Решение</h1>
    <input type="hidden" id="x" value="${x}">
    <input type="hidden" id="y" value="${y}">
    <input type="hidden" id="y1" value="${y1}">
    <input type="hidden" id="yy" value="${yy}">
    <div id="placeholder" style="width: 700px; height: 300px;"></div>
    <label for="answer">Ответ: </label>
    <textarea style="width: 550px; resize: none; height: 130px; background-color: rgba(43,43,43,0.9)" id="answer" disabled>${answer}</textarea>

    <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/jquery.flot.js"></script>
    <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/answerGraphic.js"></script>
</i:html>