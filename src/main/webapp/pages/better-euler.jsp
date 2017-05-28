<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="i" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/patterns" %>

<i:html>
    <h1>Усоверш. метод Эйлера</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/better-euler" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Введите функцию в виде f(x,y):</label></div>
                    <div class="col-sm-8"><input id="function" name="function" class="form-control" value="${function}" title="Например: x+2;x+(cos(y/3^0.5)" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input id="interval" name="interval" class="form-control" value="${interval}" pattern="${intervalPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="y0">Значение искомой функции в начальной точке:</label></div>
                    <div class="col-sm-8"><input id="y0" name="y0" class="form-control" value="${y0}" pattern="${initValuePattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input id="h" name="h" class="form-control" value="${h}" pattern="${hPattern}" required></div>
                </div>
            </fieldset>
            <fieldset id="buttons">
                <div class="row form-group">
                    <div class="col-sm-5">
                        <input type="submit" class="btn btn-default" value="Решить">
                    </div>
                </div>
            </fieldset>
            <c:if test="${error != null}">
                Ошибка: ${error}
            </c:if>
        </form>
    </div>
</i:html>