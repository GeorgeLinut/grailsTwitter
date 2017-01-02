<%--
  Created by IntelliJ IDEA.
  User: glinut
  Date: 12/31/2016
  Time: 6:57 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Revelion 2017</title>
    <g:javascript library="prototype"/>

</head>

<body>
<div>
    <h1>Search for people to Follow</h1>
    <div class="searchForm">
        <g:form controller="searchable">
            <g:textField name="q" value=""/>
        </g:form>
    </div>
    <h1>What are you doing?</h1>
    <div class="updateStatusForm">
        <g:formRemote name="updateStatusForm" onSuccess="document.getElementById('messageArea').value='';" url="[action: 'updateStatus']" update = "messageList"
        >
            <g:textArea name="message" value="" id="messageArea"/><br/>
            <g:submitButton name="Update Status"/>
        </g:formRemote>
    </div>
    <div id="messageList">
        <g:render template="messages" collection="${messages}" var="message"/>
    </div>
</div>
</body>
</html>