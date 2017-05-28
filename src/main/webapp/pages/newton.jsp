<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="i" tagdir="/WEB-INF/tags"%>

<i:html>
    <h1>Метод Ньютона</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/newton" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Функция:</label></div>
                    <div class="col-sm-8"><input id="function" name="function" class="form-control" value="${function}"
                                                 title="Например: x+2 или x^2-2" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x0">Начальное приближение:</label></div>
                    <div class="col-sm-8"><input id="x0" name="x0" class="form-control" value="${x0}"
                                                 pattern="${initValuePattern}" required></div>
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