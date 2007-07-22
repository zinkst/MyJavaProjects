package urlaubsbilder.beans;

import java.io.*;
import java.util.*;

/**
 * Insert the type's description here.
 * Creation date: (21.12.2000 13:25:53)
 * @author: Stefan Zink
 */
public class ActualPicture {
	protected java.io.File fileObject;
	protected java.lang.String pictureDescription;
	protected java.lang.String englishPictureDescription;
	protected java.lang.String pictureIdentifier;
	protected java.lang.String germanPictureDescription;
	protected java.lang.String pictureNameWithoutExtension;
	protected java.lang.String pathOfNextPicture;
	protected java.lang.String pathOfPreviousPicture;
	protected boolean hasSubsequentPicture = false;
	protected boolean hasPreviousPicture = false;
	protected java.lang.String pictureRelativePath;
	protected DirContent actualDirContent = new DirContent();
	protected java.lang.String BilderRoot;
	public final static int ENGLISH = 1;
	public final static int GERMAN = 2;
/**
 * ActualPicture constructor comment.
 */
public ActualPicture() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 14:26:36)
 */
public void computeDescription() 
{
  int underscoreidx = fileObject.getName().lastIndexOf("_");
  int dotidx	    = fileObject.getName().lastIndexOf(".");
 
  // the description should be in a file named
  // <pictureIdentifier>_de.txt or <pictureIdentifier>_en.txt
  // located in the Directory structure
  // if that file doesn't exist the filename is used
  
  String englishDescriptionFileName = new String();
  String germanDescriptionFileName = new String();
  String actualName = new String();
  String actualPictureIdentifier = new String();
  germanPictureDescription = new String();
  englishPictureDescription = new String();
  String textPath = new String(actualDirContent.getPathFileObject().getPath()+"\\text");
	
  java.io.File textPathFile = new File(textPath);
  if (textPathFile.exists())
  {  

	// ------------------------------------------------------
	// find the text files belonging to this picture (if any)
	// ------------------------------------------------------
	for (int i=0;i<textPathFile.list().length;i++)
	{
	  actualName = textPathFile.list()[i];
	  int firstunderscoreidx = actualName.indexOf("_");
	  actualPictureIdentifier = actualName.substring(0,firstunderscoreidx);
	  if ( actualPictureIdentifier.equals(pictureIdentifier) )
	  {
	    if (actualName.equals(pictureNameWithoutExtension+"_de.txt") )
	    {
		  germanDescriptionFileName = textPathFile.listFiles()[i].getPath();
	    }
	    else if(actualName.equals(pictureNameWithoutExtension+"_en.txt") ) 
	    {
		  englishDescriptionFileName = textPathFile.listFiles()[i].getPath();
	    }
	  }
	}  
  }
	
  
  String s = new String();
  // ------------------------------------------------------
  // read the german decsription from file if found
  // ------------------------------------------------------
  if (germanDescriptionFileName.length() > 0 )
  {
	try
	{
	  FileReader freader= new FileReader(germanDescriptionFileName);
	  BufferedReader in = new BufferedReader(freader);
	  while ( (s = in.readLine())!= null )
	  {
	     germanPictureDescription = germanPictureDescription + s +"\n";
	  }
	  in.close();
	}
	catch (IOException e)
	{
	  System.out.println("IOException " + e.toString() );
	}  
  }
  else  
  {
  	germanPictureDescription	= fileObject.getName().substring(underscoreidx+1,dotidx);
  }  
  
  
  
  // ------------------------------------------------------
  // read the english decsription from file if found
  // ------------------------------------------------------
  if (englishDescriptionFileName.length() > 0) 
  {
	try 
	{
	  FileReader freader= new FileReader(englishDescriptionFileName);
	  BufferedReader in = new BufferedReader(freader);
	  while ( (s = in.readLine())!= null )
	  {
	    englishPictureDescription = englishPictureDescription + s +"\n";
	  }
	  in.close();
	}  
	catch (IOException e)
	{
	  System.out.println("IOException " + e.toString() );
	}  

  }
  else  
  {
  	englishPictureDescription	= fileObject.getName().substring(underscoreidx+1,dotidx);
  }  

  
  
 
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 14:26:36)
 */
public void computeEnglishDescription() 
{
  int underscoreidx = fileObject.getName().lastIndexOf("_");
  int dotidx	    = fileObject.getName().lastIndexOf(".");
 
  // the description should be in a file named
  // <pictureIdentifier>.txt 
  // located in the Directory structure
  // if that file doesn't exist the filename is used
  
  String englishDescriptionFileName = new String();
  String actualName = new String();
  String actualPictureIdentifier = new String();
  englishPictureDescription = new String();
  String textPath = new String(actualDirContent.getPathFileObject().getParentFile().getPath()+"\\text_en");
	
  java.io.File textPathFile = new File(textPath);
  if (textPathFile.exists())
  {  

	// ------------------------------------------------------
	// find the text files belonging to this picture (if any)
	// ------------------------------------------------------
  	for (int i=0;i<textPathFile.list().length;i++)
	  {
	    actualName = textPathFile.list()[i];
	    int firstunderscoreidx = actualName.indexOf("_");
	    actualPictureIdentifier = actualName.substring(0,firstunderscoreidx);
	    if ( actualPictureIdentifier.equals(pictureIdentifier) )
	    {
	      englishDescriptionFileName = textPathFile.listFiles()[i].getPath();
	    }
	  }  
  }
	
  
  String s = new String();
  // ------------------------------------------------------
  // read the english decsription from file if found
  // ------------------------------------------------------
  if (englishDescriptionFileName.length() > 0 )
  {
	  try
	  {
	    FileReader freader= new FileReader(englishDescriptionFileName);
	    BufferedReader in = new BufferedReader(freader);
	    while ( (s = in.readLine())!= null )
	    {
	      englishPictureDescription = englishPictureDescription + s +"\n";
	    }
	    in.close();
	  }
	  catch (IOException e)
	  {
	    System.out.println("IOException " + e.toString() );
	  }  
  }
  else  
  {
  	englishPictureDescription	= fileObject.getName().substring(underscoreidx+1,dotidx);
  }  
  
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 14:26:36)
 */
public void computeGermanDescription() 
{
  int underscoreidx = fileObject.getName().lastIndexOf("_");
  int dotidx	    = fileObject.getName().lastIndexOf(".");
 
  // the description should be in a file named
  // <pictureIdentifier>.txt 
  // located in the Directory structure
  // if that file doesn't exist the filename is used
  
  String germanDescriptionFileName = new String();
  String actualName = new String();
  String actualPictureIdentifier = new String();
  germanPictureDescription = new String();
  String textPath = new String(actualDirContent.getPathFileObject().getParentFile().getPath()+"\\text_de");
	
  java.io.File textPathFile = new File(textPath);
  if (textPathFile.exists())
  {  

	// ------------------------------------------------------
	// find the text files belonging to this picture (if any)
	// ------------------------------------------------------
  	for (int i=0;i<textPathFile.list().length;i++)
	  {
	    actualName = textPathFile.list()[i];
	    int firstunderscoreidx = actualName.indexOf("_");
	    actualPictureIdentifier = actualName.substring(0,firstunderscoreidx);
	    if ( actualPictureIdentifier.equals(pictureIdentifier) )
	    {
	      germanDescriptionFileName = textPathFile.listFiles()[i].getPath();
	    }
	  }  
  }
	
  
  String s = new String();
  // ------------------------------------------------------
  // read the german decsription from file if found
  // ------------------------------------------------------
  if (germanDescriptionFileName.length() > 0 )
  {
	  try
	  {
	    FileReader freader= new FileReader(germanDescriptionFileName);
	    BufferedReader in = new BufferedReader(freader);
	    while ( (s = in.readLine())!= null )
	    {
	      germanPictureDescription = germanPictureDescription + s +"\n";
	    }
	    in.close();
	  }
	  catch (IOException e)
	  {
	    System.out.println("IOException " + e.toString() );
	  }  
  }
  else  
  {
  	germanPictureDescription	= fileObject.getName().substring(underscoreidx+1,dotidx);
  }  
  
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 20:53:00)
 */
public void computeNeighbourPaths() 
{
  String tempname = new String();
  boolean found = false;
  int idx = this.getIndexInParent();
  
 /*
 ListIterator e = (ListIterator) actualDirContent.getPictureHashMap().values().iterator();
 while(e.hasNext())
 {
	 System.out.println( (String)e.next());
 }
 */
  // ---------------------------------------------- 
  //first look for previous picture 
  // ---------------------------------------------- 
  while ( idx >0 & (found==false) )
  {
	tempname = actualDirContent.getPathFileObject().list()[idx-1];
	if (isValidPictureFile(tempname) == true )
	{
	  found =true;
	  hasPreviousPicture = true;
	  pathOfPreviousPicture = actualDirContent.getPathFileObject().listFiles()[idx-1].getPath();
	  int bilderrootidx = pathOfPreviousPicture.indexOf(BilderRoot);
	  pathOfPreviousPicture = pathOfPreviousPicture.substring(bilderrootidx+BilderRoot.length());
	 
	}
	idx--;
  }	  

  // ---------------------------------------------- 
  //then look for successing pictures 
  // ---------------------------------------------- 
  found=false;
  idx = this.getIndexInParent();
  if ( idx < actualDirContent.getPathFileObject().list().length -1  )
  { 
	while ( idx >= 0 & (found==false) )
	{
	  tempname = actualDirContent.getPathFileObject().list()[idx+1];
	  if (isValidPictureFile(tempname) == true )
	  {
	    found =true;
	    hasSubsequentPicture = true;
		pathOfNextPicture = actualDirContent.getPathFileObject().listFiles()[idx+1].getPath();
	    int bilderrootidx = pathOfNextPicture.indexOf(BilderRoot);
	    pathOfNextPicture = pathOfNextPicture.substring(bilderrootidx+BilderRoot.length());
	  }
	  idx++;
	}  
  }	   
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:35:31)
 */
public void execute(DirContent dcontent, String bRelPath) 
{
  // include Logic to extract description from corresponding txt file
  actualDirContent = dcontent;
 
  BilderRoot = actualDirContent.getBilderRoot();
  fileObject = new java.io.File(BilderRoot + bRelPath);
  
  //parentFileObject = new java.io.File(fileObject.getParent());
  pictureRelativePath = bRelPath;
  
  int underscoreidx	    = fileObject.getName().lastIndexOf("_");
  int dotidx  = fileObject.getName().lastIndexOf(".");
  pictureIdentifier = fileObject.getName().substring(0,underscoreidx);
  pictureNameWithoutExtension = fileObject.getName().substring(0,dotidx);
  computeGermanDescription();
  computeEnglishDescription();
  computeNeighbourPaths();
}
/**
 * Insert the method's description here.
 * Creation date: (02.01.2001 13:02:16)
 * @return urlaubsbilder.DirContent
 */
public DirContent getActualDirContent() {
	return actualDirContent;
}
/**
 * Insert the method's description here.
 * Creation date: (02.01.2001 13:19:17)
 * @return java.lang.String
 */
public java.lang.String getBilderRoot() {
	return BilderRoot;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:34:51)
 * @return java.lang.String
 */
public java.lang.String getEnglishPictureDescription() {
	return englishPictureDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:27:45)
 * @return java.io.File
 */
public java.io.File getFileObject() {
	return fileObject;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 14:33:16)
 * @return java.lang.String
 */
public java.lang.String getGermanPictureDescription() {
	return germanPictureDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 13:46:45)
 * @return int
 */
public int getIndexInParent() 
{
	int retval = -1 ;
	for (int i=0;i<actualDirContent.getPathFileObject().list().length;i++)
	{
	   if ( actualDirContent.getPathFileObject().listFiles()[i].equals(fileObject) )
	   {
	     retval = i;
	     break;
	   }
	}
	return retval;   
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 20:51:40)
 * @return java.lang.String
 */
public java.lang.String getPathOfNextPicture() {
	return pathOfNextPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 20:52:20)
 * @return java.lang.String
 */
public java.lang.String getPathOfPreviousPicture() {
	return pathOfPreviousPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:34:51)
 * @return java.lang.String
 */
public java.lang.String getPictureDescription() {
	return pictureDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (07.01.2001 22:21:22)
 * @return java.lang.String
 */
public java.lang.String getPictureIdentifier() {
	return pictureIdentifier;
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2000 16:59:59)
 * @return java.lang.String
 */
public static String getPictureNameFromFilename(String input)
{
	String retval = new String();
	int underscoreidx = input.lastIndexOf("_");
	int dotidx	      = input.lastIndexOf(".");
	if ( (underscoreidx > 0) & (dotidx > 0) &
	       (dotidx > underscoreidx)          )
	{
	  retval = input.substring(underscoreidx+1, dotidx);
	}   
	return retval;  
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 10:12:06)
 * @return java.lang.String
 */
public java.lang.String getPictureNameWithoutExtension() {
	return pictureNameWithoutExtension;
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 10:13:31)
 * @return java.lang.String
 */
public java.lang.String getPictureRelativePath() {
	return pictureRelativePath;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 21:09:22)
 * @return boolean
 */
public boolean hasPreviousPicture() {
	return hasPreviousPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 21:06:35)
 * @return boolean
 */
public boolean hasSubsequentPicture() {
	return hasSubsequentPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 14:10:58)
 * @return boolean
 * @param filename java.lang.String
 */
public static boolean isValidPictureFile(String filename) 
{
	  boolean retval = false;
	  int underscoreidx = filename.lastIndexOf("_");
	  int dotidx	    = filename.lastIndexOf(".");
	  boolean fileIsJpeg = filename.endsWith(".jpg");
	  
	  if ( (underscoreidx > 0) & (dotidx > 0) &
	       (dotidx > underscoreidx)           &
	       (fileIsJpeg)
	     )
	  {
		retval =true; 	     
	  }
	
	  return retval;
}
/**
 * Insert the method's description here.
 * Creation date: (02.01.2001 13:02:16)
 * @param newActualDirContent urlaubsbilder.DirContent
 */
public void setActualDirContent(DirContent newActualDirContent) {
	actualDirContent = newActualDirContent;
}
/**
 * Insert the method's description here.
 * Creation date: (02.01.2001 13:19:17)
 * @param newBilderRoot java.lang.String
 */
public void setBilderRoot(java.lang.String newBilderRoot) {
	BilderRoot = newBilderRoot;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:34:51)
 * @param newPictureDescription java.lang.String
 */
public void setEnglishPictureDescription(java.lang.String newPictureDescription) {
	englishPictureDescription = newPictureDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:27:45)
 * @param newFileObject java.io.File
 */
public void setFileObject(java.io.File newFileObject) {
	fileObject = newFileObject;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2000 14:33:16)
 * @param newGermanPictureDescription java.lang.String
 */
public void setGermanPictureDescription(java.lang.String newGermanPictureDescription) {
	germanPictureDescription = newGermanPictureDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 20:51:40)
 * @param newPathOfNextPicture java.lang.String
 */
public void setPathOfNextPicture(java.lang.String newPathOfNextPicture) {
	pathOfNextPicture = newPathOfNextPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2000 20:52:20)
 * @param newPathOfPreviousPicture java.lang.String
 */
public void setPathOfPreviousPicture(java.lang.String newPathOfPreviousPicture) {
	pathOfPreviousPicture = newPathOfPreviousPicture;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2000 13:34:51)
 * @param newPictureDescription java.lang.String
 */
public void setPictureDescription(java.lang.String newPictureDescription) {
	pictureDescription = newPictureDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (07.01.2001 22:21:22)
 * @param newPictureIdentifier java.lang.String
 */
void setPictureIdentifier(java.lang.String newPictureIdentifier) {
	pictureIdentifier = newPictureIdentifier;
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 10:12:06)
 * @param newPictureNameWithoutExtension java.lang.String
 */
void setPictureNameWithoutExtension(java.lang.String newPictureNameWithoutExtension) {
	pictureNameWithoutExtension = newPictureNameWithoutExtension;
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2000 10:13:31)
 * @param newPictureRelativePath java.lang.String
 */
void setPictureRelativePath(java.lang.String newPictureRelativePath) {
	pictureRelativePath = newPictureRelativePath;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2001 10:07:29)
 * @param newDescription java.lang.String
 */
public void storeDescriptionInFile(String newDescription, int language) 
{
	if (newDescription.length() > 0 )
	{
	  String DescriptionFileName = new String();
	  String textPath = new String();
	  switch (language)
	  {
	    case ENGLISH:
	    { 
	      DescriptionFileName = actualDirContent.getPathFileObject().getParentFile().getPath()+"\\text_en" + "\\" +pictureNameWithoutExtension + ".txt";
	      break;
	    }
	    case GERMAN:
	    { 
	      DescriptionFileName = actualDirContent.getPathFileObject().getParentFile().getPath()+"\\text_de" + "\\" +pictureNameWithoutExtension + ".txt";
	      break;
	    }
	  }   
   	try
	  {
	    FileWriter fwriter= new FileWriter(DescriptionFileName);
	    BufferedWriter out = new BufferedWriter(fwriter);
	    out.write(newDescription,0,newDescription.length());
	    out.flush();
	    out.close();
	  }
	  catch (IOException e)
	  {
	    System.out.println("IOException " + e.toString() );
	  }
	}  
   
}
}
