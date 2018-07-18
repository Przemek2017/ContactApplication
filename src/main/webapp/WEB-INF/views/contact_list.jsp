<%-- 
    Document   : contact_form
    Created on : 2018-07-16, 22:34:35
    Author     : Przemek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="css_url" value="static/css/style.css" />
        <link href="${css_url}" rel="stylesheet" type="text/css">
        <s:url var="bg_url" value="/static/images/bg.jpg" />
        <title>Contact list</title>
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
                    <h4>Contact list</h4>
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">Contact saved successfully</p>
                    </c:if>
                    <table border="0" width="80%" cellpadding="3">
                        <tr>
                            <th>Lp.</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Remark</th>
                            <th>Action</th>
                        </tr>
                        <c:if test="${empty contactList}">
                            <tr>
                                <td align="center" class="error">Empty contact list</td>
                            </tr>
                        </c:if>
                        <c:forEach var="c" items="${contactList}" varStatus="lp">
                            <tr>
                                <td>${lp.count}.</td>
                                <td>${c.name}</td>
                                <td>${c.phone}</td>
                                <td>${c.email}</td>
                                <td>${c.address}</td>
                                <td>${c.remark}</td>
                                <td>Edit | Delete</td>
                            </tr>
                        </c:forEach>
                    </table>
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
