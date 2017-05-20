<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/main/webapp/WEB-INF/tags" prefix="i"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<i:html title="theory">
<c:url value="/polyLagrange.html" var="onlineUrl" />
<c:url value="/help.html" var="helpUrl" />
<c:url value="Интерполяционный многочлен Лагранжа" var="name" />
<c:url value="/theoryPolyLagrange.html" var="theoryUrl" />
<i:nav name="${name}" onlineUrl="${onlineUrl}" theoryUrl="${theoryUrl}" />
<div class="nav masthead-nav">
    <a href="pdf/polyLagrange.pdf" download><h3>Скачать теорию</h3></a>
</div>
<object data="pdf/polyLagrange.pdf" type="application/pdf" width="90%" height="600px"> </object>
</i:html>