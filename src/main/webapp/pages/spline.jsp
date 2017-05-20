<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Сплайн</h1>
    <form action="<c:url value="/spline"/>" method="post">
        <table class="table">
            <tr>
                <td><label for="xValues">Значения x:</label></td>
                <td><input type="text" pattern="^-?[0-9]+(.[0-9]+)?(,-?[0-9]+(.[0-9]+)?)*$" id="xValues" name="xValues" required></td>
            </tr>
            <tr>
                <td><label for="yValues">Значения y:</label></td>
                <td><input type="text" pattern="^-?[0-9]+(.[0-9]+)?(,-?[0-9]+(.[0-9]+)?)*$" id="yValues" name="yValues" required></td>
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