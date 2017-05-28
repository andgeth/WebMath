<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="i"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/patterns" %>

<i:html>
    <h1>Многочлен Ньютона</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/poly-newton" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="xValues">Значения x:</label></div>
                    <div class="col-sm-8"><input id="xValues" name="xValues" class="form-control" value="${xValues}"
                                                 pattern="${multiValuesPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="yValues">Значения y:</label></div>
                    <div class="col-sm-8"><input id="yValues" name="yValues" class="form-control" value="${yValues}"
                                                 pattern="${multiValuesPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="points">Точки:</label></div>
                    <div class="col-sm-8"><input id="points" name="points" class="form-control" value="${points}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x">x:</label></div>
                    <div class="col-sm-8"><input id="x" name="x" class="form-control" value="${x}" required></div>
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