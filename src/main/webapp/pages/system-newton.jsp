<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Ньютона</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/system-newton" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="functions">Введите функции в виде f1(x,y);f2(x,y):</label></div>
                    <div class="col-sm-8"><input type="text" id="functions" name="functions" class="form-control" title="Например: x+y^2;x-2*z" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><i:interval /></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x0">Начальное приближение x:</label></div>
                    <div class="col-sm-8"><i:initValue id="x0" name="x0" /></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="y0">Начальное приближение y:</label></div>
                    <div class="col-sm-8"><i:initValue id="y0" name="y0" /></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="e">Точность:</label></div>
                    <div class="col-sm-8"><i:precision /></div>
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
