<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="i"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/patterns"%>

<i:html>
    <h1>Метод редукции</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/reduction" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="functions">Введите Функции в виде p(x);q(x);f(x):</label></div>
                    <div class="col-sm-8"><input id="functions" name="functions" class="form-control" value="${functions}"
                                                 title="Например: x+2;x*x-2;3*x-1" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="startCondition">Граничное условие в начале интервала:</label></div>
                    <div class="col-sm-8"><input id="startCondition" name="startCondition" class="form-control" value="${startCondition}"
                                                 required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="endCondition">Граничное условие на конце интервала:</label></div>
                    <div class="col-sm-8"><input id="endCondition" name="endCondition" class="form-control" value="${endCondition}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input id="interval" name="interval" class="form-control" value="${interval}"
                                                 pattern="${intervalPattern}" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="h">Шаг:</label></div>
                    <div class="col-sm-8"><input id="h" name="h" class="form-control" value="${h}" pattern="${hPattern}" required></div>
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