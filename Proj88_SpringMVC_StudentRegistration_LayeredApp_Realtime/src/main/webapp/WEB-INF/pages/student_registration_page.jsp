<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<h1 style="color:green; text-align:center;"> Student Registration Page </h1>
<form:form modelAttribute="student" method="POST">

  <table align="center" bgcolor="yellow">

     <tr>
       <th> Id: </th>
       <td> <form:input path="id" /> </td>
      </tr>

      <tr>
       <th>Name: </th>
       <td> <form:input path="name" />
       </tr>

       <tr>
         <th> Email: </th>
         <td> <form:input path="email" /> </td>
       </tr>

       <tr>
           <th>Course: </th>
           <td> <form:input path="course" /> </td>
       </tr>

       <tr>
         <td colspan="2"> <input type="submit" value="Register"> </td>
       </tr>

    </table>
 </form:form>