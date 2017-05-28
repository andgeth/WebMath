<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="i"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/patterns"%>

<i:html>
    <h1>Метод Ньютона</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/system-newton" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="functions">Введите функции в виде f1(x,y);f2(x,y):</label></div>
                    <div class="col-sm-8"><input id="functions" name="functions" class="form-control" value="${functions}"
                                                 title="Например: x+y^2;x-2*z" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input id="interval" name="interval" class="form-control" value="${interval}"
                                                 pattern="${intervalPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x0">Начальное приближение x:</label></div>
                    <div class="col-sm-8"><input id="x0" name="x0" class="form-control" value="${x0}" pattern="${initValuePattern}"
                                                 required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="y0">Начальное приближение y:</label></div>
                    <div class="col-sm-8"><input id="y0" name="y0" class="form-control" value="${y0}" pattern="${initValuePattern}"
                                                 required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="e">Точность:</label></div>
                    <div class="col-sm-8"><input id="e" name="e" class="form-control" value="${e}" pattern="${ePattern}"
                                                 required></div>
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
