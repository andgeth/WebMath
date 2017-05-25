<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Решение параболических уравнений</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/parabolic-eq" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Функция-источник f(x,t):</label></div>
                    <div class="col-sm-8"><input type="text" id="function" name="function" title="Например: (x^2-t^2)+2*t*x-0.378*(1-1.9)" autofocus class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="initCondition">Начальное условие u(x,0):</label></div>
                    <div class="col-sm-8"><input type="text" id="initCondition" name="initCondition" title="Например: sin(PI*x/2)" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="boundConditions">Граничные условия u(a,t);u(b,t):</label></div>
                    <div class="col-sm-8"><input type="text" id="boundConditions" name="boundConditions" title="Например: t+1;t^3" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="xInterval">Интервал по пространству:</label></div>
                    <div class="col-sm-8"><input type="text" id="xInterval" name="xInterval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="tInterval">Интервал по времени:</label></div>
                    <div class="col-sm-8"><input type="text" id="tInterval" name="tInterval" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="hx">Шаг по пространству:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="hx" name="hx" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="ht">Шаг по времени:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="ht" name="ht" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="weight">Вес:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="weight" name="weight" class="form-control" required></div>
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
