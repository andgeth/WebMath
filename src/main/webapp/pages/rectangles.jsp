<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод прямоугольников</h1>
    <form action="<c:url value="/rectangles" />" method="post">
        <table class="table">
            <tr>
                <td><label for="function">Введите подынтегральную функцию в виде f(x0):</label></td>
                <td><input type="text" id="function" name="function" title="Например: x+2 или x^2-2" autofocus required></td>
            </tr>
            <tr>
                <td><label for="interval">Интервал:</label></td>
                <td><input type="text"  id="interval" name="interval" required></td>
            </tr>
            <tr>
                <td><label for="h">Шаг:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)$" id="h" name="h" required></td>
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