<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод хорд</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/chord" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Функция</label></div>
                    <div class="col-sm-8"><input id="function" name="function" class="form-control" value="${function}"
                                                 title="Например: x+2 или x^2-2" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x1">Начальное приближение x1:</label></div>
                    <div class="col-sm-8"><input id="x1" name="x1" class="form-control" value="${x1}"
                                                 pattern="${initValuePattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x2">Начальное приближение x2:</label></div>
                    <div class="col-sm-8"><input id="x2" name="x2" class="form-control" value="${x2}"
                                                 pattern="${initValuePattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="e">Точность:</label></div>
                    <div class="col-sm-8"><input id="e" name="e" class="form-control" pattern="${ePattern}" required></div>
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