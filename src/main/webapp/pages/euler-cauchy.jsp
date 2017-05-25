<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод Эйлера-Коши</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/euler-cauchy"/>" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Введите функцию в виде f(x,y):</label></div>
                    <div class="col-sm-8"><input type="text" id="function" name="function" class="form-control" title="Например: x+2;x+(cos(y/3^0.5)" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^-?[0-9]+(.[0-9]+)?;-?[0-9]+(.[0-9]+)?$" id="interval" name="interval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="y0">Значение искомой функции в начальной точке:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^[a-zA-Z][a-zA-Z0-9]*=-?[0-9]+(.[0-9]+)?$" id="y0" name="y0" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="h" name="h" class="form-control" required></div>
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