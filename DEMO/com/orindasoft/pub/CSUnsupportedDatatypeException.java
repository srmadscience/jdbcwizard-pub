package com.orindasoft.pub;

/**
* Thrown when an attempt is made to retrieve a value from a column has an unsupported datatype
*
* <br>(c) Copyright 2003 - 2025 David Rolfe<p>
*
* @version 6.0
* @author  <a href="http://www.rolfe.ie/?pdsrc=api" target="_blank" </a>
*/
public class CSUnsupportedDatatypeException extends CSException
{

  /**
  * The name of the datatype that is not supported.
  */
  String theUnsupportedDatatype = "";

  /**
  * Default constructor
  */
  public CSUnsupportedDatatypeException()
  {
  super();
  }

  /**
  * Constructor with parameters.
  * @param String theExceptionMessage An exception message
  * @param String theUnsupportedDatatype The name of the unsupported data type.
  */
  public CSUnsupportedDatatypeException(String theExceptionMessage
                                       ,String theUnsupportedDatatype
                                       )
  {
  super(theExceptionMessage);
  this.theUnsupportedDatatype = new String(theUnsupportedDatatype);
  }
}




