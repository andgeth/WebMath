<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Эйлера-Коши</h1>
    <form action="<c:url value="/euler-cauchy"/>" method="post">
        <table class="table">
            <tr>
                <td><label for="function">Введите функцию в виде f(x,y):</label></td>
                <td><input type="text" id="function" name="function" title="Например: x+2;x+(cos(y/3^0.5)" autofocus required>
                </td>
            </tr>
            <tr>
                <td><label for="interval">Интервал:</label></td>
                <td><input type="text" pattern="^-?[0-9]+(.[0-9]+)?;-?[0-9]+(.[0-9]+)?$" id="interval" name="interval" required></td>
            </tr>
            <tr>
                <td><label for="y0">Значение искомой функции в начальной точке:</label></td>
                <td><input type="text" pattern="^[a-zA-Z][a-zA-Z0-9]*=-?[0-9]+(.[0-9]+)?$" id="y0" name="y0" required></td>
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