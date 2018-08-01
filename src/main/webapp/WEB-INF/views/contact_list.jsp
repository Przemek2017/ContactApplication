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
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

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
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Contact deleted successfully</p>
                    </c:if>
                    <c:if test="${param.act eq 'edt'}">
                        <p class="success">Contact updated successfully</p>
                    </c:if> 
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">Contact saved successfully</p>
                    </c:if>

                    </br>
                    <form action="<s:url value="/user/bulk_delete_contacts"/>">
                        <c:if test="${!empty contactList}">
                            <button id="deleteButton" >Delete selected</button>
                        </c:if>
                        <table border="0" width="100%" cellpadding="3" id="jtable">
                            <thead>
                                <tr>
                                    <th>Select</th>
                                    <th>Lp.</th>
                                    <th>Name</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Remark</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${empty contactList}">
                                    <tr><td align="center" class="error">Empty contact list</td></tr>
                                </c:if>

                                <c:forEach var="c" items="${contactList}" varStatus="lp">
                                    <tr align="center">
                                        <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"/></td>
                                        <td>${lp.count}.</td>
                                        <td>${c.name}</td>
                                        <td>${c.phone}</td>
                                        <td>${c.email}</td>
                                        <td>${c.address}</td>
                                        <td>${c.remark}</td>
                                        <c:url var="url_del" value="/user/delete_contact">
                                            <c:param name="cid" value="${c.contactId}"/>
                                        </c:url>
                                        <c:url var="url_edt" value="/user/edit_contact">
                                            <c:param name="cid" value="${c.contactId}"/>
                                        </c:url>
                                        <c:url var="url_email" value="/user/email_form">
                                            <c:param name="cmail" value="${c.email}"/>
                                        </c:url>
                                        <td>
                                            <a href="${url_edt}">Edit</a> | 
                                            <a href="${url_del}">Delete</a> 
                                        <c:if test="${!c.email eq '' || !empty c.email}">
                                             | <a href="${url_email}">E-mail</a>
                                        </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>      
                        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
                        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
                        <script type="text/javascript" charset="utf8" src="../static/js/simple_table.js"></script>
                        <script>
                            $(document).ready(function () {
                                var cid = 'input[name="cid"]';
                                var $submit = $("#deleteButton").hide();
                                $(document).on("change", cid, function () {
                                    console.log($(cid).is(":checked"));
                                    $submit.toggle($(cid).is(":checked"));
                                });
                            });
                        </script>
                    </form>
                </td>
            </tr>
            <br/>
            <c:url var="url_export_excel" value="/user/export/?type=excel"></c:url>
            <c:url var="url_export_pdf" value="/user/export/?type=pdf"></c:url>
            <td><a href="${url_export_excel}">Export to excel</a>  
            <td><a href="${url_export_pdf}">Export to pdf</a>  
            <tr>
                <td height = "25">
                    <!--FOOTER-->
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
