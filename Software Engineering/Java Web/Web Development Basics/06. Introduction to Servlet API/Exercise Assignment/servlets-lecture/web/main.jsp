<%@ page import="java.util.List" %>
<%@ page import="servletDemo.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>Loop</h1>
<%! List<String> weekdays; %>
<%weekdays = (List<String>) request.getAttribute("weekdays");
    weekdays.add("Monday");
%>
<% for (String weekday : weekdays) { %>
        <h2><%=weekday%></h2>
<%} %>

<%! private static int readBooks = 5; %>
<% if(readBooks > 6) {%>
    <h6>
        You have read more than 6 books
    </h6>
<%}%>
<%! Person person = new Person(); %>
</body>
</html>
