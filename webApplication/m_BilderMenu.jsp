
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

  <HTML>
  <!-- This file was generated by IBM WebSphere Studio 3.5 using i:\wsstudio\BIN\GenerationStyleSheets\V3.5\JSP1.0\ServletModel\HTMLPages.xsl -->
  <HEAD>
 <META HTTP-EQUIV="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5.3 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
  
  <LINK href="theme/Master.css" rel="stylesheet" type="text/css">
  
  <TITLE></TITLE>
</HEAD>
<BODY bgcolor="#99bb33" text="#000000" link="#0000ff" vlink="#cc00cc" alink="#ff6699" background="images/g_bcg006.gif">
<%@ page import="urlaubsbilder.beans.*" %> 
<jsp:useBean id="urlaubViewBean" type="urlaubsbilder.beans.UrlaubViewBean" scope="session"></jsp:useBean> 

<% for (int j=0;j<urlaubViewBean.getFieldDirContent().getAllPicturePaths().length;j++)
   { %>
    <A HREF="ContentServlet?actualPicture=<%= urlaubViewBean.getFieldDirContent().getAllPicturePaths(j) %>" TARGET = "content" ID ="smallink" > 
    <%= urlaubViewBean.getFieldDirContent().getPictureName(j) %> </A><BR>
   <%} %>






<%-- 

<tsx:repeat index="j">
<%--    <%= urlaubViewBean.getFieldDirContent().getAllFilesHREF(j) %> --%>
<%-- <A HREF="/urlaubsbilder/servlet/urlaubsbilder.standardservlets.ContentServlet?actualPicture=<%= urlaubViewBean.getFieldDirContent().getAllPicturePaths(j) %>" TARGET = "content" ID ="smallink" > --%>
<%--<A HREF="/urlaubsbilder/servlet/ContentServlet?actualPicture=<%= urlaubViewBean.getFieldDirContent().getAllPicturePaths(j) %>" TARGET = "content" ID ="smallink" > 
<%= urlaubViewBean.getFieldDirContent().getPictureName(j) %> </A><BR> 
</tsx:repeat> --%>
<%-- <%= urlaubViewBean.getFieldDirContent().getBilderRoot %> --%>



<%--
<tsx:repeat index="j">
        <%= urlaubViewBean.getFieldDirContent().getAllFilesServletLinks(j) %> 
    <BR>
</tsx:repeat>
-->

<%--  <jsp:getProperty name="dirContent" property="allFilesHREF" /> --%>
<%--
<%
int elements = dirContent.getAllFilesHREF().size();
%>
<tsx:repeat index="j" start="0" end="elements">
<jsp:getProperty name="dirContent" property="getHREF.(j)" />
</tsx:repeat>
--%>


</BODY>
</HTML>
