package org.zifts.homepagegenerator.servlet;

/**
* This file was generated by IBM WebSphere Studio Version 3.5
* i:\wsstudio\BIN\GenerationStyleSheets\V3.5\JSP1.0\ServletModel\JavaServlet.xsl stylesheet was used to generate this file.
*
* 
*
*/ 
// Imports
//import com.ibm.servlet.*;
//import com.ibm.webtools.runtime.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.zifts.homepagegenerator.util.ActualPicture;
import org.zifts.homepagegenerator.util.DirContent;
import org.zifts.homepagegenerator.util.UrlaubViewBean;


// Imports for beans used by this servlet



public class ChangeDescriptionServlet extends HttpServlet implements Serializable
{

  /*****************************************************************************
  * Process incoming requests for information
  * 
  * @param request Object that encapsulates the request to the servlet
  * @param response Object that encapsulates the response from the servlet
  * this servlet sets the current picture in the content frame
  * to the recieved Parameter actualPicture ...
  */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
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
  public void doPost(HttpServletRequest request, HttpServletResponse response)
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
  public void performTask(HttpServletRequest request, HttpServletResponse response)
  {

  
	try 
	{

	  HttpSession session = request.getSession(true);
  	  String picturename = new String();
  	  
	  UrlaubViewBean urlaubViewBean = (UrlaubViewBean) session.getAttribute("urlaubViewBean");
	  DirContent dirContent = urlaubViewBean.getFieldDirContent();
	  
	  String newDescription = request.getParameter("newDescription");
	  int language  = new Integer(request.getParameter("language")).intValue();
	   
	  ActualPicture actualPicture = urlaubViewBean.getActualPicture();
	  //actualPicture.execute(bilderRoot,picturename);
	  actualPicture.storeDescriptionInFile(newDescription,language);
	  actualPicture.computeGermanDescription();
	  actualPicture.computeEnglishDescription();
	  
	  // session.putValue("actualPicture", actualPicture);
	  //urlaubViewBean.execute(request); 

	  response.sendRedirect(getServletConfig().getInitParameter("ResultPage"));
	  //callPage(getPageNameFromRequest(request), request, response);
	}

	catch (Throwable theException)
	{
	  // uncomment the following line when unexpected exceptions are occuring to aid in debugging the problem
	  theException.printStackTrace();

	 //handleError(request, response, theException);
	}
	
  }                                                                              
}
