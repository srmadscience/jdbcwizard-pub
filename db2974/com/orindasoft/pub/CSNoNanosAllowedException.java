/*
 * Copyright (C) 2025 David Rolfe
 *
 * Use of this source code is governed by an MIT
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.orindasoft.pub;

/**
* Thrown when a Timestamp contains nanoseconds but the Oracle table/record
* it will be used against is DATA and doesn't support nanonseconds.
*
* <br>(c) Copyright 2003 - 2015 Orinda Software Ltd<p>
*
* @version 6.0
* @author  <a href="http://www.orindasoft.com/?pdsrc=api" target="_blank" class=news>Orinda Software</a>
* @since 6.0.2839 DB2 Compatible version created.
*/

public class CSNoNanosAllowedException  extends CSException
{
  public CSNoNanosAllowedException(String location
                                  ,java.sql.Timestamp ts)
  {
  super(location +":Nanoseconds found where none allowed. Value is :" + ts.toString());
  }
}

