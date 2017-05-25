<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Решение гиперболических уравнений</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/hyperbolic-eq"/>" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="initConditions">Начальные условия u(x,0);u'(x,0):</label></div>
                    <div class="col-sm-8"><input type="text" id="initConditions" name="initConditions" class="form-control" title="Например: 3*x;sin(x^2)" autofocus required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="boundConditions">Граничные условия u(a,t);u(b,t):</label></div>
                    <div class="col-sm-8"><input type="text" id="boundConditions" name="boundConditions" class="form-control" title="Например: t^3+5-2*t;t-1" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="xInterval">Интервал по пространству:</label></div>
                    <div class="col-sm-8"><input type="text" id="xInterval" name="xInterval" class="form-control" title="Пример: 0;3" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="tInterval">Интервал по времени:</label></div>
                    <div class="col-sm-8"><input type="text" id="tInterval" name="tInterval" class="form-control" title="Пример: 0;3" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="hx">Шаг по пространству:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="hx" name="hx" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="ht">Шаг по времени:</label></div>
                    <div class="col-sm-8"><input type="text" pattern="^([-]?)([0-9]+)([.]?)([0-9]*)" id="ht" name="ht" class="form-control" required></div>
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
