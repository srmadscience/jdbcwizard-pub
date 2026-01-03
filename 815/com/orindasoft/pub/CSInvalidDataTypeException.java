package com.orindasoft.pub;

/**
* Thrown when an we encounter a value whose data type is unsupported
*
* <br>(c) Copyright 2003 - 2025 David Rolfe<p>
*
* @version 6.0
* @author  <a href="http://www.rolfe.ie/?pdsrc=api" target="_blank" </a>
*/
public class CSInvalidDataTypeException extends CSException
{
  /**
  * Data type we we trying to convert from
  */
  String theCasterDatatype = "";

  /**
  * Data type we we trying to convert to
  */
  String theCasteeDatatype = "";

  /**
  * Default constructor
  */
  public CSInvalidDataTypeException()
  {
  super();
  }

  /**
  * Thrown when an we encounter a value whose data type is unsupported
  *
  */
  public CSInvalidDataTypeException(String theExceptionMessage
                                   ,String theCasterDatatype
                                   ,String theCasteeDatatype)
  {
  super(theExceptionMessage);
  this.theCasterDatatype = new String(theCasterDatatype);
  this.theCasteeDatatype = new String(theCasteeDatatype);
  }
}



