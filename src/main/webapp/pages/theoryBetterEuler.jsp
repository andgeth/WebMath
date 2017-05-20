<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/main/webapp/WEB-INF/tags" prefix="i"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<i:html title="theory">
<c:url value="/betterEuler.html" var="onlineUrl" />
<c:url value="/help.html" var="helpUrl" />
<c:url value="Усовершенствованный метод Эйлера" var="name" />
<c:url value="/theoryBetterEuler.html" var="theoryUrl" />
<i:nav name="${name}" onlineUrl="${onlineUrl}" theoryUrl="${theoryUrl}" />
<div class="nav masthead-nav">
    <a href="pdf/bettereuler.pdf" download><h3>Скачать теорию</h3></a>
</div>
<object data="pdf/bettereuler.pdf" type="application/pdf" width="90%" height="450px"> </object>
</i:html>