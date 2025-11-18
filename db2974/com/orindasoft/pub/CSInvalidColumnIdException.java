/*
 * Copyright (C) 2025 David Rolfe
 *
 * Use of this source code is governed by an MIT
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.orindasoft.pub;

/**
* Thrown when an attempt is made to retrieve a value from a column that does not exist.
*
* <br>(c) Copyright 2003 - 2015 Orinda Software Ltd<p>
*
* @see ReadOnlyRowSet
* @version 6.0
* @author  <a href="http://www.orindasoft.com/?pdsrc=api" target="_blank" class=news>Orinda Software</a>
* @since 6.0.2839 DB2 Compatible version created.
*/
public class CSInvalidColumnIdException extends CSException
{
  int invalidColumnId = 0;
  
  /**
  * Default constructor
  */
  public CSInvalidColumnIdException()
  {
  super();
  }
  
  public CSInvalidColumnIdException(String theExceptionMessage
                                   ,int    theInvalidColumnId)
  {
  super(theExceptionMessage);
  this.invalidColumnId = theInvalidColumnId;
  }
}




