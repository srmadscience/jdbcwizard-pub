package com.orindasoft.pub;

/**
* An extension of Exception used by this package.
*
* <br>(c) Copyright 2003 - 2025 David Rolfe<p>
*
* @version 6.0
* @author  <a href="http://www.rolfe.ie/?pdsrc=api" target="_blank" </a>
*/
public class CSException extends Exception
{

  /**
  * Default constructor
  */
  public CSException()
  {
  super();
  }
  
  /**
  * Default constructor that takes a String
  */
  public CSException(String theExceptionMessage)
  {
  super(theExceptionMessage);
  }
}




