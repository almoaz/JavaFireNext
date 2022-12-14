/*
 MIT License
 Copyright (c) 2022 Mahfuz Salehin Moaz

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package FireNext.developer.table;

import static FireNext.developer.table.__init__.*;

public class __delete__col__{
    public static String __delete__col__(String Table_Name, String Column_Name)
    {
        String table = __file__read__.__file__read__(Table_Name);
        if (table.equals("false"))
        {
            return "'error' " + '[' + Table_Name + ']' + " table not found";
        }
        else
        {
            int queryPosition = 0;
            String queryPermit = "false";
            String updateData = "false";
            String value = "";
            String updateDB = "";
            for (int x = 0; x <= table.length(); x++) {
                if (queryPermit.equals("false") && table.charAt(x) == col__start__tag || queryPermit.equals("null") && table.charAt(x) == col__start__tag)
                {
                    updateDB = updateDB + table.charAt(x);
                }
                if (queryPermit.equals("null") && table.charAt(x) != col__end__tag)
                {
                    updateDB = updateDB + table.charAt(x);
                }
                if (table.charAt(x) != col__start__tag && table.charAt(x) != cel__end__tag && table.charAt(x) != col__end__tag && queryPermit.equals("false"))
                {
                    value = value + table.charAt(x);
                }
                else if (table.charAt(x) == cel__end__tag && queryPermit.equals("false")) {
                    if (value.equals(Column_Name))
                    {
                        queryPosition = queryPosition + 1;
                        queryPermit = "null";
                        value = "";
                    }
                    else
                    {
                        queryPosition = queryPosition + 1;
                        updateDB = updateDB + value + cel__end__tag;
                        value = "" ;
                    }

                }
                else if (table.charAt(x) == col__end__tag && queryPermit.equals("false")) {
                    if (value.equals(Column_Name))
                    {
                        queryPosition = queryPosition + 1;
                        updateDB = updateDB.substring(0,updateDB.length()-1);
                        queryPermit = "null";
                        value = "" ;
                    }
                    else
                    {
                        return "'error' [" + Column_Name + "] column name not found";
                    }

                }
                if (table.charAt(x) == col__end__tag && queryPermit.equals("null"))
                {
                    updateDB = updateDB + value + col__end__tag;
                    queryPermit = "true";
                } else if (queryPermit.equals("true")) {
                    value = value + table.charAt(x);
                    if (table.charAt(x) == row__end__tag)
                    {
                        int dataPosition = 0;
                        String data = "";

                        for (int x1 = 0; x1 <= value.length(); x1++)
                        {
                            if (value.charAt(x1) != row__start__tag && value.charAt(x1) != cel__end__tag && value.charAt(x1) != row__end__tag)
                            {
                                data = data + value.charAt(x1);
                            }
                            if (value.charAt(x1) == row__start__tag)
                            {
                                updateDB = updateDB + value.charAt(x1);
                            }
                            else if (value.charAt(x1) == cel__end__tag) {
                                dataPosition = dataPosition + 1;
                                if (dataPosition == queryPosition) {
                                    updateDB = updateDB;
                                    data = "";
                                }
                                else
                                {
                                    updateDB = updateDB + data + cel__end__tag;
                                    data = "";
                                }

                            }
                            if (x1 == value.length()-1)
                            {
                                dataPosition = dataPosition + 1;
                                if (dataPosition == queryPosition) {
                                    updateDB = updateDB.substring(0,updateDB.length()-1)+row__end__tag;
                                    data = "";
                                }
                                else
                                {
                                    updateDB = updateDB + data + row__end__tag;
                                    data = "";
                                }
                                break;
                            }
                        }
                        value = "";
                    }

                }
                if (x == table.length()-1)
                {
                    __table__writer__.__table__writer__(Table_Name,updateDB);
                    return "true";
                }


            }
        }
        return "true";
    }
}
