<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод сеток</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/nets" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="functions">Введите Функции в виде p(x);q(x);f(x):</label></div>
                    <div class="col-sm-8"><input type="text" id="functions" name="functions" title="Например: x+2;x*x-2;3*x-1" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="startCondition">Граничное условие в начале интервала:</label></div>
                    <div class="col-sm-8"><input type="text" id="startCondition" name="startCondition" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="endCondition">Граничное условие на конце интервала:</label></div>
                    <div class="col-sm-8"><input type="text" id="endCondition" name="endCondition" class="form-control" required></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><input type="text"  id="interval" name="interval" class="form-control" required></div>
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