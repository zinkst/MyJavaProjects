package urlaubsbilder.beans;

import javax.servlet.*;
import javax.servlet.http.*;

//import com.ibm.logging.*;
//import com.ibm.logging.mgr.*;



/**
 * Insert the type's description here.
 * Creation date: (20.12.2000 12:01:12)
 * @author: Stefan Zink
 */
public class UrlaubViewBean {
	private DirContent fieldDirContent;
	protected ActualPicture actualPicture;
//	protected static com.ibm.logging.TraceLogger trcLogger;
//	protected static com.ibm.logging.mgr.LogManager logManager;
//	private static final java.lang.String propFileName = "LogManager.properties";
/**
 * UrlaubViewBean constructor comment.
 */
public UrlaubViewBean() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2000 10:22:04)
 */
public void execute(HttpServletRequest request) 
{
  // this method is used to initialize all data beans which
  // are needed for the corresponding JSP
  
  // instantiate the beans and store them so they can be accessed by the called page
  HttpSession session = request.getSession(true);
  
  fieldDirContent = (DirContent) session.getAttribute("dirContent");      
  actualPicture = (ActualPicture) session.getAttribute("actualPicture");      

}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:51:21)
 * @return urlaubsbilder.ActualPicture
 */
public ActualPicture getActualPicture() {
	return actualPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2000 14:37:47)
 * @return urlaubsbilder.DirContent
 */
public DirContent getFieldDirContent() {
	return fieldDirContent;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:51:21)
 * @param newActualPicture urlaubsbilder.ActualPicture
 */
public void setActualPicture(ActualPicture newActualPicture) {
	actualPicture = newActualPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2000 14:37:47)
 * @param newFieldDirContent urlaubsbilder.DirContent
 */
public void setFieldDirContent(DirContent newFieldDirContent) {
	fieldDirContent = newFieldDirContent;
}
}
