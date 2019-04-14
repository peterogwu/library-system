<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd" > 
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 

<%@page import="java.sql.Statement"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.sql.*;"%>
<HTML>
<HEAD>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="csc/n.css" rel="stylesheet" type="text/css"/>
</HEAD>
<FORM action="insert.jsp" method="post" allign="center"id="form1" name="form1" onsubmit="return validate()" >
<body bgcolor="WHITE">

<div class="head">
<center> <h1><I><font color="red" background="pink"> STUDENT ADMINSTRATION FORM</h1></center></i></font>
</DIV>
<CENTER>
<a href="index.jsp" class="btn btn-success btn-xs">HOME</a>
<a href="insert.jsp"class="btn btn-success btn-xs">REFRESH</a> 
<a href="panel.jsp"class="btn btn-success btn-xs">BACK</a> 
</CENTER> 
<center><h2><font color="green">  fill out the following form</h2></center></font>

<table align="center" >
   
<tr>
<TD>FIRST NAME:</TD><TD><INPUT type="TEXT" name="city"size="30"placeholder="ENTER YOUR FIRSTNAME"required></td>  
<TD>LAST NAME:</TD><TD><INPUT type="TEXT" name="name"size="30"placeholder="ENTER YOUR LASTNAME"required></td>     
<TD>MIDDLE NAME:</TD><TD><INPUT type="TEXT" name="email"size="30"placeholder="ENTER YOUR EMAIL"></td>   
</tr>    
<TR><TD>&nbsp;</td>
<td>&nbsp;</td>
    

</table> 

<BR>
<div class="form-group">
<CENTER>
<input type="submit"class="btn btn-primary" value="SUBMIT" >
<a href="index.jsp"class="btn btn-danger">EXIT</a>
</center>
</table>    
</div>


    
<%
String name = request.getParameter("name");
String city = request.getParameter("city");
String email = request.getParameter("email");  


Connection con = null;
int updateQuery = 0;
if(name!=null && city!=null && email!=null  ){	 
if(name!="" && city!="" && email!=""  ) {
try {
Class.forName("org.apache.derby.jdbc.ClientDriver");
con = DriverManager.getConnection("jdbc:derby://localhost:1527/fg","root","");
String queryString = "INSERT INTO student(FIRSTNAME,LASTNAME, EMAIL ) VALUES (?, ?, ?)";	   
PreparedStatement  pstatement = con.prepareStatement(queryString);
pstatement.setString(1, name);
pstatement.setString(2, city);
pstatement.setString(3, email);

updateQuery = pstatement.executeUpdate();
if (updateQuery != 0) 
{
%>

<BR>
<TABLE style="background-color: #ffffff;"align="center" WIDTH="20%" border="3"style="border-collapse:collapse"bordercolor="#33FF00">
<tr><th><font color="red" ><CENTER>Data is inserted successfully  in database..</th></tr></font></CENTER> 
</table>


<%
}
} 
catch (Exception ex) {
out.println("Unable to connect to database.");
}
finally {
con.close();
}
}
}
%>
</FORM>
</body> 
</HTML>