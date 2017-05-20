<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Решение параболических уравнений</h1>
    <form action="<c:url value="/parabolic-eq" />" method="post">
        <table class="table">
            <tr>
                <td><label for="function">Функция-источник f(x,t):</label></td>
                <td><input type="text" id="function" name="function" title="Например: (x^2-t^2)+2*t*x-0.378*(1-1.9)" autofocus required></td>
            </tr>
            <tr>
                <td><label for="initCondition">Начальное условие u(x,0):</label></td>
                <td><input type="text" id="initCondition" name="initCondition" title="Например: sin(PI*x/2)" autofocus required></td>
            </tr>
            <tr>
                <td><label for="boundConditions">Граничные условия u(a,t);u(b,t):</label></td>
                <td><input type="text" id="boundConditions" name="boundConditions" title="Например: t+1;t^3" required></td>
            </tr>
            <tr>
                <td><label for="xInterval">Интервал по пространству:</label></td>
                <td><input type="text" id="xInterval" name="xInterval" required></td>
            </tr>
            <tr>
                <td><label for="tInterval">Интервал по времени:</label></td>
                <td><input type="text" id="tInterval" name="tInterval" required></td>
            </tr>
            <tr>
                <td><label for="hx">Шаг по пространству:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="hx" name="hx" required></td>
            </tr>
            <tr>
                <td><label for="ht">Шаг по времени:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="ht" name="ht" required></td>
            </tr>
            <tr>
                <td><label for="weight">Вес:</label></td>
                <td><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="weight" name="weight" required></td>
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
