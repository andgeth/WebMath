<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Метод дихотомии</h1>
    <div class="workspace container-fluid">
        <form action="<c:url value="/dichotomy" />" method="post">
            <fieldset id="inputs">
                <div class="row form-group">
                    <div class="col-sm-4"><label for="function">Функция:</label></div>
                    <div class="col-sm-8"><input type="text" id="function" name="function" class="form-control" required title="Например: x+2 или x^2-2"></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="interval">Интервал:</label></div>
                    <div class="col-sm-8"><i:interval /></div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-4"><label for="e">Точность:</label></div>
                    <div class="col-sm-8"><i:precision /></div>
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