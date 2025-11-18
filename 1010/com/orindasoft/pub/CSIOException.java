/*
 * Copyright (C) 2025 David Rolfe
 *
 * Use of this source code is governed by an MIT
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.orindasoft.pub;

/**
* Thrown when we encounter an IOException
*
* <br>(c) Copyright 2003 - 2015 Orinda Software Ltd<p>
*
* @version 6.0
* @author  <a href="http://www.orindasoft.com/?pdsrc=api" target="_blank" class=news>Orinda Software</a>
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




