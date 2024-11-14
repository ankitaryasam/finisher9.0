<%@ page isELIgnored="false"  import="java.util.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>



<h1 style="text-align:center">Welcome to Student Info Page </h1>

<h2 style="text-align:center; color:red;">
  <table>
    <tr>
    <th> Name </th>
    <th> Courses </th>
    <th> Marks </th>
    <th> Contact No. </th>
    <th> Coupons </th>
    </tr>
    <tr>
    <td> ${name} </td>
    <td> ${courseEnrolled}</td>
    <td> ${examMarks}</td>
    <td> ${phoneNumbers}</td>
    <td> ${accessCoupons}</td>
  </table>


 </h2>

 <h1>${accessCoupons[0]} ${accessCoupons[1]}  ${accessCoupons[2]} </h1>


 <%=
 Arrays.toString((String[])request.getAttribute("accessCoupons"))
 %>



  <% for(String couponCode: (String[])request.getAttribute("accessCoupons"))
    System.out.println(couponCode);
    %>


   <c:forEach var="coupon"  items="${accessCoupons}">
     <h1> ${coupon} </h1>
   </c:forEach>