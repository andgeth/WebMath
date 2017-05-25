<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Сплайн</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/spline" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="xValues">Значения x:</label></div>
                    <div class="col-sm-8"><input type="text" id="xValues" name="xValues" class="form-control" pattern="^-?[0-9]+(.[0-9]+)?(,-?[0-9]+(.[0-9]+)?)*$" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="yValues">Значения y:</label></div>
                    <div class="col-sm-8"><input type="text" id="yValues" name="yValues" class="form-control" pattern="^-?[0-9]+(.[0-9]+)?(,-?[0-9]+(.[0-9]+)?)*$" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="x">x:</label></div>
                    <div class="col-sm-8"><input type="text" id="x" name="x" class="form-control" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)$" required></div>
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