<%-- 
    Document   : user_list
    Created on : 2018-07-22, 23:41:27
    Author     : Przemek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="css_url" value="../static/css/style.css" />
        <link href="${css_url}" rel="stylesheet" type="text/css">
        <s:url var="bg_url" value="/static/images/bg.jpg" />       
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <s:url var="jq_url" value="/static/js/jquery-3.3.1.min.js" />  
        <script src="${jq_url}"></script>
        <title>Admin Dashboard</title>
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
                    <h4>User List</h4>
                    <table border="0" width="100%" cellpadding="2" id="jtable" align="center">
                        <thead>
                            <tr align="center">
                                <th>Lp</th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>E-mail</th>
                                <th>Address</th>
                                <th>Login</th>
                                <th>Login status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="u" items="${userList}" varStatus="Lp">
                                <tr align="center">
                                    <td>${Lp.count}</td>
                                    <td>${u.userId}</td>
                                    <td>${u.name}</td>
                                    <td>${u.phone}</td>
                                    <td>${u.email}</td>
                                    <td>${u.address}</td>
                                    <td>${u.login}</td>
                                    <td>
                                        <select id="id_${u.userId}" onchange="changeStatus(${u.userId}, $(this).val())">      
                                            <option value="1">Active</option>
                                            <option value="2">Block</option>
                                        </select>
                                        <script>
                                            $('#id_${u.userId}').val(${u.loginStatus});
                                        </script>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

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
        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="../static/js/simple_table.js"></script>
        <script>
                    function changeStatus(uId, lStatus) {
                                $.ajax({
                                    url:'change_status',
                                    data:{userId: uId, loginStatus: lStatus},
                                    success: function (data){
                                        alert(data);
                                    }
                                });
//                        alert("Selected: " + userId + "\n Login status: " + loginStatus);
                    }
        </script>
    </body>
</html>

