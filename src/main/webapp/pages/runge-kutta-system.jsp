<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Рунге-Кутта</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/runge-kutta-system" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="functions">Введите функции в виде f1(x,y,z);f2(x,y,z):</label></div>
                    <div class="col-sm-8"><input type="text" id="functions" name="functions" class="form-control" title="Например: x+(cos(y/3^0.5); z-sin(x/2)" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input type="text"  id="interval" name="interval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="y0">Значение 1-ой функции в начальной точке:</label></div>
                    <div class="col-sm-8"><input type="text"  id="y0" name="y0" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="z0">Введите значение 2-ой функции в начальной точке:</label></div>
                    <div class="col-sm-8"><input type="text" id="z0" name="z0" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input type="text" id="h" name="h" class="form-control" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" required></div>
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