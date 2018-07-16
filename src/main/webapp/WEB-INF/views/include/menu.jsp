<%-- 
    Document   : menu
    Created on : 2018-07-05, 00:07:55
    Author     : Przemek
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<c:if test="${sessionScope.userId == null}">
    <!--User is not logged-->
    <a href="/ContactApplication/index">Home</a> | <a href="#">Login</a> | <a href="/ContactApplication/register_form">Register</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.userRole eq 1}">
    <!--Admin is logged - Admin menu-->
    <a href="/ContactApplication/admin/dashboard">Home</a> | <a href="#">User list</a> | <a href="/ContactApplication/logout">Logout</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.userRole eq 2}">
    <!--User is logged - user menu-->
    <a href="/ContactApplication/user/dashboard">Home</a> | <a href="/ContactApplication/user/contact_form">Add contact</a> | <a href="/ContactApplication/user/contact_list">Contact list</a> | <a href="/ContactApplication/logout">Logout</a>
</c:if>
