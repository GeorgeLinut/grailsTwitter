<%--
  Created by IntelliJ IDEA.
  User: glinut
  Date: 1/2/2017
  Time: 2:28 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<g:each var="person" in="${searchResult?.results}">
    <div id="name">
        ${person.realName}<g:link id="${person.id}"
                                  action="follow" controller="status"> follow </g:link>
    </div>
</g:each>
</body>
</html>