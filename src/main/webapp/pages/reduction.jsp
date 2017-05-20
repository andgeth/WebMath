<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод редукции</h1>
    <form action="<c:url value="/reduction"/>" method="post">
        <table class="table">
            <tr>
                <td><label for="functions">Введите Функции в виде p(x);q(x);f(x):</label></td>
                <td><input type="text" id="functions" name="functions" title="Например: x+2;x*x-2;3*x-1" autofocus required></td>
            </tr>
            <tr>
                <td><label for="startCondition">Граничное условие в начале интервала:</label></td>
                <td><input type="text"  id="startCondition" name="startCondition" required></td>
            </tr>
            <tr>
                <td><label for="endCondition">Граничное условие на конце интервала:</label></td>
                <td><input type="text"  id="endCondition" name="endCondition" required></td>
            </tr>
            <tr>
                <td><label for="interval">Интервал:</label></td>
                <td><input type="text"  id="interval" name="interval" required></td>
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