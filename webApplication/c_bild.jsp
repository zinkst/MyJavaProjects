<!-- Sample JSP file -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5.3 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>
Bilder Content
</TITLE>
<SCRIPT LANGUAGE="JavaScript1.2">
<!--BEGIN HIDING
var ChosenLanguage;

function enterText() 
{
   //window.alert("test1");
   //window.prompt("Enter new Description",inputParm);
   //document.ChangeEnglish.newDescription.value=input; 
   //document.ChangeEnglish.submit();
   //return false;
   //enTxtWin=open("", "myWin", "resizable=yes,status=yes,location=yes,menubar=yes,innerwidth=800,innerheight=200");
   chgDescWin=open("", "myWin", "status=yes,resizable=yes,innerwidth=500,innerheight=600");
   chgDescWin.document.writeln('<HTML><HEAD>');
   chgDescWin.document.writeln('<TITLE>');
   chgDescWin.document.writeln('Enter New Description');
   chgDescWin.document.writeln('<\/TITLE>');
   chgDescWin.document.writeln('<SCRIPT LANGUAGE="JavaScript1.2">');
   chgDescWin.document.writeln('<!--BEGIN HIDING ');
   chgDescWin.document.writeln('function finished() ');
   chgDescWin.document.writeln('{');
   switch (ChosenLanguage) 
   {
     case 1:
     {
       chgDescWin.document.writeln('  window.opener.document.ChangeEnglish.newDescription.value = document.InputtextForm.newDescription.value;');
       chgDescWin.document.writeln('  window.opener.document.ChangeEnglish.submit();');
       chgDescWin.document.writeln('  window.close();');
       break;
     } 
     case 2:
     { 
       chgDescWin.document.writeln('  window.opener.document.ChangeGerman.newDescription.value = document.InputtextForm.newDescription.value;');
       chgDescWin.document.writeln('  window.opener.document.ChangeGerman.submit();');
       chgDescWin.document.writeln('  window.close();');
       break;
     }
   }
   chgDescWin.document.writeln('}');
   chgDescWin.document.writeln('//END HIDING-->');
   chgDescWin.document.writeln('<\/SCRIPT>');
   chgDescWin.document.writeln('<\/HEAD>');
   chgDescWin.document.writeln('<BODY>');
   chgDescWin.document.writeln('<FORM NAME="InputtextForm">');
   chgDescWin.document.writeln('<TEXTAREA rows="6" cols="50" name="newDescription">');
   switch (ChosenLanguage)
   {
     case 1:
     {
       chgDescWin.document.writeln(  document.ChangeEnglish.initDescription.value);
       break;
     }
     case 2:
     {
       chgDescWin.document.writeln(  document.ChangeGerman.initDescription.value);
       break;
     }
   }
   chgDescWin.document.writeln('<\/TEXTAREA> <BR>');
   chgDescWin.document.writeln('<INPUT type="button" name="inputComplete" value="Change" onClick="finished()">');
   chgDescWin.document.writeln('<INPUT type="button" name="cancelinput" value="Cancel" onClick="window.close()">');
   chgDescWin.document.writeln('<\/FORM>');
   chgDescWin.document.writeln('<\/BODY><\/HTML>');
   chgDescWin.document.close();
}


//END HIDING-->
</SCRIPT>

</HEAD>
<BODY bgcolor="#99bb33" text="#000000" link="#0000ff" vlink="#ff00ff" alink="#ff6699" background="images/g_bcg006.gif">
<%@ page import="urlaubsbilder.beans.*" %> 
<jsp:useBean id="urlaubViewBean" type="urlaubsbilder.beans.UrlaubViewBean" scope="session"></jsp:useBean> 
ID: <%= urlaubViewBean.getActualPicture().getPictureIdentifier()%>
<% if (urlaubViewBean.getActualPicture().hasPreviousPicture() )
   { %>
<!--     <A href="servlet/urlaubsbilder.standardservlets.ContentServlet?actualPicture=<%=urlaubViewBean.getActualPicture().getPathOfPreviousPicture()%>" target="content"> Voriges Bild  </A> -->
     <A href="ContentServlet?actualPicture=<%=urlaubViewBean.getActualPicture().getPathOfPreviousPicture()%>" target="content"> Voriges Bild  </A>
 <%}%>   
<% if (urlaubViewBean.getActualPicture().hasSubsequentPicture() )
   { %>
<!--      <A href="servlet/urlaubsbilder.standardservlets.ContentServlet?actualPicture=<%=urlaubViewBean.getActualPicture().getPathOfNextPicture()%>" target="content">Nächstes Bild</A> -->
     <A href="ContentServlet?actualPicture=<%=urlaubViewBean.getActualPicture().getPathOfNextPicture()%>" target="content">Nächstes Bild</A>
 <%}%>
<BR>

<!-- <FORM name="ChangeEnglish" method="POST" action="servlet/urlaubsbilder.standardservlets.ChangeDescriptionServlet" target="_self" > -->
<FORM name="ChangeEnglish" method="POST" action="ChangeDescriptionServlet" target="_self" >
<INPUT type="hidden" name="language" value="1">
<INPUT type="hidden" name="newDescription" >
<INPUT type="hidden" name="initDescription" value="<%= urlaubViewBean.getActualPicture().getEnglishPictureDescription() %>" >
<INPUT type="button" value="Change" onClick="ChosenLanguage=1;enterText();">
<IMG src="images/flaguk.gif" width="30" height="15" border="0" > : 
 <%= urlaubViewBean.getActualPicture().getEnglishPictureDescription() %>
</FORM>

<!-- <FORM name="ChangeGerman" method="POST" action="servlet/urlaubsbilder.standardservlets.ChangeDescriptionServlet" target="_self" > -->
<FORM name="ChangeGerman" method="POST" action="ChangeDescriptionServlet" target="_self" >
<INPUT type="hidden" name="language" value="2">
<INPUT type="hidden" name="newDescription" >
<INPUT type="hidden" name="initDescription" value="<%= urlaubViewBean.getActualPicture().getGermanPictureDescription() %>" >
<INPUT type="button" value="Change" onClick="ChosenLanguage=2;enterText();">
<IMG src="images/flagde.gif" width="30" height="15" border="0" > : 
 <%= urlaubViewBean.getActualPicture().getGermanPictureDescription() %>
</FORM>


<IMG src="/bilderroot<%= urlaubViewBean.getActualPicture().getPictureRelativePath()%>" border="0">



<%-- <IMG src="file:///<%= urlaubViewBean.getActualPicture().getFileObject().getPath()%>" border="0"> --%>

<%--
<tsx:repeat index="j">
    <%= urlaubViewBean.getFieldDirContent().getAllFilesHREF(j) %> 
        <%= urlaubViewBean.getFieldActualPicture().getAllFilesServletLinks(j) %> 
    <BR>
</tsx:repeat>
--%>

<%--  <jsp:getProperty name="dirContent" property="allFilesHREF" /> --%>
<%--
<%
int elements = dirContent.getAllFilesHREF().size();
%>
<tsx:repeat index="j" start="0" end="elements">
</tsx:repeat>
--%>


</BODY>
</HTML>
