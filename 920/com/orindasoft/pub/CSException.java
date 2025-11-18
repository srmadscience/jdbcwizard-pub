/*
 * Copyright (C) 2025 David Rolfe
 *
 * Use of this source code is governed by an MIT
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.orindasoft.pub;

/**
* An extension of Exception used by this package.
*
* <br>(c) Copyright 2003 - 2015 Orinda Software Ltd<p>
*
* @version 6.0
* @author  <a href="http://www.orindasoft.com/?pdsrc=api" target="_blank" class=news>Orinda Software</a>
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




