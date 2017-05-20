<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Рунге-Кутта</h1>
    <form action="<c:url value="/runge-kutta-system" />" method="post">
        <table class="table">
            <tr>
                <td><label for="functions">Введите функции в виде f1(x,y,z);f2(x,y,z):</label></td>
                <td><input type="text" id="functions" name="functions" title="Например: x+(cos(y/3^0.5); z-sin(x/2)" autofocus required></td>
            </tr>
            <tr>
                <td><label for="interval">Интервал:</label></td>
                <td><input type="text"  id="interval" name="interval" required></td>
            </tr>
            <tr>
                <td><label for="y0">Значение 1-ой функции в начальной точке:</label></td>
                <td><input type="text"  id="y0" name="y0" autofocus required></td>
            </tr>
            <tr>
                <td><label for="z0">Введите значение 2-ой функции в начальной точке:</label></td>
                <td><input type="text" id="z0" name="z0" autofocus required></td>
            </tr>
            <tr>
                <td><label for="h">Шаг:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="h" name="h" required></td>
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