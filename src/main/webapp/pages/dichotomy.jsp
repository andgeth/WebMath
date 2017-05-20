<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод дихотомии</h1>
    <form action="<c:url value="/dichotomy" />" method="post">
        <table class="table">
            <tr style="border-top: 1px white solid">
                <td><label for="function">Функция:</label></td>
                <td><input type="text" id="function" name="function" required title="Например: x+2 или x^2-2"></td>
            </tr>
            <tr>
                <td>Интервал:</td>
                <td><i:interval value="${interval}" /></td>
            </tr>
            <tr>
                <td>Точность:</td>
                <td><i:precision /></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="submit" value="Решить">
                </td>
            </tr>
            <c:if test="${error != null}">
                <tr>
                    <td>Ошибка: ${error}</td>
                </tr>
            </c:if>
        </table>
    </form>
</i:html>