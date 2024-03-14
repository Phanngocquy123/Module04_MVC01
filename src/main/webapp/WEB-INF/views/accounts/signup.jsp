
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>SIGN UP</h1>
    <f:form action="/accounts/signup" method="post" modelAttribute="account">
        <table>
            <tr>
                <th>User Name: </th>
                <td>
                    <f:input path="userName" />
                    <f:errors path="userName" />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <f:input path="password" />
                    <f:errors path="password" />
                </td>
            </tr>
            <tr>
                <th>Phone: </th>
                <td>
                    <f:input path="phone" />
                    <f:errors path="phone" />
                </td>
            </tr>
            <tr>
                <th>Birth Day: </th>
                <td>
                    <f:input path="birthDay" />
                    <f:errors path="birthDay" />
                </td>
            </tr>
        </table>
        <button>Sign Up</button>
    </f:form>
</body>
</html>
