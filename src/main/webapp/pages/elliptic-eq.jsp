<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Решение эллиптических уравнений</h1>
    <form action="<c:url value="/elliptic-eq" />" method="post">
        <table class="table">
            <tr>
                <td><label for="boundConditions">Граничные условия Uab;Ubc;Ucd;Uda:</label></td>
                <td><input type="text"  id="boundConditions" name="boundConditions" title="Например: t^3+5-2*t;t-1" required></td>
            </tr>
            <tr>
                <td><label for="xInterval">Интервал по оси абсцисс:</label></td>
                <td><input type="text"  id="xInterval" name="xInterval" required></td>
            </tr>
            <tr>
                <td><label for="tInterval">Интервал по оси ординат:</label></td>
                <td><input type="text"  id="tInterval" name="tInterval" required></td>
            </tr>
            <tr>
                <td><label for="h">Шаг:</label></td>
                <td><input type="text" id="h" name="h" required></td>
            </tr>
            <tr>
                <td><label for="precision">Точность:</label></td>
                <td><input type="text" id="precision" name="precision" required></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Решить"></td>
            </tr>
            <c:if test="${error != null}">
                <tr>
                    <td>Ошибка: ${error}</td>
                </tr>
            </c:if>
        </table>
    </form>
</i:html>
