/*
 * Copyright (C) 2025 David Rolfe
 *
 * Use of this source code is governed by an MIT
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

 package com.orindasoft.pub;

/**
* Thrown when an attempt to turn a String into a number fails
*
* <br>(c) Copyright 2003 - 2015 Orinda Software Ltd<p>
*
* @version 6.0
* @author  <a href="http://www.orindasoft.com/?pdsrc=api" target="_blank" class=news>Orinda Software</a>
*/
public class CSNumberFormatException extends CSException
{

public CSNumberFormatException(String callLocation
                              ,String value)
  {
  super(callLocation +":"+value);
  }
}

