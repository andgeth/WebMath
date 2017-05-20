<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Отделение корней</h1>

    <form action="<c:url value="/divide"/>" name="form" method="post" data-toggle="validator">
        <table class="table">
            <tr style="border-top: 1px white solid">
                <td><label for="func1">Функция 1:</label></td>
                <td><input type="text" id="func1" name="func1" value="${func1}" title="Например: x+2 или x^2-2"></td>
            </tr>
            <tr>
                <td><label for="func2">Функция 2:</label></td>
                <td><input type="text" id="func2" name="func2" value="${func2}" title="Например: x+2 или x^2-2"></td>
            </tr>
            <tr>
                <td><label for="interval">Интервал:</label></td>
                <td><input type="text" id="interval" name="interval" value="${interval}"></td>
            </tr>
            <tr>
                <td><input type="text" id="func1val" name="func1val" value="${func1val}" style="display: none"></td>
            </tr>
            <tr>
                <td><input type="text" id="func2val" name="func2val" value="${func2val}" style="display: none"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="submit" value="Нарисовать">
                </td>
            </tr>
        </table>
        <div id="placeholder" style="width:600px; height:300px;"></div>
        <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
        <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/divideRoots.js"></script>
    </form>
</i:html>