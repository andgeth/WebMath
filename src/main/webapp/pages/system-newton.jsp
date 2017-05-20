<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Ньютона</h1>
    <form action="<c:url value="/system-newton" />" method="post">
        <table class="table">
            <tr>
                <td>Введите функции в виде f1(x,y);f2(x,y):</td>
                <td><input type="text" id="functions" name="functions" title="Например: x+y^2;x-2*z" autofocus required></td>
            </tr>
            <tr>
                <td>Интервал:</td>
                <td><i:interval /></td>
            </tr>
            <tr>
                <td>Начальное приближение x:</td>
                <td><i:initValue id="x0" name="x0" /></td>
            </tr>
            <tr>
                <td>Начальное приближение y:</td>
                <td><i:initValue id="y0" name="y0" /></td>
            </tr>
            <tr>
                <td>Точность:</td>
                <td><i:precision /></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="submit" value="Решить"
                </td>
            </tr>
            <c:if test="${error != null}">
                <tr>
                    <td>Ошибка:<br></td>
                    <td>${error}</td>
                </tr>
            </c:if>
        </table>
    </form>
</i:html>
