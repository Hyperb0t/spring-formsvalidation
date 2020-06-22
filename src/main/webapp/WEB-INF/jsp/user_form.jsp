<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <div>
        <form:label path="email">Email</form:label>
        <form:input path="email"/>
        <span><form:errors path="email"/></span>
    </div>
    <br/>
    <div>
        <form:label path="password">Password</form:label>
        <form:input path="password"/>
        <span><form:errors path="password"/></span>
    </div>
    <br/>
    <div>
        <form:label path="country">Country</form:label>
        <form:input path="country"/>
        <span><form:errors path="country"/></span>
    </div>
    <br/>
    <div>
        <form:label path="agree">Agree</form:label>
        <form:checkbox path="agree"/>
        <span><form:errors path="agree"/> </span>
    </div>
    <br/>
    <div>
        <form:label path="gender"></form:label>
        <form:select path="gender">
            <form:option value="m"></form:option>
            <form:option value="f"></form:option>
        </form:select>
        <span><form:errors path="gender"/> </span>
    </div>
    <br/>
    <input type="submit" value="SUBMIT!!">
</form:form>
</body>
</html>
