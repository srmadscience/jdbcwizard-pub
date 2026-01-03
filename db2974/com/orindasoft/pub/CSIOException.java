package com.orindasoft.pub;

/**
* Thrown when we encounter an IOException
*
* <br>(c) Copyright 2003 - 2025 David Rolfe<p>
*
* @version 6.0
* @author  <a href="http://www.rolfe.ie/?pdsrc=api" target="_blank" </a>
* @since 6.0.2839 DB2 Compatible version created.
*/
public class CSIOException extends CSException
{

  /**
  * Default constructor
  */
  public CSIOException()
    {
    super();
    }
    
  /**
  * Constructor with parameters.
  * @param String theExceptionMessage An exception message
  */
  public CSIOException(String theExceptionMessage)
    {
    super(theExceptionMessage);
    }
}




