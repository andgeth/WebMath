<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Многочлен Ньютона</h1>
    <form action="<c:url value="/poly-newton" />" method="post">
        <table class="table">
            <tr>
                <td><label for="interval">Интервал:</label></td>
                <td><input type="text" id="interval" name="interval" required></td>
            </tr>
            <tr>
                <td><label for="xValues">Значения x:</label></td>
                <td><input type="text" pattern="^-?[0-9]+(.[0-9]+)?(,-?[0-9]+(.[0-9]+)?)*$" id="xValues" name="xValues" required></td>
            </tr>
            <tr>
                <td><label for="yValues">Значения y:</label></td>
                <td><input type="text" pattern="^-?[0-9]+(.[0-9]+)?(,-?[0-9]+(.[0-9]+)?)*$" id="yValues" name="yValues" required></td>
            </tr>
            <tr>
                <td><label for="n">n:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)$" id="n" name="n" required></td>
            </tr>
            <tr>
                <td><label for="points">Точки:</label></td>
                <td><input type="text" id="points" name="points" required></td>
            </tr>
            <tr>
                <td><label for="x">x:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)$" id="x" name="x" required></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Найти значение"></td>
            </tr>
            <c:if test="${error != null}">
                <tr>
                    <td>Ошибка: ${error}</td>
                </tr>
            </c:if>
        </table>
    </form>
</i:html>