
package ua.pp.iserf.util;

import java.io.File;


/**
 * BeehiveZ is a business process model and instance management system.
 * Copyright (C) 2011  
 * Institute of Information System and Engineering, School of Software, Tsinghua University,
 * Beijing, China
 *
 * Contact: jintao05@gmail.com 
 *
 * This program is a free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation with the version of 2.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */


/**
 * @author Tao Jin
 * 
 */

public class FileSizeUtil{
  public static float getFileSizeInMB(String fileName) {
    float ret = getFileSizeInBytes(fileName);
    ret = ret / (float) (1024 * 1024);
    return ret;
  }
  public static long getFileSizeInBytes(String fileName) {
    long ret = 0;
    File f = new File(fileName);
    if (f.isFile()) {
      return f.length();
    } else if (f.isDirectory()) {
      File[] contents = f.listFiles();
      for (int i = 0; i < contents.length; i++) {
        if (contents[i].isFile()) {
          ret += contents[i].length();
        } else if (contents[i].isDirectory())
          ret += getFileSizeInBytes(contents[i].getPath());
      }
    }
    return ret;
  }
}
