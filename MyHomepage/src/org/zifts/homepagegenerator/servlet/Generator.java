package org.zifts.homepagegenerator.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.zifts.homepagegenerator.util.DirContent;


public class Generator extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  private static final long serialVersionUID = -1034988809623631448L;
  
  /* (non-Java-doc)
   * @see javax.servlet.http.HttpServlet#HttpServlet()
   */
  public Generator() {
       super();
   }       
  protected String urlaubId = new String();
  protected String targetPath = new String();
  protected String inputRoot = new String();
  protected String urlaubPrefix = new String();
  protected DirContent dirContent = new DirContent();
  protected HttpServletRequest request = null;
  protected HttpServletResponse response = null;

  private java.io.BufferedWriter MenuWriter;
  protected java.io.PrintWriter htmlOut;
  boolean withHiresLink = false;
  /*****************************************************************************
  * Process incoming requests for information
  * 
  * @param request Object that encapsulates the request to the servlet
  * @param response Object that encapsulates the response from the servlet
  * this servlet sets the current picture in the content frame
  * to the recieved Parameter actualPicture ...
  */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {

    performTask(request, response);

  }
  /*****************************************************************************
  * Process incoming requests for information
  * 
  * @param request Object that encapsulates the request to the servlet
  * @param response Object that encapsulates the response from the servlet
  * this servlet sets the current picture in the content frame
  * to the recieved Parameter actualPicture ...
  */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {

    performTask(request, response);

  }
  
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }   
  /**
   * Insert the method's description here.
   * Creation date: (31.01.2001 15:42:07)
   * @param PictureName java.lang.String
   * @param indexInDir int
   */
  public void generateFile(String PictureName, int indexInDir)
  {
    // copy picture to targetPath

    /*
    String cmd =
    "copy "
    	+ inputRoot
    	+ urlaubId
    	+ File.separator
    	+ "800x600"
    	+ File.separator
    	+ PictureName
    	+ " "
    	+ targetPath
    	+ File.separator
    	+ "UrlaubsPhotos"
    	+ File.separator
    	+ urlaubId
    	+ File.separator
    	+ "800x600";
    
    try
    {
    //Process proc = Runtime.getRuntime().exec(cmd);
    }
    catch (Exception e)
    {
    System.out.println(cmd + "could not run");
    //e.printStackTrace();
    }
    */
    // compute Necessary Data
    int underscoreidx = PictureName.lastIndexOf("_");
    int dotidx = PictureName.lastIndexOf(".");
    String pictureIdentifier = PictureName.substring(0, underscoreidx);
    String pictureNameWithoutExtension = PictureName.substring(0, dotidx);
    String purePictureName = PictureName.substring(underscoreidx + 1, dotidx);
    String precessorName = new String();
    String successorName = new String();
    int sepidx = 0;

    String outputFileName =
      targetPath
        + File.separator
        + urlaubPrefix+"Pages"
        + File.separator
        + urlaubId
        + File.separator
        + "pages"
        + File.separator
        + pictureNameWithoutExtension
        + ".html";
    if (indexInDir >= 1)
    {
      sepidx = dirContent.getAllPicturePaths(indexInDir - 1).lastIndexOf(File.separator);
      dotidx = dirContent.getAllPicturePaths(indexInDir - 1).lastIndexOf(".");
      precessorName = dirContent.getAllPicturePaths(indexInDir - 1).substring(sepidx + 1, dotidx) + ".html";
    }
    if (indexInDir < dirContent.getAllPicturePaths().length - 1)
    {
      sepidx = dirContent.getAllPicturePaths(indexInDir + 1).lastIndexOf(File.separator);
      dotidx = dirContent.getAllPicturePaths(indexInDir + 1).lastIndexOf(".");
      successorName = dirContent.getAllPicturePaths(indexInDir + 1).substring(sepidx + 1, dotidx) + ".html";
    }

    //write Output into file
    try
    {
      File outputFile = new File(outputFileName);
      outputFile.getParentFile().mkdirs();
      outputFile.createNewFile();
      FileWriter fwriter = new FileWriter(outputFile);
      BufferedWriter out = new BufferedWriter(fwriter);
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
      out.newLine();
      out.write("<HTML>");
      out.newLine();
      out.write("<HEAD>");
      out.newLine();
      out.write("<META http-equiv=\"Content-Style-Type\" content=\"text/css\">");
      out.newLine();
      out.write("<TITLE>");
      out.newLine();
      out.write(purePictureName);
      out.newLine();
      out.write("</TITLE>");
      out.newLine();
      out.write("</HEAD>");
      out.newLine();
      out.write(
        "<BODY bgcolor=\"#3333FF\" text=\"#333333\" link=\"#006633\" vlink=\"#0000FF\" alink=\"#ff6699\" background=\"../../../../images/g_bcg006.gif\" >");
      out.newLine();
      out.write("ID: " + pictureIdentifier);
      out.newLine();
      if (precessorName.length() > 0)
      {
        out.write(
          "<A href=\""
            + precessorName
            + "\" target=\"content\"><IMG id=\"homepic\" src=\"../../../../images/arrow_back_filled.gif\" border=\"0\" width=\"44\" height=\"18\"></A>");
        out.newLine();
      }
      if (successorName.length() > 0)
      {
        out.write(
          "<A href=\""
            + successorName
            + "\" target=\"content\"><IMG id=\"homepic\" src=\"../../../../images/arrow_next_filled.gif\" border=\"0\" width=\"44\" height=\"18\"></A>");
        out.newLine();
      }
      if (withHiresLink)
      {
        out.write(
          "<A href=\"../../../"+urlaubPrefix+"PhotosHires/"
            + urlaubId
            + "/hires/"
            + PictureName
            + "\" ><IMG id=\"homepic\" src=\"../../../../images/b_ico005.gif\"> Right click on disk icon and select save link as to download Hires Picture </A>");
      }
      out.write("<BR>");
      out.newLine();
      out.write(purePictureName);
      out.newLine();
      out.write("<BR> ");
      out.newLine();
      out.write(
        "<IMG src=\"../../../../"+urlaubPrefix+"Photos/"
          + urlaubId
          + "/"
          + request.getParameter("pictureResolution")
          + "/"
          + PictureName
          + "\" >");
      out.newLine();
      out.write("</BODY>");
      out.newLine();
      out.write("</HTML>");
      out.flush();
      out.close();
    }
    catch (IOException e)
    {
      System.out.println("IOException " + e.toString());
    }
  }
  /**
   * Insert the method's description here.
   * Creation date: (31.01.2001 20:50:30)
   */
  protected void initMenuWriter()
  {
    String outputFileName =
      targetPath + File.separator + urlaubPrefix+"Pages" + File.separator + urlaubId + File.separator + "c_menu.html";

    try
    {
      File outputFile = new File(outputFileName);
      outputFile.getParentFile().mkdirs();
      outputFile.createNewFile();
      FileWriter fwriter = new FileWriter(outputFile);
      MenuWriter = new BufferedWriter(fwriter);
      MenuWriter.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
      MenuWriter.newLine();
      MenuWriter.write("<HTML>");
      MenuWriter.newLine();
      MenuWriter.write("<HEAD>");
      MenuWriter.newLine();
      MenuWriter.write("<META http-equiv=\"Content-Style-Type\" content=\"text/css\">");
      MenuWriter.newLine();
      MenuWriter.write("<LINK href=\"../../../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">");
      MenuWriter.newLine();
      MenuWriter.write("<TITLE>");
      MenuWriter.newLine();
      MenuWriter.write(urlaubId + " Menu");
      MenuWriter.newLine();
      MenuWriter.write("</TITLE>");
      MenuWriter.newLine();
      MenuWriter.write("</HEAD>");
      MenuWriter.newLine();
      MenuWriter.write(
        "<BODY bgcolor=\"#3333FF\" text=\"#333333\" link=\"#006633\" vlink=\"#0000FF\" alink=\"#ff6699\" background=\"../../../images/g_bcg006.gif\" >");
      MenuWriter.newLine();
      MenuWriter.flush();
    }
    catch (IOException e)
    {
      System.out.println("IOException " + e.toString());
    }
  }
  /**
   * Insert the method's description here.
   * Creation date: (31.01.2001 20:50:30)
   */
  protected void initTitlePageWriter()
  {
    String outputFileName =
      targetPath + File.separator + urlaubPrefix+"Pages" + File.separator + urlaubId + File.separator + "c_title.html";

    try
    {
      File outputFile = new File(outputFileName);
      outputFile.getParentFile().mkdirs();
      outputFile.createNewFile();
      FileWriter fwriter = new FileWriter(outputFile);
      BufferedWriter TitlePageWriter = new BufferedWriter(fwriter);
      TitlePageWriter.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
      TitlePageWriter.newLine();
      TitlePageWriter.write("<HTML>");
      TitlePageWriter.newLine();
      TitlePageWriter.write("<HEAD>");
      TitlePageWriter.newLine();
      TitlePageWriter.write("<META http-equiv=\"Content-Style-Type\" content=\"text/css\">");
      TitlePageWriter.newLine();
      TitlePageWriter.write("<LINK href=\"../../../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">");
      TitlePageWriter.newLine();
      TitlePageWriter.write("<TITLE>");
      TitlePageWriter.newLine();
      TitlePageWriter.write(urlaubId + " Title");
      TitlePageWriter.newLine();
      TitlePageWriter.write("</TITLE>");
      TitlePageWriter.write("<script language=\"JavaScript\">");
      TitlePageWriter.newLine();
      TitlePageWriter.write("<!--");
      TitlePageWriter.newLine();
      TitlePageWriter.write("function MM_reloadPage(init) {  //reloads the window if Nav4 resized");
      TitlePageWriter.newLine();
      TitlePageWriter.write("  if (init==true) with (navigator) {if ((appName==\"Netscape\")&&(parseInt(appVersion)==4)) {");
      TitlePageWriter.newLine();
      TitlePageWriter.write("    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }} ");
      TitlePageWriter.newLine();
      TitlePageWriter.write("  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload(); ");
      TitlePageWriter.newLine();
      TitlePageWriter.write("}");
      TitlePageWriter.newLine();
      TitlePageWriter.write("MM_reloadPage(true);");
      TitlePageWriter.newLine();
      TitlePageWriter.write("// -->");
      TitlePageWriter.newLine();
      TitlePageWriter.write("</SCRIPT>");
      TitlePageWriter.newLine();
      TitlePageWriter.write("</HEAD>");
      TitlePageWriter.newLine();
      TitlePageWriter.write(
        "<BODY bgcolor=\"#3333FF\" text=\"#333333\" link=\"#006633\" vlink=\"#0000FF\" alink=\"#ff6699\" background=\"../../../images/g_bcg006.gif\" >");
      TitlePageWriter.newLine();
      TitlePageWriter.write(
        "<A href=\"../../../index.html\" target=\"_top\"><IMG id=\"homepic\" src=\"../../../images/cursive_home.gif\" border=\"0\"></A>");
      TitlePageWriter.newLine();
      TitlePageWriter.write(
        "<div id=\"Titlename\" style=\"position:absolute; width:768px; height:40px; z-index:1; left: 141px; top: 3px\">");
      TitlePageWriter.newLine();
      TitlePageWriter.write("  <div align=\"center\"><FONT size=\"+2\">" + urlaubId + "</FONT> </div>");
      TitlePageWriter.newLine();
      TitlePageWriter.write("</div>");
      TitlePageWriter.newLine();
      TitlePageWriter.write("</BODY>");
      TitlePageWriter.newLine();
      TitlePageWriter.write("</HTML>");
      TitlePageWriter.flush();
      TitlePageWriter.close();

    }
    catch (IOException e)
    {
      System.out.println("IOException " + e.toString());
    }
  }
  /*****************************************************************************
  * Process incoming requests for information
  * 
  * @param request Object that encapsulates the request to the servlet
  * @param response Object that encapsulates the response from the servlet
  */
  public void performTask(HttpServletRequest req, HttpServletResponse res)
  {

    try
    {
      this.request = req;
      this.response = res;
      HttpSession session = request.getSession(true);
      session.invalidate();
      session = request.getSession(true);

      htmlOut = response.getWriter();
      response.setContentType("text/html");
      htmlOut.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//en\">");
      htmlOut.println("<HTML>");
      htmlOut.println("<HEAD>");
      htmlOut.println("<TITLE>Generate Static Homepage</TITLE>");
      htmlOut.println("</HEAD>");
      htmlOut.println("<BODY bgcolor=\"#99bb33\" text=\"#ffffff\" link=\"#ffff80\" vlink=\"#99ffff\" alink=\"#ff6699\" >");

      inputRoot = request.getParameter("inputRoot");
      targetPath = request.getParameter("targetPath");
      urlaubPrefix = request.getParameter("urlaubPrefix");
      String urlaubPrefixID = request.getParameter("urlaubPrefixID");
      String urlaubPrefixName = request.getParameter("urlaubPrefixName");

      if (request.getParameter("hires").equalsIgnoreCase("with"))
      {
        withHiresLink = true;
      }
      else
      {
        withHiresLink = false;
      }

      String mode = new String(request.getParameter("mode"));
      if (mode.equalsIgnoreCase("single"))
      {
        urlaubId = request.getParameter("urlaubId");
        processUrlaub();
      }
      else
      {
        urlaubId = "1988bund";
        processUrlaub();
        urlaubId = "1989bund";
        processUrlaub();
        urlaubId = "1989dolomiten";
        processUrlaub();
        urlaubId = "1991gardasee";
        processUrlaub();
        urlaubId = "1992dolomiten";
        processUrlaub();
        urlaubId = "1994clermontFerrand";
        processUrlaub();
        urlaubId = "1994piemont";
        processUrlaub();
        urlaubId = "1995norwegen";
        processUrlaub();
        urlaubId = "1995irland";
        processUrlaub();
        urlaubId = "1996neuseeland";
        processUrlaub();
        urlaubId = "1996pyrenaen";
        processUrlaub();
        urlaubId = "1997oetztalerRadmarathon";
        processUrlaub();
        urlaubId = "1997skitourWeiskugel";
        processUrlaub();
        urlaubId = "1997Lofoten";
        processUrlaub();
        urlaubId = "1998island";
        processUrlaub();
        urlaubId = "1999Girojuni";
        processUrlaub();
        urlaubId = "1999Schweiz";
        processUrlaub();
        urlaubId = "2000Wintour";
        processUrlaub();
        urlaubId = "2000Canada";
        processUrlaub();
        urlaubId = "2000USA";
        processUrlaub();
        urlaubId = "2001Wintour";
        processUrlaub();
        urlaubId = "2001VernagtHuette";
        processUrlaub();
        urlaubId = "2001Gardasee";
        processUrlaub();
        urlaubId = "2001Salzkammergut";
        processUrlaub();
      }
      htmlOut.println("</BODY></HTML>");
      htmlOut.close();
    }
    catch (Throwable theException)
    {
      // uncomment the following line when unexpected exceptions are occuring to aid in debugging the problem
      theException.printStackTrace();

      //handleError(request, response, theException);
    }

  }
  /**
   * Insert the method's description here.
   * Creation date: (12.02.2001 23:38:37)
   * @param request javax.servlet.http.HttpServletRequest
   * @param response javax.servlet.http.HttpServletResponse
   */
  public void processUrlaub()
  {
    try
    {

      HttpSession session = request.getSession(true);
      session.invalidate();
      session = request.getSession(true);

      dirContent.execute(new String(inputRoot+"\\"+urlaubPrefix+"Photos"+"\\") , new String(urlaubId + "\\" + request.getParameter("pictureResolution")));
      //session.putValue("dirContent", dirContent);

      String actualName = new String();
      int sepidx = 0;

      htmlOut.println("<H2>Processing Urlaub " + urlaubId + "</H2>");

      initTitlePageWriter();
      initMenuWriter();
      //initStartPageWriter();

      for (int i = 0; i < dirContent.getAllPicturePaths().length; i++)
      {
        sepidx = dirContent.getAllPicturePaths(i).lastIndexOf(File.separator);
        actualName = dirContent.getAllPicturePaths(i).substring(sepidx + 1);
        MenuWriter.write(
          "<A HREF=\"pages/"
            + actualName.substring(0, actualName.lastIndexOf("."))
            + ".html \" TARGET = \"content\" ID =\"smallink\" >"
            + actualName.substring(actualName.lastIndexOf("_") + 1, actualName.lastIndexOf("."))
            + "</A><BR>");
        MenuWriter.newLine();
        MenuWriter.flush();
        if (i == 0)
        {
          startPageGenerator("de", actualName);
          startPageGenerator("en", actualName);
        }
        generateFile(actualName, i);
        htmlOut.println("Processed Index " + i + " :" + actualName + "<BR>");
        htmlOut.flush();
      }
      MenuWriter.write("</BODY>");
      MenuWriter.newLine();
      MenuWriter.write("</HTML>");
      MenuWriter.flush();
      MenuWriter.close();
      htmlOut.flush();
      //callPage(getPageNameFromRequest(request), request, response);
      //  response.sendRedirect(getInitParameter("ResultPage"));

    }
    catch (Throwable theException)
    {
      // uncomment the following line when unexpected exceptions are occuring to aid in debugging the problem
      theException.printStackTrace();

      //handleError(request, response, theException);
    }

  }
  /**
   * Insert the method's description here.
   * Creation date: (31.01.2001 20:50:30)
   */
  protected void startPageGenerator(String language, String actualName)
  {
    String outputFileName =
      targetPath + File.separator + urlaubPrefix+"Pages" + File.separator + urlaubId + File.separator + "c_start_" + language + ".html";

    try
    {
      File outputFile = new File(outputFileName);
      if (outputFile.exists())
      {
        System.out.println(" File Exists " + outputFile.getPath());

      }
      else
      {
        outputFile.getParentFile().mkdirs();
        outputFile.createNewFile();
        FileWriter fwriter = new FileWriter(outputFile);
        BufferedWriter StartPageWriter = new BufferedWriter(fwriter);
        StartPageWriter.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        StartPageWriter.newLine();
        StartPageWriter.write("<HTML>");
        StartPageWriter.newLine();
        StartPageWriter.write("<HEAD>");
        StartPageWriter.newLine();
        StartPageWriter.write("<META http-equiv=\"Content-Style-Type\" content=\"text/css\">");
        StartPageWriter.newLine();
        StartPageWriter.write("<LINK href=\"../../../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">");
        StartPageWriter.newLine();
        StartPageWriter.write("<TITLE>");
        StartPageWriter.newLine();
        StartPageWriter.write(urlaubId + " Start Page");
        StartPageWriter.newLine();
        StartPageWriter.write("</TITLE>");
        StartPageWriter.newLine();
        StartPageWriter.write("</HEAD>");
        StartPageWriter.newLine();
        StartPageWriter.write(
          "<BODY bgcolor=\"#3333FF\" text=\"#333333\" link=\"#006633\" vlink=\"#0000FF\" alink=\"#ff6699\" background=\"../../../images/g_bcg006.gif\" >");
        StartPageWriter.newLine();
        StartPageWriter.write(
          "<A HREF=\"pages/"
            + actualName.substring(0, actualName.lastIndexOf("."))
            + ".html"
            + "\" TARGET = \"content\" >"
            + "<IMG id=\"homepic\" src=\"../../../images/arrow_next_filled.gif\" border=\"0\" width=\"44\" height=\"18\">");
        StartPageWriter.newLine();
        if (language == "de")
        {
          StartPageWriter.write("Gehe zu erstem Bild");
        }
        if (language == "en")
        {
          StartPageWriter.write("Go to first picture");
        }
        StartPageWriter.newLine();
        StartPageWriter.write("</A><BR>");
        StartPageWriter.newLine();
        StartPageWriter.write("<A href=\"f_start_");
        if (language == "de")
        {
          StartPageWriter.write(
            "en.html\" target=\"_top\"><IMG id=\"ukpic\" src=\"../../../images/flaguk.gif\" border=\"0\" width=\"44\" height=\"18\">English text</A><BR>");
        }
        if (language == "en")
        {
          StartPageWriter.write(
            "de.html\" target=\"_top\"><IMG id=\"depic\" src=\"../../../images/flagde.gif\" border=\"0\" width=\"44\" height=\"18\">German text</A><BR>");
        }
        StartPageWriter.newLine();
        StartPageWriter.write("<script language=\"JavaScript\" ");
        StartPageWriter.newLine();
        if (language == "de")
        {
          StartPageWriter.write("src=\"description_de.js\">");
        }
        if (language == "en")
        {
          StartPageWriter.write("src=\"description_en.js\">");
        }
        StartPageWriter.newLine();
        StartPageWriter.write("</script>");
        StartPageWriter.newLine();
        StartPageWriter.write("</BODY>");
        StartPageWriter.newLine();
        StartPageWriter.write("</HTML>");
        StartPageWriter.flush();
        StartPageWriter.close();
      }
    }
    catch (IOException e)
    {
      System.out.println("IOException " + e.toString());
    }
  }
}
