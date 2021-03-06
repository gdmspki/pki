// --- BEGIN COPYRIGHT BLOCK ---
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; version 2 of the License.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, write to the Free Software Foundation, Inc.,
// 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
//
// (C) 2007 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---
package com.netscape.admin.certsrv.status;

import java.text.*;
import java.util.*;

/**
 * Interface for the log parser
 *
 * @author Jack Pan-Chen
 * @version $Revision$, $Date$
 * @date	 	02/04/97
 */
public interface ILogParser {

    /**
     * Parse the log entry into logical data display segments to be displayed
     * in the table.
     * Currently, only String object is supported by the log viewer.
     */
    public Vector parse(Object logEntry) throws ParseException;
}