<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Ньютона</h1>
    <form action="<c:url value="/newton" />" method="post">
        <table class="table">
            <tr style="border-top: 1px white solid">
                <td>Функция:</td>
                <td><input type="text" id="function" name="function" title="Например: x+2 или x^2-2"></td>
            </tr>
            <tr>
                <td>Начальное приближение:</td>
                <td><i:initValue id="x0" name="x0" /></td>
            </tr>
            <tr>
                <td>Точность:</td>
                <td><i:precision /></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="submit" value="Решить">
                    <input type="submit" id="reset" name="reset" value="Сбросить значения">
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