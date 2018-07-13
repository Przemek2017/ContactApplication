<%-- 
    Document   : dashboard_user
    Created on : 2018-07-05, 23:17:25
    Author     : Przemek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="css_url" value="static/css/style.css" />
        <link href="${css_url}" rel="stylesheet" type="text/css">
        <s:url var="bg_url" value="/static/images/bg.jpg" />
        <title>User Dashboard</title>
    </head>
    <body background="${bg_url}">
        <p align="right">Welcome ${sessionScope.userName}</p>
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
                <td height = "350px">
                    <!--TODO-->
                    user form
                </td>
            </tr>
            <tr>
                <td height = "25">
                    <!--FOOTER-->
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
    </body>
</html>

