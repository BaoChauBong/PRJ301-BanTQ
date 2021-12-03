<%-- 
    Document   : student
    Created on : Sep 21, 2021, 2:38:27 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <%
            ArrayList<Student> students
                    = (ArrayList<Student>) request.getAttribute("students");
        %>
    </head>
    <body>
        Number of Students: <input type="text" name="id" size="10" value="" />
        <input type="submit" value="Generate" />
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>DOB</th>
            </tr>
            <% for (Student s : students) {
            %>
            <tr>
                <td>
                    <%=s.getId()%>
                </td>
                <td>
                    <%=s.getName()%>
                </td>
                <td>
                    <input type="checkbox" <%=s.getGender()?"checked":""%>>
                </td>
                <td>
                    <%=s.getDobFormat()%>
                </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
