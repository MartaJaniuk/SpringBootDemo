<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<table>
  <tr>
    <th>Path</th>
    <th>Message</th>

  </tr>
  <c:forEach items="${violations}" var="violation">
    <tr>
      <td>${violation.getPropertyPath()}</td>
      <td>${violation.getMessage()}</td>

    </tr>
  </c:forEach>
</table>

</body>
</html>
