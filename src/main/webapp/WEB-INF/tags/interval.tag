<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="value"%>
<input type="text" id="interval" name="interval" class="form-control" value="${value}"
       pattern="^-?[0-9]+(.[0-9]+)?;-?[0-9]+(.[0-9]+)?$" required>