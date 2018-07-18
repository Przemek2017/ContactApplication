<%-- 
    Document   : index
    Created on : 2018-07-02, 23:17:20
    Author     : Przemek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="css_url" value="static/css/style.css" />
        <link href="${css_url}" rel="stylesheet" type="text/css">
        <s:url var="bg_url" value="/static/images/bg.jpg" />
        <title>Login - Contact Application</title>
    </head>
    <body background="${bg_url}">
        <table border="0" width="80%" cellpadding="3" align="center">
            <tr>
                <td height = "80px">
                    <!--HEADER-->
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height = "25px">
                    <!--MENU-->
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px">
                    <c:if test="${err != null}">
                        <p class="error">${err}</p>
                    </c:if>
                    <c:if test="${param.act eq 'lo'}">
                        <p class="success">Logout successfully</p>
                    </c:if>
                    <c:if test="${param.act == 'reg'}">
                        <p class="success">User registered successfully</p>
                    </c:if>
                    <s:url var="url_login" value="/login" />
                    <f:form class="login" action="${url_login}" modelAttribute="command">
                        <table>
                            <tr>
                                <td> <f:input path="login" placeholder="Login" class="login-input"/></td>
                            </tr>
                            <tr>
                                <td> <f:password path="password" placeholder="Password" class="login-input"/> </td>
                            </tr>
                            <tr>
                                <td> <button class="login-button">Lets go!</button> </td>
                            </tr>
                        </table>
                    </f:form>
                </td>
            </tr>
            <tr>
                <td height = "25">
                    <!--FOOTER-->
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
