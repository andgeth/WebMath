<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/main/webapp/WEB-INF/tags" prefix="i"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<i:html title="theory">
<c:url value="/dichotomy.html" var="onlineUrl" />
<c:url value="/help.html" var="helpUrl" />
<c:url value="Метод дихотомии" var="name" />
<c:url value="/theoryDichotomy.html" var="theoryUrl" />
<i:nav name="${name}" onlineUrl="${onlineUrl}" theoryUrl="${theoryUrl}" />
<div class="nav masthead-nav">
    <a href="pdf/dichotomy.pdf" download><h3>Скачать теорию</h3></a>
</div>
<object data="pdf/dichotomy.pdf" type="application/pdf" width="90%" height="600px"> </object>
</i:html>