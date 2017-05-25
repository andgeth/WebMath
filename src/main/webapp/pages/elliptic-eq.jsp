<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Решение эллиптических уравнений</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/elliptic-eq" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="boundConditions">Граничные условия Uab;Ubc;Ucd;Uda:</label></div>
                    <div class="col-sm-8"><input type="text"  id="boundConditions" name="boundConditions" title="Например: t^3+5-2*t;t-1" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="xInterval">Интервал по оси абсцисс:</label></div>
                    <div class="col-sm-8"><input type="text"  id="xInterval" name="xInterval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="tInterval">Интервал по оси ординат:</label></div>
                    <div class="col-sm-8"><input type="text"  id="tInterval" name="tInterval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input type="text" id="h" name="h" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="precision">Точность:</label></div>
                    <div class="col-sm-8"><input type="text" id="precision" name="precision" class="form-control" required></div>
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
