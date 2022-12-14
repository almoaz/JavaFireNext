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

import java.util.ArrayList;
import java.util.List;

public class __search__col__data__ {
    public static List<Object> __search__col__data__(String Table_Name, String Column_Name) {
        String value = "";
        List<Object> returnValue = new ArrayList<>();
        String table = __file__read__.__file__read__(Table_Name);
        if (table.equals("false")) {
            returnValue.add("error");
            return returnValue;
        } else {
            int queryPosition = 0;
            int Cell_Size = 0;
            String queryPermit = "false";


            for (int x = 0; x <= table.length(); x++) {
                if (table.charAt(x) != col__start__tag && table.charAt(x) != cel__end__tag && table.charAt(x) != col__end__tag && queryPermit.equals("false")) {
                    value = value + table.charAt(x);
                } else if (table.charAt(x) == cel__end__tag && queryPermit.equals("false")) {
                    if (value.equals(Column_Name)) {
                        queryPosition = queryPosition + 1;
                        queryPermit = "null";
                        value = "";
                    } else {
                        queryPosition = queryPosition + 1;
                        value = "";
                    }

                } else if (table.charAt(x) == col__end__tag && queryPermit.equals("false")) {
                    if (value.equals(Column_Name)) {
                        queryPosition = queryPosition + 1;
                        queryPermit = "null";
                        value = "";
                    } else {
                        returnValue.add("error");
                        return returnValue;
                    }

                }
                if (table.charAt(x) == col__end__tag && queryPermit.equals("null")) {
                    queryPermit = "true";
                } else if (queryPermit.equals("true")) {
                    value = value + table.charAt(x);

                    if (table.charAt(x) == row__end__tag) {
                        if (Cell_Size == 0) {
                            int dataPosition = 0;
                            String value2 = "";

                            for (int x1 = 0; x1 <= table.length(); x1++) {
                                if (table.charAt(x1) != cel__end__tag && table.charAt(x1) != col__start__tag && table.charAt(x1) != col__end__tag && table.charAt(x1) != row__start__tag && table.charAt(x1) != row__end__tag) {
                                    value2 = value2 + table.charAt(x1);
                                } else if (table.charAt(x1) == cel__end__tag) {
                                    dataPosition = dataPosition + 1;
                                    if (dataPosition == queryPosition) {
                                        if (value2.length() > Cell_Size) {
                                            Cell_Size = value2.length();
                                        }
                                    }
                                    value2 = "";
                                } else if (table.charAt(x1) == col__end__tag || table.charAt(x1) == row__end__tag) {
                                    dataPosition = dataPosition + 1;
                                    if (dataPosition == queryPosition) {
                                        if (value2.length() > Cell_Size) {
                                            Cell_Size = value2.length();
                                        }
                                    }
                                    value2 = "";
                                    dataPosition = 0;
                                }
                                if (x1 == table.length() - 1) {
                                    break;
                                }
                            }
                        }
                        int dataPosition = 0;
                        String data = "";

                        for (int x1 = 0; x1 <= value.length(); x1++) {
                            if (value.charAt(x1) != row__start__tag && value.charAt(x1) != cel__end__tag && value.charAt(x1) != row__end__tag) {
                                data = data + value.charAt(x1);
                            } else if (value.charAt(x1) == cel__end__tag) {
                                dataPosition = dataPosition + 1;
                                if (dataPosition == queryPosition) {
                                    if (returnValue.isEmpty()) {
                                        returnValue.add(data);

                                    } else {
                                        returnValue.add(data);
                                    }
                                    break;
                                } else {
                                    data = "";
                                }
                            } else if (value.charAt(x1) == row__end__tag) {
                                dataPosition = dataPosition + 1;
                                if (dataPosition == queryPosition) {
                                    if (returnValue.isEmpty()) {
                                        returnValue.add(data);

                                    } else {
                                        returnValue.add(data);
                                    }
                                    break;
                                } else {
                                    data = "";
                                }
                            }
                            if (x1 == value.length() - 1) {
                                break;
                            }
                        }
                        value = "";

                    }
                }
                if (x == table.length() - 1) {

                    return returnValue;
                }


            }
        }
        returnValue.add("false");
        return returnValue;
    }
}
