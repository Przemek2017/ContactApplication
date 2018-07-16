<%-- 
    Document   : contact_form
    Created on : 2018-07-16, 22:34:35
    Author     : Przemek
--%>

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
        <title>Contact form</title>
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
                <td height = "350px">
                    <s:url var="url_save_contact" value="/user/save_contact" />
                    <f:form class="login" action="${url_save_contact}" modelAttribute="command">
                        <table>
                            <c:if test="${err != null}">
                                <p class="error">${err}</p>
                            </c:if>
                            <tr>
                                <td>
                                    <f:input path="name" placeholder="Name" class="login-input"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <f:input path="phone" placeholder="Phone" class="login-input"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <f:input path="email" placeholder="E-mail" class="login-input"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <f:input path="address" placeholder="Address" class="login-input"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <f:textarea path="remark" placeholder="Remark" class="login-input"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button class="login-button">Save</button>
                                </td>
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
    </body>
</html>
