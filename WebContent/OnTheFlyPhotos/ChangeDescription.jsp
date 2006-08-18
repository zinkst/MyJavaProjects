<!-- Sample JSP file -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>
Put Your Title Here
</TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<jsp:useBean id="urlaubViewBean" type="org.zifts.homepagegenerator.util.UrlaubViewBean" scope="session"></jsp:useBean>
<!-- <FORM method="POST" action="/urlaubsbilder/servlet/urlaubsbilder.standardservlets.ChangeDescriptionServlet" target="_self"> : -->
<FORM method="POST" action="ChangeDescriptionServlet" target="_self"> : 
<TEXTAREA rows="6" cols="50" name="newDescription"><%= urlaubViewBean.getActualPicture().getEnglishPictureDescription() %></TEXTAREA> <BR>
<INPUT type="submit" name="Change English" value="Change English"> <INPUT type="hidden" name="language" value="1">
</FORM>
</BODY>
</HTML>
