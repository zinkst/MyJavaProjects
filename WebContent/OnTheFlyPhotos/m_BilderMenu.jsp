
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

  <HTML>
  <HEAD>
 <META HTTP-EQUIV="Content-Type" content="text/html; charset=ISO-8859-1">
<META http-equiv="Content-Style-Type" content="text/css">
  
  <LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
  
  <TITLE></TITLE>
</HEAD>
<BODY bgcolor="#99bb33" text="#000000" link="#0000ff" vlink="#cc00cc" alink="#ff6699" background="../images/g_bcg006.gif">
<jsp:useBean id="urlaubViewBean" type="org.zifts.homepagegenerator.util.UrlaubViewBean" scope="session"></jsp:useBean> 

<% for (int j=0;j<urlaubViewBean.getFieldDirContent().getAllPicturePaths().length;j++)
   { %>
    <A HREF="ContentServlet?actualPicture=<%= urlaubViewBean.getFieldDirContent().getAllPicturePaths(j) %>" TARGET = "content" ID ="smallink" > 
    <%= urlaubViewBean.getFieldDirContent().getPictureName(j) %> </A><BR>
   <%} %>

</BODY>
</HTML>
