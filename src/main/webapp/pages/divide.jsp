<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="i"%>

<i:html>
    <h1>Отделение корней</h1>
    <div class="container-fluid">
        <form action="<c:url value="/divide" />" method="post">
            <div class="row form-group">
                <div class="col-sm-6">
                    <label for="func1">Функция 1:</label>
                    <input type="text" id="func1" name="func1" class="form-control" value="${func1}" title="Например: x+2 или x^2-2" required>
                </div>
                <div class="col-sm-6">
                    <label for="func2">Функция 2:</label>
                    <input type="text" id="func2" name="func2" class="form-control" value="${func2}" title="Например: x+2 или x^2-2">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-sm-6">
                    <label for="xInterval">Интервал по x:</label>
                    <input type="text" id="xInterval" name="xInterval" class="form-control" value="${xInterval}" required>
                </div>
                <div class="col-sm-6">
                    <label for="yInterval">Интервал по y:</label>
                    <input type="text" id="yInterval" name="yInterval" class="form-control" value="${yInterval}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-sm-1">
                    <input type="submit" class="btn btn-default" value="Нарисовать">
                </div>
            </div>
        </form>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-offset-1">
                <div id="placeholder" style="width: 600px; height: 300px;"></div>
            </div>
        </div>
    </div>
    <input type="hidden" id="func1val" value="${func1Values}">
    <input type="hidden" id="func2val" value="${func2Values}">
    <input type="hidden" id="xValues" value="${xValues}">
    <input type="hidden" id="yValues" value="${yValues}">

    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/divideRoots.js"></script>
</i:html>