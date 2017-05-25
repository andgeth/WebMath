<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод прямоугольников</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/rectangles" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Введите подынтегральную функцию в виде f(x0):</label></div>
                    <div class="col-sm-8"><input type="text" id="function" name="function" title="Например: x+2 или x^2-2" autofocus class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input type="text"  id="interval" name="interval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)$" id="h" name="h" class="form-control" required></div>
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