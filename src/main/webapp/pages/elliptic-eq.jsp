<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Решение эллиптических уравнений</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/elliptic-eq" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="boundConditions">Граничные условия Uab;Ubc;Ucd;Uda:</label></div>
                    <div class="col-sm-8"><input id="boundConditions" name="boundConditions" class="form-control"
                                                 value="${boundConditions}" title="Например: t^3+5-2*t;t-1" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="xInterval">Интервал по оси абсцисс:</label></div>
                    <div class="col-sm-8"><input id="xInterval" name="xInterval" class="form-control" value="${xInterval}"
                                                 pattern="${intervalPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="tInterval">Интервал по оси ординат:</label></div>
                    <div class="col-sm-8"><input id="tInterval" name="tInterval" class="form-control" value="${tInterval}"
                                                 pattern="${intervalPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input id="h" name="h" class="form-control" value="${h}" pattern="${hPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="e">Точность:</label></div>
                    <div class="col-sm-8"><input id="e" name="e" class="form-control" value="${e}" pattern="${ePattern}" required></div>
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
