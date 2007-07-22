package urlaubsbilder.beans;

import java.util.*;
/**
 * Insert the type's description here.
 * Creation date: (16.11.2000 16:12:47)
 * @author: Stefan Zink
 */
public class DirContent {
	private java.lang.String DirName = new java.lang.String();
	private java.lang.String PathName = new java.lang.String();
	protected java.io.File PathFileObject;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	protected java.util.Map PictureHashMap;
	private java.lang.String[] fieldAllPicturePaths = null;
	protected java.lang.String BilderRoot;
/**
 * DirContent constructor comment.
 */
public DirContent() {
	super();
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(propertyName, listener);
}
public boolean execute(String bRoot, String bildPath) 
{
	// im Servlet performTask werden die Parameter aus der 
	// Eingangs webseite gesetzt
  	// in dem Fall ist Pathname gesetzt
	//int ArraySize;
	BilderRoot = bRoot; 	
	PathName = bRoot + bildPath;
	String temp = new String();	
	
	PathFileObject = new java.io.File(PathName);
	try
	{
		temp = PathFileObject.getPath();
		temp = PathFileObject.getName();
		temp = PathFileObject.getCanonicalPath();
	    temp = PathFileObject.getAbsolutePath();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}	 
	
	// PathFileObject.listFiles().length;
  	// fieldAllFilesHREF = new java.lang.String[ArraySize];
  	PictureHashMap = new TreeMap();
  	initAllFiles(); 
  	fieldAllPicturePaths = new String[PictureHashMap.size()];
  	
  	for (int i=0;i<PictureHashMap.size();i++)
  	{
	  fieldAllPicturePaths[i]= (String) PictureHashMap.values().toArray()[i];  	
  	}
	  	
	//fieldAllPicturePaths = (String[]) PictureHashMap.values().toArray(); 	
  	return false;
}/**
 * Insert the method's description here.
 * Creation date: (21.11.2000 11:03:41)
 * @return java.lang.String[]
 */                               
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.beans.PropertyChangeEvent evt) {
	getPropertyChange().firePropertyChange(evt);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.lang.String propertyName, int oldValue, int newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.lang.String propertyName, java.lang.Object oldValue, java.lang.Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.lang.String propertyName, boolean oldValue, boolean newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
public String[] getAllFilesInDir() {
	return PathFileObject.list();
}/**
 * Insert the method's description here.
 * Creation date: (21.11.2000 10:43:22)
 * @return java.io.File
 */   
/**
 * Gets the allPicturePaths property (java.lang.String[]) value.
 * @return The allPicturePaths property value.
 * @see #setAllPicturePaths
 */
public java.lang.String[] getAllPicturePaths() {
	return fieldAllPicturePaths;
}
/**
 * Gets the allPicturePaths index property (java.lang.String) value.
 * @return The allPicturePaths property value.
 * @param index The index value into the property array.
 * @see #setAllPicturePaths
 */
public java.lang.String getAllPicturePaths(int index) {
	return getAllPicturePaths()[index];
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 07:28:01)
 * @return java.lang.String
 */
public java.lang.String getBilderRoot() {
	return BilderRoot;
}
public java.io.File getPathFileObject() {
	return PathFileObject;
}/**
 * Insert the method's description here.
 * Creation date: (21.11.2000 10:43:22)
 * @param newPathFileObject java.io.File
 */   
/**
 * Insert the method's description here.
 * Creation date: (16.11.2000 16:16:20)
 * @return java.lang.String
 */
public java.lang.String getPathName() {
	return PathFileObject.getAbsolutePath();
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2000 14:07:40)
 * @return java.util.HashMap
 */
public java.util.Map getPictureHashMap() {
	return PictureHashMap;
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 08:33:16)
 * @return java.lang.String
 * @param i int
 */
public String getPictureName(int i) {
	String retval = ActualPicture.getPictureNameFromFilename(getAllPicturePaths(i));
	return retval;
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2000 16:12:21)
 * @return java.lang.String
 * @param idx int
 */
public String getPicturePath(int idx) 
{
	String[] temp = (String[]) PictureHashMap.values().toArray();
	if (temp[idx].length() > 0)
	{
	  return temp[idx];
	}
	else
	{
	  return null;
	}
}
/**
 * Accessor for the propertyChange field.
 */
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}
/**
 * The hasListeners method was generated to support the propertyChange field.
 */
public synchronized boolean hasListeners(java.lang.String propertyName) {
	return getPropertyChange().hasListeners(propertyName);
}
/**
 * Sets the allFilesHREF property (java.util.ArrayList) value.
 * @param allFilesHREF The new value for the property.
 * @see #getAllFilesHREF
 */
public void initAllFiles() {
	int counter = 0;
	for (int i =0;i<PathFileObject.listFiles().length;i++)
	{
	  String picturename = new String();
	  String pictureidentifier = new String();
	  String pictureRelativePath = new String();
	  String pictureAbsolutePath = PathFileObject.listFiles()[i].getPath();
	  String pictureFilename     = PathFileObject.listFiles()[i].getName();
	
	  //String pictureServletLink = new String();
	
	  
	  if ( ActualPicture.isValidPictureFile(pictureFilename) )
	  {
	    int underscoreidx = pictureFilename.lastIndexOf("_");
	    int dotidx	      = pictureFilename.lastIndexOf(".");
	    int bilderrootidx = pictureAbsolutePath.indexOf(BilderRoot);
	  
	    picturename	= pictureFilename.substring(underscoreidx+1,dotidx);
		pictureidentifier = pictureFilename.substring(0 ,underscoreidx);
	    pictureRelativePath = pictureAbsolutePath.substring(bilderrootidx+BilderRoot.length());
	    PictureHashMap.put(pictureidentifier, pictureRelativePath);
	    //pictureServletLink = new String("<A HREF=\"servlet/urlaubsbilder.ContentServlet?actualPicture=" +
	   	//		PathFileObject.listFiles()[i].getPath() + "\" TARGET = \"content\" ID =\"smallink\">" + picturename +  "</A>" );
	    //PictureHashMap.put(pictureidentifier, pictureServletLink);
	    counter++;
	  }
	  else
	  {
	     //this is not a valid picturelink
	     //picturename	= PathFileObject.listFiles()[i].getName();
	  }    
	  
	}
/*	
	Iterator e = PictureHashMap.values().iterator();
	while(e.hasNext())
	{
	   System.out.println( (String)e.next());
	}
	System.out.println("initAllFilesHREF() passed with " + counter +" elements \n" );
*/	 
	//firePropertyChange("allFilesHREF", oldValue, allFilesHREF);
	
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void removePropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(propertyName, listener);
}
/**
 * Sets the allPicturePaths property (java.lang.String[]) value.
 * @param allPicturePaths The new value for the property.
 * @see #getAllPicturePaths
 */
public void setAllPicturePaths(java.lang.String[] allPicturePaths) {
	java.lang.String[] oldValue = fieldAllPicturePaths;
	fieldAllPicturePaths = allPicturePaths;
	firePropertyChange("allPicturePaths", oldValue, allPicturePaths);
}
/**
 * Sets the allPicturePaths index property (java.lang.String[]) value.
 * @param index The index value into the property array.
 * @param allPicturePaths The new value for the property.
 * @see #getAllPicturePaths
 */
public void setAllPicturePaths(int index, java.lang.String allPicturePaths) {
	String oldValue = fieldAllPicturePaths[index];
	fieldAllPicturePaths[index] = allPicturePaths;
	if (oldValue != null && !oldValue.equals(allPicturePaths)) {
		firePropertyChange("allPicturePaths", null, fieldAllPicturePaths);
	};
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 07:28:01)
 * @param newBilderRoot java.lang.String
 */
public void setBilderRoot(java.lang.String newBilderRoot) {
	BilderRoot = newBilderRoot;
}
public void setPathFileObject(java.io.File newPathFileObject) {
	PathFileObject = newPathFileObject;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2000 16:16:20)
 * @param newPathName java.lang.String
 */
public void setPathName(java.lang.String newPathName) {
	PathName = newPathName;
}
}
