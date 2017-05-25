<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="id"%>
<%@attribute name="name"%>
<input type="text" id="${id}" name="${name}" class="form-control" pattern="^[a-zA-Z]+=-?\d+(.\d+)?$" required>